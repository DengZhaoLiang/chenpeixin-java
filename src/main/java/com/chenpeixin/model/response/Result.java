package com.chenpeixin.model.response;

import lombok.Data;

/**
 * @author chenpeixin
 * 2021-01-30
 */
@Data
public class Result {

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 错误提示信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;
}
