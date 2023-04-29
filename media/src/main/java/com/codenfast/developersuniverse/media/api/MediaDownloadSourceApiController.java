package com.codenfast.developersuniverse.media.api;

import com.codenfast.developersuniverse.entitydto.media.MediaDownloadSourceDto;
import com.codenfast.developersuniverse.media.controller.MediaDownloadSourceController;
import com.codenfast.developersuniverse.model.CodenfastSecurityException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.service.EncryptService;
import com.codenfast.developersuniverse.utils.StringConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "api/media-download-source", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class MediaDownloadSourceApiController {

    private final MediaDownloadSourceController mediaDownloadSourceController;
    private final EncryptService encryptService;

    @PostMapping("save")
    public String save(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, mediaDownloadSourceController.save(encryptService.readValue(data, encryptData, MediaDownloadSourceDto.class)));
    }

    @PutMapping("update")
    public String update(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, mediaDownloadSourceController.update(encryptService.readValue(data, encryptData, MediaDownloadSourceDto.class)));
    }

    @DeleteMapping("delete/{id}")
    public String delete(@RequestHeader(StringConstant.AHEADER) String data, @PathVariable String id) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, mediaDownloadSourceController.delete(id));
    }

    @PostMapping("grid")
    public String grid(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, mediaDownloadSourceController.grid(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }

    @PostMapping("/grid-table-model")
    public String gridTableModel(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, mediaDownloadSourceController.gridTableModel(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }
}
