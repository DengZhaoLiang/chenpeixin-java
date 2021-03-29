package com.chenpeixin.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author chenpeixin
 * 2021-03-29
 */
@RequiredArgsConstructor
public enum RoleType {

    /**
     * 管理员
     */
    ADMIN(1),

    TEACHER(2),

    STUDENT(3),

    ;

    @Getter
    private final int type;
}
