package com.codenfast.developersuniverse.common.entity.user;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.common.converter.YesNoConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "AUTH", indexes = {
        @Index(columnList = "NAME", name = "ix_auth_name")
}
)
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class Auth implements EntityModel {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "AUTH_ID", unique = true, nullable = false, length = 36)
    private String id;
    @Column(name = "PASSIVE", length = 1, nullable = false)
    @Convert(converter = YesNoConverter.class)
    private Boolean passive = Boolean.FALSE;
    @CreationTimestamp
    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime = null;
    @UpdateTimestamp
    @Column(name = "UPDATE_TIME")
    private LocalDateTime updateTime = null;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GRANT_DIRECTION", length = 1, nullable = false)
    @Convert(converter = YesNoConverter.class)
    private Boolean grantDirection = Boolean.TRUE;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auth")
    private List<UserAuth> userAuthList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auth")
    private List<RoleAuth> roleAuthList;
}
