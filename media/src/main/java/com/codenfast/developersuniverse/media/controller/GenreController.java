package com.codenfast.developersuniverse.media.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.music.Genre;
import com.codenfast.developersuniverse.entitydto.music.GenreDto;
import com.codenfast.developersuniverse.media.service.GenreService;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(path = "genre")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class GenreController {

    private final GenreService service;

    @PostMapping("save")
    public ResponseEntity<GenreDto> save(@RequestBody GenreDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            Genre entity = entityMapper.map(dto);
            entity = service.save(entity);
            GenreDto result = new EntityToDto<GenreDto>().convertToDto(entity, GenreDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("update")
    public ResponseEntity<GenreDto> update(@RequestBody GenreDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            Genre entity = entityMapper.map(dto);
            entity = service.update(entity);
            GenreDto result = new EntityToDto<GenreDto>().convertToDto(entity, GenreDto.class);
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
            Genre entity = service.delete(id);
            return new ResponseEntity<>(entity.getPassive(), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("grid")
    public ResponseEntity<List<GenreDto>> grid(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<GenreDto> entityToDto = new EntityToDto<>();
            List<Genre> list = service.grid(requestGrid);
            List<GenreDto> resultList = new java.util.ArrayList<>();
            for (Genre entity : list) {
                resultList.add(entityToDto.convertToDto(entity, GenreDto.class, requestGrid.getPropertyList()));
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
    public ResponseEntity<TableModel<GenreDto>> gridTableModel(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<GenreDto> entityToDto = new EntityToDto<>();
            TableModel<Genre> tableModel = service.gridTableModel(requestGrid);
            TableModel<GenreDto> result = new TableModel<>();
            result.setCount(tableModel.getCount());
            List<GenreDto> resultList = new java.util.ArrayList<>();
            for (Genre entity : tableModel.getData()) {
                resultList.add(entityToDto.convertToDto(entity, GenreDto.class, requestGrid.getPropertyList()));
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
