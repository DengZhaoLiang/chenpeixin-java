package com.chenpeixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenpeixin.model.OrderBook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author chenpeixin
 * 2021-02-12
 */
@Mapper
@Repository
public interface OrderBookMapper extends BaseMapper<OrderBook> {
}
