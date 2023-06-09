package com.codenfast.developersuniverse.user.service;

import com.codenfast.developersuniverse.common.entity.user.User;
import com.codenfast.developersuniverse.common.service.BaseService;
import com.codenfast.developersuniverse.model.LoginUserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends BaseService<User>, UserDetailsService {
    User login(LoginUserModel loginUserModel);

    User loginByToken(LoginUserModel loginUserModel);
}
