package com.chenpeixin.dto.api.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chenpeixin
 * 2021-02-12
 */
@Data
public class BookResponse {

    /**
     * 书ID
     */
    private Long bookId;

    /**
     * 书名
     */
    private String BookName;

    /**
     * 书主图
     */
    private String BookImage;

    /**
     * 单价
     */
    private BigDecimal BookPrice;

    /**
     * 购买数量
     */
    private Integer quantity;
}
