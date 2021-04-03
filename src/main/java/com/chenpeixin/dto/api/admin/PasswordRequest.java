package com.chenpeixin.dto.api.admin;

import lombok.Data;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Data
public class PasswordRequest {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 密码
     */
    private String password;
}
