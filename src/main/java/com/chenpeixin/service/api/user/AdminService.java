package com.chenpeixin.service.api.user;

import com.chenpeixin.dto.api.admin.PasswordRequest;
import com.chenpeixin.model.User;

/**
 * @author chenpeixin
 * 2021-02-10
 */
public interface AdminService {

    /**
     * 更新用户
     */
    User updateAdmin(User user);

    /**
     * 查询用户
     */
    User selectAdmin(Long id);

    /**
     * 更改密码
     */
    void changePassword(PasswordRequest request);
}
