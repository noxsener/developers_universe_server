package com.codenfast.developersuniverse.media.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.download.DownloadIntent;
import com.codenfast.developersuniverse.entitydto.download.DownloadIntentDto;
import com.codenfast.developersuniverse.media.service.DownloadIntentService;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(path = "download-intent")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class DownloadIntentController {

    private final DownloadIntentService service;

    @PostMapping("save")
    public ResponseEntity<DownloadIntentDto> save(@RequestBody DownloadIntentDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            DownloadIntent entity = entityMapper.map(dto);
            entity = service.save(entity);
            DownloadIntentDto result = new EntityToDto<DownloadIntentDto>().convertToDto(entity, DownloadIntentDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("update")
    public ResponseEntity<DownloadIntentDto> update(@RequestBody DownloadIntentDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            DownloadIntent entity = entityMapper.map(dto);
            entity = service.update(entity);
            DownloadIntentDto result = new EntityToDto<DownloadIntentDto>().convertToDto(entity, DownloadIntentDto.class);
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
            DownloadIntent entity = service.delete(id);
            return new ResponseEntity<>(entity.getPassive(), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("grid")
    public ResponseEntity<List<DownloadIntentDto>> grid(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<DownloadIntentDto> entityToDto = new EntityToDto<>();
            List<DownloadIntent> list = service.grid(requestGrid);
            List<DownloadIntentDto> resultList = new java.util.ArrayList<>();
            for (DownloadIntent entity : list) {
                resultList.add(entityToDto.convertToDto(entity, DownloadIntentDto.class, requestGrid.getPropertyList()));
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
    public ResponseEntity<TableModel<DownloadIntentDto>> gridTableModel(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<DownloadIntentDto> entityToDto = new EntityToDto<>();
            TableModel<DownloadIntent> tableModel = service.gridTableModel(requestGrid);
            TableModel<DownloadIntentDto> result = new TableModel<>();
            result.setCount(tableModel.getCount());
            List<DownloadIntentDto> resultList = new java.util.ArrayList<>();
            for (DownloadIntent entity : tableModel.getData()) {
                resultList.add(entityToDto.convertToDto(entity, DownloadIntentDto.class, requestGrid.getPropertyList()));
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
