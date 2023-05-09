package com.codenfast.developersuniverse.user.api;


import com.codenfast.developersuniverse.entitydto.user.UserDto;
import com.codenfast.developersuniverse.model.CodenfastSecurityException;
import com.codenfast.developersuniverse.model.LoginUserModel;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.service.EncryptService;
import com.codenfast.developersuniverse.user.controller.UserController;
import com.codenfast.developersuniverse.utils.StringConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/user")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class UserApiController {

    private final UserController userController;
    private final EncryptService encryptService;

    @PostMapping("login")
    public ResponseEntity<String> login(HttpServletRequest httpServletRequest, Authentication authentication) {
            return userController.login(httpServletRequest, authentication);
    }

    @PostMapping("login-by-token")
    public String loginByToken(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.addHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, userController.loginByToken(encryptService.readValue(data, encryptData, LoginUserModel.class)));
    }

    @PostMapping("save")
    public String save(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.addHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, userController.save(encryptService.readValue(data, encryptData, UserDto.class)));
    }

    @PutMapping("update")
    public String update(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.addHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, userController.update(encryptService.readValue(data, encryptData, UserDto.class)));
    }

    @DeleteMapping("delete/{id}")
    public String delete(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @PathVariable String id) throws JsonProcessingException, CodenfastSecurityException {
        response.addHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, userController.delete(id));
    }

    @PostMapping("grid")
    public String grid(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.addHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, userController.grid(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }

    @PostMapping("/grid-table-model")
    public String gridTableModel(HttpServletResponse response, @RequestHeader(StringConstant.AHEADER) String data, @RequestBody String encryptData) throws JsonProcessingException, CodenfastSecurityException {
        response.addHeader(StringConstant.AHEADER, data);
        return encryptService.writeValue(data, userController.gridTableModel(encryptService.readValue(data, encryptData, RequestGrid.class)));
    }
}
