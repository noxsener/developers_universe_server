package com.codenfast.developersuniverse.electronicarchive.service;

import com.codenfast.developersuniverse.common.entity.earchive.ElectronicArchive;
import com.codenfast.developersuniverse.model.ElectronicArchiveLoginModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import net.schmizz.sshj.xfer.FileSystemFile;
import net.schmizz.sshj.xfer.InMemorySourceFile;
import net.schmizz.sshj.xfer.LocalSourceFile;
import org.apache.commons.io.FileUtils;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class FtpServer implements ElectronicArchiveService {

    private final static String TEMP_FOLDER = "temp";

//    private FTPClient connect(ElectronicArchiveLoginModel electronicArchiveLoginModel) throws IOException {
//        FTPClient ftpClient = new FTPClient();
//        ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
//        ftpClient.connect(electronicArchiveLoginModel.getUrl(), electronicArchiveLoginModel.getPort());
//        int reply = ftpClient.getReplyCode();
//        if (!FTPReply.isPositiveCompletion(reply)) {
//            ftpClient.disconnect();
//            throw new IOException("Exception in connecting to FTP Server");
//        }
//        ftpClient.login(electronicArchiveLoginModel.getUsername(), electronicArchiveLoginModel.getPassword());
//        return ftpClient;
//    }
//
//    private void disconnect(FTPClient ftpClient) throws IOException {
//        if (ftpClient != null && ftpClient.isConnected()) {
//            ftpClient.logout();
//            ftpClient.disconnect();
//        }
//    }

//    @Override
//    public List<ElectronicArchive> getFolderContent(ElectronicArchiveLoginModel electronicArchiveLoginModel, ElectronicArchive folder) throws IOException {
//        if (!folder.getIsFolder()) {
//            throw new IOException("Folder is not valid: " + folder.getFileLocation());
//        }
//        FileSystemManager manager = VFS.getManager();
//        StringBuilder remoteFileStringBuilder = new StringBuilder();
//        remoteFileStringBuilder.append("sftp://")
//                .append(electronicArchiveLoginModel.getUsername())
//                .append(':')
//                .append(electronicArchiveLoginModel.getPassword())
//                .append('@')
//                .append(electronicArchiveLoginModel.getUrl());
//
//        if(electronicArchiveLoginModel.getPort() != null) {
//            remoteFileStringBuilder.append(':')
//                    .append(electronicArchiveLoginModel.getPort());
//        }
//
//        remoteFileStringBuilder.append('/')
//                .append(folder.getFileLocation());
//        try (FileObject folderFileObject = manager.resolveFile(remoteFileStringBuilder.toString())) {
//            List<ElectronicArchive> electronicArchiveList = new ArrayList<>();
//            FileObject[] fileObjectArr = folderFileObject.findFiles(new AllFileSelector());
//            for(FileObject fileObject : fileObjectArr) {
//                ElectronicArchive electronicArchive = new ElectronicArchive();
//                electronicArchive.setName(fileObject.getName().getBaseName());
//                electronicArchive.setIsFolder(fileObject.isFolder());
//                electronicArchiveList.add(electronicArchive);
//            }
//            return electronicArchiveList;
//        } finally {
////            manager.close();
//        }
//    }

    private SSHClient setupSshj(ElectronicArchiveLoginModel electronicArchiveLoginModel) throws IOException {
        SSHClient client = new SSHClient();
        client.addHostKeyVerifier(new PromiscuousVerifier());
        client.connect(electronicArchiveLoginModel.getUrl());
        client.authPassword(electronicArchiveLoginModel.getUsername(), electronicArchiveLoginModel.getPassword());
        client.loadKnownHosts();
        return client;
    }

    @Override
    public ElectronicArchive upload(ElectronicArchiveLoginModel electronicArchiveLoginModel, ElectronicArchive folder, ElectronicArchive file) throws IOException {
        if (!folder.getIsFolder()) {
            throw new IOException("Folder is not valid: " + folder.getFileLocation());
        }
        String randomFileName = UUID.randomUUID()+"_"+file.getFileName();
        File tempFile = new File(TEMP_FOLDER, randomFileName);
        String fileStringName = folder.getFileLocation()+"/"+randomFileName;
        FileUtils.writeByteArrayToFile(tempFile, Base64.getDecoder().decode(file.getFileBase64()));
        LocalSourceFile localSourceFile = new FileSystemFile(tempFile);
        try(SSHClient sshClient = setupSshj(electronicArchiveLoginModel); SFTPClient sftpClient = sshClient.newSFTPClient()) {
            sftpClient.mkdirs(folder.getFileLocation());
            sftpClient.put(localSourceFile, folder.getFileLocation());
            file.setFileLocation(fileStringName);
        } finally {
            FileUtils.deleteQuietly(tempFile);
        }
        return file;
    }

    @Override
    public ElectronicArchive delete(ElectronicArchiveLoginModel electronicArchiveLoginModel, ElectronicArchive file) throws IOException {
        SSHClient sshClient = setupSshj(electronicArchiveLoginModel);
        try(SFTPClient sftpClient = sshClient.newSFTPClient()) {
            sftpClient.rm(file.getFileLocation());
        } finally {
            sshClient.disconnect();
            sshClient.close();
        }
        return file;
    }

    @Override
    public CompletableFuture<Void> download(ElectronicArchiveLoginModel electronicArchiveLoginModel, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ElectronicArchive file) throws IOException {
        return CompletableFuture.runAsync(() -> {
            try {
                File tempFile = new File(TEMP_FOLDER, file.getFileName());
                try(SSHClient sshClient = setupSshj(electronicArchiveLoginModel); SFTPClient sftpClient = sshClient.newSFTPClient(); OutputStream os = httpServletResponse.getOutputStream()) {
                    sftpClient.get(file.getFileLocation(), tempFile.getAbsolutePath());
                    httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + file.getFileName());
                    httpServletResponse.setHeader("Content-Type",new Tika().detect(tempFile));
                    os.write(FileUtils.readFileToByteArray(tempFile));
                } finally {
                    FileUtils.deleteQuietly(tempFile);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
