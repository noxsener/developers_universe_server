package com.codenfast.developersuniverse.feignclients;

import com.codenfast.developersuniverse.entitydto.OfflineDbInfoDto;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@FeignClient(name = "OFFLINE-DB-INFO", path = "offline-db-info")
public interface OfflineDbInfoFeignClient {

    @PostMapping("save")
    ResponseEntity<OfflineDbInfoDto> save(@RequestBody OfflineDbInfoDto dto);

    @PutMapping("update")
    ResponseEntity<OfflineDbInfoDto> update(@RequestBody OfflineDbInfoDto dto);

    @DeleteMapping("delete/{id}")
    ResponseEntity<Boolean> delete(@PathVariable String id);

    @PostMapping("grid")
    ResponseEntity<List<OfflineDbInfoDto>> grid(@RequestBody RequestGrid requestGrid);

    @PostMapping("/grid-table-model")
    ResponseEntity<TableModel<OfflineDbInfoDto>> gridTableModel(@RequestBody RequestGrid requestGrid);

}