package com.codenfast.developersuniverse.media.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.media.InvoiceLicence;
import com.codenfast.developersuniverse.entitydto.media.InvoiceLicenceDto;
import com.codenfast.developersuniverse.media.service.InvoiceLicenceService;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequestMapping(path = "invoice-licence")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class InvoiceLicenceController {

    private final InvoiceLicenceService service;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD}, path = "{id}")
    @Async
    public CompletableFuture<Void> download(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        return service.download(request, response, id);
    }

    @GetMapping(path = "id/{id}")
    public ResponseEntity<InvoiceLicenceDto> getInvoiceLicence(@PathVariable String id) {
        try {
            List<Double[]> d = new ArrayList<>();
            InvoiceLicence media = service.getInvoiceLicence(id);
            EntityToDto<InvoiceLicenceDto> entityToDto = new EntityToDto<>();
            return new ResponseEntity<>(entityToDto.convertToDto(media, InvoiceLicenceDto.class), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("save")
    public ResponseEntity<InvoiceLicenceDto> save(
            @RequestBody InvoiceLicenceDto dto
    ) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            InvoiceLicence entity = entityMapper.map(dto);
            entity = service.save(entity);
            InvoiceLicenceDto result = new EntityToDto<InvoiceLicenceDto>().convertToDto(entity, InvoiceLicenceDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("update")
    public ResponseEntity<InvoiceLicenceDto> update(@RequestBody InvoiceLicenceDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            InvoiceLicence entity = entityMapper.map(dto);
            entity = service.update(entity);
            InvoiceLicenceDto result = new EntityToDto<InvoiceLicenceDto>().convertToDto(entity, InvoiceLicenceDto.class);
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
            InvoiceLicence entity = service.delete(id);
            return new ResponseEntity<>(entity.getPassive(), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("grid")
    public ResponseEntity<List<InvoiceLicenceDto>> grid(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<InvoiceLicenceDto> entityToDto = new EntityToDto<>();
            List<InvoiceLicence> list = service.grid(requestGrid);
            List<InvoiceLicenceDto> resultList = new java.util.ArrayList<>();
            for (InvoiceLicence entity : list) {
                resultList.add(entityToDto.convertToDto(entity, InvoiceLicenceDto.class, requestGrid.getPropertyList()));
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
    public ResponseEntity<TableModel<InvoiceLicenceDto>> gridTableModel(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<InvoiceLicenceDto> entityToDto = new EntityToDto<>();
            TableModel<InvoiceLicence> tableModel = service.gridTableModel(requestGrid);
            TableModel<InvoiceLicenceDto> result = new TableModel<>();
            result.setCount(tableModel.getCount());
            List<InvoiceLicenceDto> resultList = new java.util.ArrayList<>();
            for (InvoiceLicence entity : tableModel.getData()) {
                resultList.add(entityToDto.convertToDto(entity, InvoiceLicenceDto.class, requestGrid.getPropertyList()));
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
