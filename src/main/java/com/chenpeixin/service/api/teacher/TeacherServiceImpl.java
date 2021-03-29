package com.chenpeixin.service.api.teacher;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chenpeixin.assembler.TeacherAssembler;
import com.chenpeixin.assembler.UserAssembler;
import com.chenpeixin.constant.RoleType;
import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.mapper.UserMapper;
import com.chenpeixin.model.Teacher;
import com.chenpeixin.model.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chenpeixin
 * 2021-03-29
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private UserMapper mUserMapper;

    @Autowired
    private UserAssembler mUserAssembler;

    @Autowired
    private TeacherAssembler mTeacherAssembler;

    @Value("${server.base.url}")
    private String url;

    @Override
    public Page<Teacher> pageTeachers(Pageable pageable) {
        PageRequest page = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("role", RoleType.TEACHER.getType());
        List<Teacher> teachers = mUserMapper.selectList(wrapper)
                .stream()
                .map(user -> mUserAssembler.toTeacher(user))
                .collect(Collectors.toList());
        return new PageImpl<>(teachers.stream()
                .skip((page.getPageNumber()) * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList()), page, teachers.size());
    }

    @Override
    public Teacher selectTeacher(Long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("role", RoleType.TEACHER.getType());
        wrapper.eq(!ObjectUtils.isEmpty(id), "id", id);
        return mUserAssembler.toTeacher(mUserMapper.selectOne(wrapper));
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        teacher.setRole(RoleType.TEACHER.getType());
        if (Strings.isBlank(teacher.getAvatar())) {
            teacher.setAvatar(url + "/static/defaultAvatar.jpg");
        }
        teacher.setCreatedAt(Instant.now().getEpochSecond());
        teacher.setUpdatedAt(Instant.now().getEpochSecond());
        mUserMapper.insert(mTeacherAssembler.toUser(teacher));
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", teacher.getId());
        wrapper.eq("role", RoleType.TEACHER.getType());
        Optional.ofNullable(mUserMapper.selectOne(wrapper))
                .orElseThrow(() -> new RuntimeException("教师不存在"));

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set(!StringUtils.isEmpty(teacher.getAvatar()), "avatar", teacher.getAvatar());
        updateWrapper.set(!StringUtils.isEmpty(teacher.getName()), "name", teacher.getName());
        updateWrapper.set(!StringUtils.isEmpty(teacher.getPhone()), "phone", teacher.getPhone());
        updateWrapper.set(!StringUtils.isEmpty(teacher.getPassword()), "password", teacher.getPassword());
        updateWrapper.set(!ObjectUtils.isEmpty(teacher.getGender()), "gender", teacher.getGender());
        updateWrapper.set(!ObjectUtils.isEmpty(teacher.getRole()), "role", teacher.getRole());
        updateWrapper.set(!StringUtils.isEmpty(teacher.getSpeciality()), "speciality", teacher.getSpeciality());
        updateWrapper.eq("id", teacher.getId());
        teacher.setUpdatedAt(Instant.now().getEpochSecond());
        mUserMapper.update(mTeacherAssembler.toUser(teacher), updateWrapper);
    }

    @Override
    public void deleteTeacher(Long id) {
        mUserMapper.deleteById(id);
    }

    @Override
    public void batchDeleteTeacher(IDSRequest request) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("role", RoleType.TEACHER.getType());
        wrapper.in("id", request.getIds());
        mUserMapper.delete(wrapper);
    }
}
