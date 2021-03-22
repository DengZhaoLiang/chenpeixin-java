package com.chenpeixin.dto.api.user;

import lombok.Data;

/**
 * @author chenpeixin
 * 2021-02-10
 */
@Data
public class LoginRequest {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;
}
