package com.chenpeixin.service.api.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chenpeixin.dto.api.user.LoginRequest;
import com.chenpeixin.mapper.UserMapper;
import com.chenpeixin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.Optional;

/**
 * @author chenpeixin
 * 2021-02-10
 */
@Service
public class UserServiceImpl implements UserService {

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

    @Override
    public User updateUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", user.getPhone());
        Optional.ofNullable(mUserMapper.selectOne(wrapper))
                .ifPresent(it -> {
                    if (!ObjectUtils.nullSafeEquals(it.getId(), user.getId())) {
                        throw new RuntimeException("手机号已被注册");
                    }
                });
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set(!StringUtils.isEmpty(user.getAvatar()), "avatar", user.getAvatar());
        updateWrapper.set(!StringUtils.isEmpty(user.getName()), "name", user.getName());
        updateWrapper.set(!StringUtils.isEmpty(user.getPhone()), "phone", user.getPhone());
        updateWrapper.set(!StringUtils.isEmpty(user.getPassword()), "password", user.getPassword());
        updateWrapper.set(!ObjectUtils.isEmpty(user.getGender()), "gender", user.getGender());
        updateWrapper.set(!ObjectUtils.isEmpty(user.getRole()), "role", user.getRole());
        updateWrapper.set(!StringUtils.isEmpty(user.getSpeciality()), "speciality", user.getSpeciality());
        updateWrapper.set(!StringUtils.isEmpty(user.getGrade()), "grade", user.getGrade());
        updateWrapper.set(!StringUtils.isEmpty(user.getNumber()), "number", user.getNumber());
        updateWrapper.set(!StringUtils.isEmpty(user.getClbum()), "clbum", user.getClbum());
        updateWrapper.eq("id", user.getId());
        mUserMapper.update(user, updateWrapper);
        return mUserMapper.selectById(user.getId());
    }
}
