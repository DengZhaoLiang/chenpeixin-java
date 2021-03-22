package com.chenpeixin.dto.api.order;

import lombok.Data;

/**
 * @author chenpeixin
 * 2021-02-13
 */
@Data
public class OrderBookResponse {

    /**
     * 书Id
     */
    private Long bookId;

    /**
     * 购买数量
     */
    private Integer purchaseNum;
}
