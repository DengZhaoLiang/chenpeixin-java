package com.chenpeixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenpeixin.model.Portfolio;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Mapper
@Repository
public interface PortfolioMapper extends BaseMapper<Portfolio> {
}