package com.codenfast.developersuniverse.media.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.media.MediaDownloadSource;
import com.codenfast.developersuniverse.entitydto.media.MediaDownloadSourceDto;
import com.codenfast.developersuniverse.media.service.MediaDownloadSourceService;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(path = "media-download-source")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class MediaDownloadSourceController {

    private final MediaDownloadSourceService service;

    @PostMapping("save")
    public ResponseEntity<MediaDownloadSourceDto> save(@RequestBody MediaDownloadSourceDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            MediaDownloadSource entity = entityMapper.map(dto);
            entity = service.save(entity);
            MediaDownloadSourceDto result = new EntityToDto<MediaDownloadSourceDto>().convertToDto(entity, MediaDownloadSourceDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("update")
    public ResponseEntity<MediaDownloadSourceDto> update(@RequestBody MediaDownloadSourceDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            MediaDownloadSource entity = entityMapper.map(dto);
            entity = service.update(entity);
            MediaDownloadSourceDto result = new EntityToDto<MediaDownloadSourceDto>().convertToDto(entity, MediaDownloadSourceDto.class);
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
            MediaDownloadSource entity = service.delete(id);
            return new ResponseEntity<>(entity.getPassive(), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("grid")
    public ResponseEntity<List<MediaDownloadSourceDto>> grid(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<MediaDownloadSourceDto> entityToDto = new EntityToDto<>();
            List<MediaDownloadSource> list = service.grid(requestGrid);
            List<MediaDownloadSourceDto> resultList = new java.util.ArrayList<>();
            for (MediaDownloadSource entity : list) {
                resultList.add(entityToDto.convertToDto(entity, MediaDownloadSourceDto.class, requestGrid.getPropertyList()));
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
    public ResponseEntity<TableModel<MediaDownloadSourceDto>> gridTableModel(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<MediaDownloadSourceDto> entityToDto = new EntityToDto<>();
            TableModel<MediaDownloadSource> tableModel = service.gridTableModel(requestGrid);
            TableModel<MediaDownloadSourceDto> result = new TableModel<>();
            result.setCount(tableModel.getCount());
            List<MediaDownloadSourceDto> resultList = new java.util.ArrayList<>();
            for (MediaDownloadSource entity : tableModel.getData()) {
                resultList.add(entityToDto.convertToDto(entity, MediaDownloadSourceDto.class, requestGrid.getPropertyList()));
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
}
