package com.codenfast.developersuniverse.electronicarchive.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.earchive.ElectronicArchive;
import com.codenfast.developersuniverse.electronicarchive.service.ElectronicArchiveService;
import com.codenfast.developersuniverse.entitydto.earchvive.ElectronicArchiveDto;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.ElectronicArchiveProcessRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequestMapping(path = "electronic-archive")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class ElectronicArchiveController {

    private final ElectronicArchiveService electronicArchiveService;

//    @PostMapping("get-folder-content")
//    public ResponseEntity<List<ElectronicArchiveDto>> getFolderContent(
//            @RequestBody ElectronicArchiveProcessRequest processRequest) {
//        try {
//            EntityToDto<ElectronicArchiveDto> entityToDto = new EntityToDto<>();
//            List<ElectronicArchive> list =
//                    electronicArchiveService.getFolderContent(
//                            processRequest.getElectronicArchiveLoginModel(),
//                            EntityMapper.INSTANCE.map(processRequest.getFolder()));
//            List<ElectronicArchiveDto> resultList = new java.util.ArrayList<>();
//            for (ElectronicArchive entity : list) {
//                resultList.add(entityToDto.convertToDto(entity, ElectronicArchiveDto.class));
//            }
//            return new ResponseEntity<>(resultList, HttpStatus.OK);
//        } catch (CodenfastException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
//        }
//    }

    @PostMapping("upload")
    public ResponseEntity<ElectronicArchiveDto> upload(
            @RequestBody ElectronicArchiveProcessRequest processRequest) {
        try {
            ElectronicArchive entity =
                    electronicArchiveService.upload(
                            processRequest.getElectronicArchiveLoginModel(),
                            EntityMapper.INSTANCE.map(processRequest.getFolder()),
                            EntityMapper.INSTANCE.map(processRequest.getFile()));
            ElectronicArchiveDto result = new EntityToDto<ElectronicArchiveDto>().convertToDto(entity, ElectronicArchiveDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<ElectronicArchiveDto> delete(
            @RequestBody ElectronicArchiveProcessRequest processRequest) {
        try {
            ElectronicArchive entity = electronicArchiveService.delete(
                    processRequest.getElectronicArchiveLoginModel(),
                    EntityMapper.INSTANCE.map(processRequest.getFile()));
            ElectronicArchiveDto result = new EntityToDto<ElectronicArchiveDto>().convertToDto(entity, ElectronicArchiveDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("download")
    public CompletableFuture<Void> download(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody ElectronicArchiveProcessRequest processRequest) {
        try {
            return electronicArchiveService.download(
                    processRequest.getElectronicArchiveLoginModel(),
                    httpServletRequest, httpServletResponse,
                    EntityMapper.INSTANCE.map(processRequest.getFile()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
