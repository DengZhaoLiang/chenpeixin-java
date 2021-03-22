package com.chenpeixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenpeixin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author chenpeixin
 * 2021-01-31
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
