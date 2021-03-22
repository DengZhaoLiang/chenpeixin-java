package com.chenpeixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenpeixin.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author chenpeixin
 * 2021-01-30
 */
@Mapper
@Repository
public interface AdminMapper extends BaseMapper<Admin> {
}
