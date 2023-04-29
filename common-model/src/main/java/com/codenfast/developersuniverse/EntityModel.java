package com.codenfast.developersuniverse;

import java.time.LocalDateTime;

public interface EntityModel {
    String getId();
    Boolean getPassive();
    LocalDateTime getCreateTime();
    LocalDateTime getUpdateTime();
    void setId(String id);
    void setPassive(Boolean isPassive);
    void setCreateTime(LocalDateTime isPassive);
    void setUpdateTime(LocalDateTime isPassive);
}
