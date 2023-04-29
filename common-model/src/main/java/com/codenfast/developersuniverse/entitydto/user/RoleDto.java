package com.codenfast.developersuniverse.entitydto.user;

import java.time.LocalDateTime;
import java.util.List;


@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class RoleDto {

    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;

    private String name;

    private List<RoleAuthorizationDto> roleAuthorizationList;
}
