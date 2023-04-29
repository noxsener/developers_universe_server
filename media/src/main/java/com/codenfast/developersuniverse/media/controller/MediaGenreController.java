package com.codenfast.developersuniverse.media.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.music.MediaGenre;
import com.codenfast.developersuniverse.entitydto.music.MediaGenreDto;
import com.codenfast.developersuniverse.media.service.MediaGenreService;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping(path = "media-genre")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class MediaGenreController {

    private final MediaGenreService service;

    @PostMapping("save")
    public ResponseEntity<MediaGenreDto> save(@RequestBody MediaGenreDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            MediaGenre entity = entityMapper.map(dto);
            entity = service.save(entity);
            MediaGenreDto result = new EntityToDto<MediaGenreDto>().convertToDto(entity, MediaGenreDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("update")
    public ResponseEntity<MediaGenreDto> update(@RequestBody MediaGenreDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            MediaGenre entity = entityMapper.map(dto);
            entity = service.update(entity);
            MediaGenreDto result = new EntityToDto<MediaGenreDto>().convertToDto(entity, MediaGenreDto.class);
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
            MediaGenre entity = service.delete(id);
            return new ResponseEntity<>(entity.getPassive(), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("grid")
    public ResponseEntity<List<MediaGenreDto>> grid(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<MediaGenreDto> entityToDto = new EntityToDto<>();
            List<MediaGenre> list = service.grid(requestGrid);
            List<MediaGenreDto> resultList = new java.util.ArrayList<>();
            for (MediaGenre entity : list) {
                resultList.add(entityToDto.convertToDto(entity, MediaGenreDto.class, requestGrid.getPropertyList()));
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
    public ResponseEntity<TableModel<MediaGenreDto>> gridTableModel(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<MediaGenreDto> entityToDto = new EntityToDto<>();
            TableModel<MediaGenre> tableModel = service.gridTableModel(requestGrid);
            TableModel<MediaGenreDto> result = new TableModel<>();
            result.setCount(tableModel.getCount());
            List<MediaGenreDto> resultList = new java.util.ArrayList<>();
            for (MediaGenre entity : tableModel.getData()) {
                resultList.add(entityToDto.convertToDto(entity, MediaGenreDto.class, requestGrid.getPropertyList()));
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
