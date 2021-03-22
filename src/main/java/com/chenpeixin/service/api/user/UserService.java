package com.chenpeixin.service.api.user;

import com.chenpeixin.dto.api.user.LoginRequest;
import com.chenpeixin.model.User;

/**
 * @author chenpeixin
 * 2021-02-10
 */
public interface UserService {

    /**
     * 登录
     */
    User login(LoginRequest request);

    /**
     * 注册
     */
    void register(User user);

    /**
     * 更新用户
     */
    User updateUser(User user);
}
