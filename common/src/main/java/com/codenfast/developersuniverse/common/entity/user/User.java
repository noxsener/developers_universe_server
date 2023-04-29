package com.codenfast.developersuniverse.common.entity.user;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.annotation.DtoDontConvert;
import com.codenfast.developersuniverse.annotation.StringForceLowercase;
import com.codenfast.developersuniverse.annotation.StringForceUppercase;
import com.codenfast.developersuniverse.common.converter.YesNoConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "USERS", indexes = {
        @Index(columnList = "USERNAME", name = "ix_user_username")
}
)
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class User implements EntityModel {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "USER_ID", unique = true, nullable = false, length = 36)
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

    @StringForceLowercase
    @Column(name = "USERNAME")
    private String username;
    @DtoDontConvert
    @Column(name = "RENEW_PASSWORD_CONFIRM_CODE")
    private String renewPasswordConfirmCode;
    @DtoDontConvert
    @Column(name = "RENEW_PASSWORD")
    @Convert(converter = YesNoConverter.class)
    private Boolean renewPassword = Boolean.FALSE;
    @DtoDontConvert
    @Column(name = "password")
    private String password;

    @StringForceUppercase
    @Column(name = "NAME")
    private String name;
    @StringForceUppercase
    @Column(name = "SURNAME")
    private String surname;

    @Lob
    @Column(name = "BIO", columnDefinition = "text")
    private String bio;
    @Column(name = "LANGUAGE")
    private String language;
    @Column(name = "BIRTHDATE", columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "EMAIL_VALIDATE_CODE")
    private String emailValidateCode;
    @Column(name = "EMAIL_VALIDATED")
    private Boolean emailValidated;

    @Column(name = "LAST_TOKEN_TIME")
    private LocalDateTime lastTokenTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserAuth> userAuthList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserRole> userRoleList;
}
