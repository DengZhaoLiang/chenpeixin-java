package com.chenpeixin.service.api.student;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chenpeixin.assembler.StudentAssembler;
import com.chenpeixin.assembler.UserAssembler;
import com.chenpeixin.constant.RoleType;
import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.mapper.UserMapper;
import com.chenpeixin.model.Student;
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
 * 2021-03-30
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private UserMapper mUserMapper;

    @Autowired
    private UserAssembler mUserAssembler;

    @Autowired
    private StudentAssembler mStudentAssembler;

    @Value("${server.base.url}")
    private String url;

    @Override
    public Page<Student> pageStudents(Pageable pageable) {
        PageRequest page = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("role", RoleType.STUDENT.getType());
        List<Student> students = mUserMapper.selectList(wrapper)
                .stream()
                .map(user -> mUserAssembler.toStudent(user))
                .collect(Collectors.toList());
        return new PageImpl<>(students.stream()
                .skip((page.getPageNumber()) * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList()), page, students.size());
    }

    @Override
    public Student selectStudent(Long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("role", RoleType.STUDENT.getType());
        wrapper.eq(!ObjectUtils.isEmpty(id), "id", id);
        return mUserAssembler.toStudent(mUserMapper.selectOne(wrapper));
    }

    @Override
    public void insertStudent(Student student) {
        student.setRole(RoleType.STUDENT.getType());
        if (Strings.isBlank(student.getAvatar())) {
            student.setAvatar(url + "/static/defaultAvatar.jpg");
        }
        student.setCreatedAt(Instant.now().getEpochSecond());
        student.setUpdatedAt(Instant.now().getEpochSecond());
        mUserMapper.insert(mStudentAssembler.toUser(student));
    }

    @Override
    public void updateStudent(Student student) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", student.getId());
        wrapper.eq("role", RoleType.STUDENT.getType());
        Optional.ofNullable(mUserMapper.selectOne(wrapper))
                .orElseThrow(() -> new RuntimeException("教师不存在"));

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set(!StringUtils.isEmpty(student.getAvatar()), "avatar", student.getAvatar());
        updateWrapper.set(!StringUtils.isEmpty(student.getName()), "name", student.getName());
        updateWrapper.set(!StringUtils.isEmpty(student.getPhone()), "phone", student.getPhone());
        updateWrapper.set(!StringUtils.isEmpty(student.getPassword()), "password", student.getPassword());
        updateWrapper.set(!ObjectUtils.isEmpty(student.getGender()), "gender", student.getGender());
        updateWrapper.set(!ObjectUtils.isEmpty(student.getRole()), "role", student.getRole());
        updateWrapper.set(!StringUtils.isEmpty(student.getSpeciality()), "speciality", student.getSpeciality());
        updateWrapper.set(!StringUtils.isEmpty(student.getGrade()), "grade", student.getGrade());
        updateWrapper.set(!StringUtils.isEmpty(student.getNumber()), "number", student.getNumber());
        updateWrapper.set(!StringUtils.isEmpty(student.getClbum()), "clbum", student.getClbum());
        updateWrapper.eq("id", student.getId());
        student.setUpdatedAt(Instant.now().getEpochSecond());
        mUserMapper.update(mStudentAssembler.toUser(student), updateWrapper);
    }

    @Override
    public void deleteStudent(Long id) {
        mUserMapper.deleteById(id);
    }

    @Override
    public void batchDeleteStudent(IDSRequest request) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("role", RoleType.STUDENT.getType());
        wrapper.in("id", request.getIds());
        mUserMapper.delete(wrapper);
    }
}
