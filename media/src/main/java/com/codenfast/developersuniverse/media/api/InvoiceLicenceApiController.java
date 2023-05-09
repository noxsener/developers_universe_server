package com.codenfast.developersuniverse.media.api;

import com.codenfast.developersuniverse.entitydto.media.InvoiceLicenceDto;
import com.codenfast.developersuniverse.media.controller.InvoiceLicenceController;
import com.codenfast.developersuniverse.model.CodenfastSecurityException;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.service.EncryptService;
import com.codenfast.developersuniverse.utils.StringConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RequestMapping(path = "api/invoice-licence", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class InvoiceLicenceApiController {

    private final InvoiceLicenceController invoiceLicenceController;
    private final EncryptService encryptService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD}, path = "{id}")
    @Async
    public CompletableFuture<Void> download(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        return invoiceLicenceController.download(request, response, id);
    }

    @GetMapping(path = "id/{id}")
    public String getInvoiceLicence(@RequestHeader(StringConstant.AHEADER) String data, @PathVariable String id) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, invoiceLicenceController.getInvoiceLicence(id));
    }

    @PostMapping("save")
    public String save(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, invoiceLicenceController.save(encryptService.readValue(data, encryptData, InvoiceLicenceDto.class)));
    }

    @PutMapping("update")
    public String update(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, invoiceLicenceController.update(encryptService.readValue(data, encryptData, InvoiceLicenceDto.class)));
    }

    @DeleteMapping("delete/{id}")
    public String delete(@RequestHeader(StringConstant.AHEADER) String data, @PathVariable String id) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, invoiceLicenceController.delete(id));
    }

    @PostMapping("grid")
    public String grid(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, invoiceLicenceController.grid(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }

    @PostMapping("/grid-table-model")
    public String gridTableModel(@RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        return encryptService.writeValue(data, invoiceLicenceController.gridTableModel(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }
}
