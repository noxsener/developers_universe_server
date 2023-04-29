package com.codenfast.developersuniverse.entitydto.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public class UserDto {

    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;

    private String username;
    private String renewPasswordConfirmCode;
    private Boolean renewPassword = Boolean.FALSE;
    private String password;
    private String name;
    private String surname;
    private String bio;
    private String language;
    private LocalDate birthDate;
    private String email;
    private String emailValidateCode;
    private Boolean emailValidated;
    private LocalDateTime lastTokenTime;
    private List<UserAuthorizationDto> userAuthorizationList;
    private List<UserRoleDto> userRoleList;
}
