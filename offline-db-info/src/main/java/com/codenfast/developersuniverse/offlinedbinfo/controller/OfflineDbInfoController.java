package com.codenfast.developersuniverse.offlinedbinfo.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.OfflineDbInfo;
import com.codenfast.developersuniverse.entitydto.OfflineDbInfoDto;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.offlinedbinfo.service.OfflineDbInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(path = "offline-db-info")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class OfflineDbInfoController {

    private final OfflineDbInfoService service;

    @PostMapping("save")
    public ResponseEntity<OfflineDbInfoDto> save(@RequestBody OfflineDbInfoDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            OfflineDbInfo entity = entityMapper.map(dto);
            entity = service.save(entity);
            OfflineDbInfoDto result = new EntityToDto<OfflineDbInfoDto>().convertToDto(entity, OfflineDbInfoDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("update")
    public ResponseEntity<OfflineDbInfoDto> update(@RequestBody OfflineDbInfoDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            OfflineDbInfo entity = entityMapper.map(dto);
            entity = service.update(entity);
            OfflineDbInfoDto result = new EntityToDto<OfflineDbInfoDto>().convertToDto(entity, OfflineDbInfoDto.class);
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
            OfflineDbInfo entity = service.delete(id);
            return new ResponseEntity<>(entity.getPassive(), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("grid")
    public ResponseEntity<List<OfflineDbInfoDto>> grid(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<OfflineDbInfoDto> entityToDto = new EntityToDto<>();
            List<OfflineDbInfo> list = service.grid(requestGrid);
            List<OfflineDbInfoDto> resultList = new java.util.ArrayList<>();
            for (OfflineDbInfo entity : list) {
                resultList.add(entityToDto.convertToDto(entity, OfflineDbInfoDto.class, requestGrid.getPropertyList()));
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
    public ResponseEntity<TableModel<OfflineDbInfoDto>> gridTableModel(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<OfflineDbInfoDto> entityToDto = new EntityToDto<>();
            TableModel<OfflineDbInfo> tableModel = service.gridTableModel(requestGrid);
            TableModel<OfflineDbInfoDto> result = new TableModel<>();
            result.setCount(tableModel.getCount());
            List<OfflineDbInfoDto> resultList = new java.util.ArrayList<>();
            for (OfflineDbInfo entity : tableModel.getData()) {
                resultList.add(entityToDto.convertToDto(entity, OfflineDbInfoDto.class, requestGrid.getPropertyList()));
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
