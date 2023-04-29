package com.codenfast.developersuniverse.media.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.download.DownloadStatus;
import com.codenfast.developersuniverse.entitydto.download.DownloadStatusDto;
import com.codenfast.developersuniverse.media.service.DownloadStatusService;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(path = "download-status")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class DownloadStatusController {

    private final DownloadStatusService service;

    @PostMapping("save")
    public ResponseEntity<DownloadStatusDto> save(@RequestBody DownloadStatusDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            DownloadStatus entity = entityMapper.map(dto);
            entity = service.save(entity);
            DownloadStatusDto result = new EntityToDto<DownloadStatusDto>().convertToDto(entity, DownloadStatusDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("update")
    public ResponseEntity<DownloadStatusDto> update(@RequestBody DownloadStatusDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            DownloadStatus entity = entityMapper.map(dto);
            entity = service.update(entity);
            DownloadStatusDto result = new EntityToDto<DownloadStatusDto>().convertToDto(entity, DownloadStatusDto.class);
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
            DownloadStatus entity = service.delete(id);
            return new ResponseEntity<>(entity.getPassive(), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("grid")
    public ResponseEntity<List<DownloadStatusDto>> grid(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<DownloadStatusDto> entityToDto = new EntityToDto<>();
            List<DownloadStatus> list = service.grid(requestGrid);
            List<DownloadStatusDto> resultList = new java.util.ArrayList<>();
            for (DownloadStatus entity : list) {
                resultList.add(entityToDto.convertToDto(entity, DownloadStatusDto.class, requestGrid.getPropertyList()));
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
    public ResponseEntity<TableModel<DownloadStatusDto>> gridTableModel(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<DownloadStatusDto> entityToDto = new EntityToDto<>();
            TableModel<DownloadStatus> tableModel = service.gridTableModel(requestGrid);
            TableModel<DownloadStatusDto> result = new TableModel<>();
            result.setCount(tableModel.getCount());
            List<DownloadStatusDto> resultList = new java.util.ArrayList<>();
            for (DownloadStatus entity : tableModel.getData()) {
                resultList.add(entityToDto.convertToDto(entity, DownloadStatusDto.class, requestGrid.getPropertyList()));
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
