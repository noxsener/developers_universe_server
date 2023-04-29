package com.codenfast.developersuniverse.media.api;

import com.codenfast.developersuniverse.entitydto.music.MediaGenreDto;
import com.codenfast.developersuniverse.media.controller.MediaGenreController;
import com.codenfast.developersuniverse.model.CodenfastSecurityException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.service.EncryptService;
import com.codenfast.developersuniverse.utils.StringConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

@RequestMapping(path = "api/media-genre", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class MediaGenreApiController {

    private final MediaGenreController mediaGenreController;
    private final EncryptService encryptService;

    @PostMapping("save")
    public String save(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, mediaGenreController.save(encryptService.readValue(data, encryptData, MediaGenreDto.class)));
    }

    @PutMapping("update")
    public String update(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, mediaGenreController.update(encryptService.readValue(data, encryptData, MediaGenreDto.class)));
    }

    @DeleteMapping("delete/{id}")
    public String delete(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @PathVariable String id) throws JsonProcessingException, CodenfastSecurityException {
        response.addHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaGenreController.delete(id));
    }

    @PostMapping("grid")
    public String grid(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.addHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaGenreController.grid(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }

    @PostMapping("/grid-table-model")
    public String gridTableModel(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.addHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, mediaGenreController.gridTableModel(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }
}
