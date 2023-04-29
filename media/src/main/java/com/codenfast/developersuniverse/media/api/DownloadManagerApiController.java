package com.codenfast.developersuniverse.media.api;

import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.media.controller.DownloadManagerController;
import com.codenfast.developersuniverse.model.CodenfastSecurityException;
import com.codenfast.developersuniverse.service.EncryptService;
import com.codenfast.developersuniverse.utils.StringConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "api/download-manager", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class DownloadManagerApiController {

    private final DownloadManagerController downloadManagerController;
    private final EncryptService encryptService;

    @PostMapping("/add-download-queue")
    public String addDownloadQueue(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, downloadManagerController.addDownloadQueue(encryptService.readValue(data, encryptData, MediaDto.class)));
    }

    @PostMapping("/generate-media-from-url")
    public String generateMediaFromUrl(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, downloadManagerController.generateMediaFromUrl(encryptService.readValue(data, encryptData, MediaDto.class)));
    }

    @PostMapping("/download-media")
    public String downloadMedia(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, downloadManagerController.downloadMedia(encryptService.readValue(data, encryptData, MediaDto.class)));
    }

    @DeleteMapping("/id/{id}/cancel")
    public String cancelMedia(@RequestHeader(StringConstant.AHEADER) String data, @PathVariable String id) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, downloadManagerController.cancelMedia(id));
    }

    @PutMapping("/id/{id}retry-download-process/")
    public String retryMedia(@RequestHeader(StringConstant.AHEADER) String data, @PathVariable String id) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, downloadManagerController.retryMedia(id));
    }

    @GetMapping
    public String waitingMediaList(@RequestHeader(StringConstant.AHEADER) String data) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, downloadManagerController.waitingMediaList());
    }
}
