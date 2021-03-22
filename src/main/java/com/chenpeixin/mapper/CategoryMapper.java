package com.chenpeixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenpeixin.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author chenpeixin
 * 2021-02-15
 */
@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
}
