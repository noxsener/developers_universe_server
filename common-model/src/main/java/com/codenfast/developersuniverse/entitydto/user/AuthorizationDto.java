package com.codenfast.developersuniverse.entitydto.user;

import java.time.LocalDateTime;
import java.util.List;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class AuthorizationDto {

    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;
    private String name;
    private Boolean grant = Boolean.TRUE;
    private List<UserAuthorizationDto> userAuthorizationList;
    private List<RoleAuthorizationDto> roleAuthorizationList;
}
