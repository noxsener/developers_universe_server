package com.codenfast.developersuniverse.user.controller;


import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.user.User;
import com.codenfast.developersuniverse.entitydto.user.UserDto;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.LoginUserModel;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.user.security.TokenService;
import com.codenfast.developersuniverse.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(path = "user")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService service;
    private final TokenService tokenService;

    @PostMapping("login")
    public ResponseEntity<String> login(HttpServletRequest httpServletRequest, Authentication authentication) {
        try {
            return new ResponseEntity<>(tokenService.generateToken(httpServletRequest,authentication), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("login-by-token")
    public ResponseEntity<UserDto> loginByToken(@RequestBody LoginUserModel loginUserModel) {
        try {
            User entity = service.loginByToken(loginUserModel);
            UserDto result = new EntityToDto<UserDto>().convertToDto(entity, UserDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            User entity = entityMapper.map(dto);
            entity = service.save(entity);
            UserDto result = new EntityToDto<UserDto>().convertToDto(entity, UserDto.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("update")
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
        try {
            EntityMapper entityMapper = EntityMapper.INSTANCE;
            User entity = entityMapper.map(dto);
            entity = service.update(entity);
            UserDto result = new EntityToDto<UserDto>().convertToDto(entity, UserDto.class);
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
            User entity = service.delete(id);
            return new ResponseEntity<>(entity.getPassive(), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("grid")
    public ResponseEntity<List<UserDto>> grid(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<UserDto> entityToDto = new EntityToDto<>();
            List<User> list = service.grid(requestGrid);
            List<UserDto> resultList = new java.util.ArrayList<>();
            for (User entity : list) {
                resultList.add(entityToDto.convertToDto(entity, UserDto.class, requestGrid.getPropertyList()));
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
    public ResponseEntity<TableModel<UserDto>> gridTableModel(@RequestBody RequestGrid requestGrid) {
        try {
            EntityToDto<UserDto> entityToDto = new EntityToDto<>();
            TableModel<User> tableModel = service.gridTableModel(requestGrid);
            TableModel<UserDto> result = new TableModel<>();
            result.setCount(tableModel.getCount());
            List<UserDto> resultList = new java.util.ArrayList<>();
            for (User entity : tableModel.getData()) {
                resultList.add(entityToDto.convertToDto(entity, UserDto.class, requestGrid.getPropertyList()));
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
