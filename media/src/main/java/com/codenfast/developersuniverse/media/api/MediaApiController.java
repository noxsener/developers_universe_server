package com.codenfast.developersuniverse.media.api;

import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.media.controller.MediaController;
import com.codenfast.developersuniverse.model.CodenfastSecurityException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.service.EncryptService;
import com.codenfast.developersuniverse.utils.StringConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RequestMapping(path = "api/media", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class MediaApiController {

    private final MediaController mediaController;
    private final EncryptService encryptService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD}, path = "{id}")
    @Async
    public CompletableFuture<Void> download(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        return mediaController.download(request, response, id);
    }

    @GetMapping(path = "id/{id}")
    public String getMedia(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @PathVariable String id) throws JsonProcessingException, CodenfastSecurityException {
        response.setHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaController.getMedia(id));
    }

    @PostMapping("save")
    public String save(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.setHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaController.save(encryptService.readValue(data, encryptData, MediaDto.class)));
    }

    @PutMapping("update")
    public String update(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.setHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaController.update(encryptService.readValue(data, encryptData, MediaDto.class)));
    }

    @DeleteMapping("delete/{id}")
    public String delete(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @PathVariable String id) throws JsonProcessingException, CodenfastSecurityException {
        response.setHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaController.delete(id));
    }

    @PostMapping("grid")
    public String grid(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.setHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaController.grid(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }

    @PostMapping("/grid-table-model")
    public String gridTableModel(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.setHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaController.gridTableModel(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }

    @GetMapping(path = "/media-file-index-list", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMediaFileIndexList(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data) throws CodenfastSecurityException, JsonProcessingException {
        response.setHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaController.getMediaFileIndexList());
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD}, path = "/media-file-index/{mediaName}")
    @Async
    public CompletableFuture<Void> downloadMediaFileList(HttpServletRequest request, HttpServletResponse response, @PathVariable String mediaName) {
        return mediaController.downloadMediaFileList(request, response, mediaName);
    }
}

