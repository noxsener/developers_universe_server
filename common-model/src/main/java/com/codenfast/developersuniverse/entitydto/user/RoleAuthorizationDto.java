package com.codenfast.developersuniverse.entitydto.user;


import java.time.LocalDateTime;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class RoleAuthorizationDto {

    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;


    private String grant;

    private RoleDto role;

    private AuthorizationDto authorization;
}
