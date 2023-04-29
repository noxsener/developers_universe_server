package com.codenfast.developersuniverse.media.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.media.service.MediaService;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequestMapping(path = "media")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class MediaController {

    private final MediaService service;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD}, path = "{id}")
    @Async
    public CompletableFuture<Void> download(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        return service.download(request, response, id);
    }


    @GetMapping(path = "id/{id}")
    public ResponseEntity<MediaDto> getMedia(@PathVariable String id) {
        try {
            Media media = service.getMedia(id);
            EntityToDto<MediaDto> entityToDto = new EntityToDto<>();
            return new ResponseEntity<>(entityToDto.convertToDto(media, MediaDto.class), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("save")
    public ResponseEntity<MediaDto> save(
            @RequestBody MediaDto dto
    ) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            Media entity = entityMapper.map(dto);
            entity = service.save(entity);
            MediaDto result = new EntityToDto<MediaDto>().convertToDto(entity, MediaDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("update")
    public ResponseEntity<MediaDto> update(@RequestBody MediaDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            Media entity = entityMapper.map(dto);
            entity = service.update(entity);
            MediaDto result = new EntityToDto<MediaDto>().convertToDto(entity, MediaDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        try {
            Media entity = service.delete(id);
            return new ResponseEntity<>(entity.getPassive(), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("grid")
    public ResponseEntity<List<MediaDto>> grid(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<MediaDto> entityToDto = new EntityToDto<>();
            List<Media> list = service.grid(requestGrid);
            List<MediaDto> resultList = new java.util.ArrayList<>();
            for (Media entity : list) {
                resultList.add(entityToDto.convertToDto(entity, MediaDto.class, requestGrid.getPropertyList()));
            }
            return new ResponseEntity<>(resultList, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("/grid-table-model")
    public ResponseEntity<TableModel<MediaDto>> gridTableModel(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<MediaDto> entityToDto = new EntityToDto<>();
            TableModel<Media> tableModel = service.gridTableModel(requestGrid);
            TableModel<MediaDto> result = new TableModel<>();
            result.setCount(tableModel.getCount());
            List<MediaDto> resultList = new java.util.ArrayList<>();
            for (Media entity : tableModel.getData()) {
                resultList.add(entityToDto.convertToDto(entity, MediaDto.class, requestGrid.getPropertyList()));
            }
            result.setData(resultList);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping(value = "/media-file-index-list")
    public ResponseEntity<List<MediaDto>> getMediaFileIndexList() {
        try {
            EntityToDto<MediaDto> entityToDto = new EntityToDto<>();
            List<MediaDto> resultList = new java.util.ArrayList<>();
            for (Media entity : service.getMediaFileIndexList()) {
                resultList.add(entityToDto.convertToDto(entity, MediaDto.class));
            }
            return new ResponseEntity<>(resultList, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD}, path = "/media-index-file/{mediaName}")
    @Async
    public CompletableFuture<Void> downloadMediaFileList(HttpServletRequest request, HttpServletResponse response, @PathVariable String mediaName) {
        return service.downloadMediaFileList(request, response, mediaName);
    }
}
