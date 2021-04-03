package com.chenpeixin.service.api;

import com.chenpeixin.dto.api.user.LoginRequest;
import com.chenpeixin.model.User;

/**
 * @author chenpeixin
 * 2021-04-03
 */
public interface LoginService {

    /**
     * 登录
     */
    User login(LoginRequest request);

    /**
     * 注册
     */
    void register(User user);
}
