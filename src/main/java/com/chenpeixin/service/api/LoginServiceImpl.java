package com.chenpeixin.service.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenpeixin.dto.api.user.LoginRequest;
import com.chenpeixin.mapper.UserMapper;
import com.chenpeixin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper mUserMapper;

    @Value("${server.base.url}")
    private String url;

    @Override
    public User login(LoginRequest request) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", request.getPhone());
        wrapper.eq("password", request.getPassword());
        return Optional.ofNullable(mUserMapper.selectOne(wrapper))
                .orElseThrow(() -> new RuntimeException("账号密码错误，请重新输入"));
    }

    @Override
    public void register(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", user.getPhone());
        Optional.ofNullable(mUserMapper.selectOne(wrapper))
                .ifPresent(it -> {
                    throw new RuntimeException("手机号已被注册");
                });
        user.setName(user.getPhone());
        user.setAvatar(url + "/static/defaultAvatar.jpg");
        mUserMapper.insert(user);
    }
}
