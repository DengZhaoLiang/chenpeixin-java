package com.chenpeixin.service.api.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chenpeixin.dto.api.admin.PasswordRequest;
import com.chenpeixin.mapper.UserMapper;
import com.chenpeixin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper mUserMapper;

    @Override
    public User updateAdmin(User user) {
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
        updateWrapper.set(!StringUtils.isEmpty(user.getNumber()), "number", user.getNumber());
        updateWrapper.eq("id", user.getId());
        mUserMapper.update(user, updateWrapper);
        return mUserMapper.selectById(user.getId());
    }

    @Override
    public User selectAdmin(Long id) {
        return mUserMapper.selectById(id);
    }

    @Override
    public void changePassword(PasswordRequest request) {
        User user = mUserMapper.selectById(request.getId());
        user.setPassword(request.getPassword());
        user.setUpdatedAt(Instant.now().getEpochSecond());
        mUserMapper.updateById(user);
    }
}
