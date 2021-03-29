package com.chenpeixin.service.api.teacher;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author chenpeixin
 * 2021-03-29
 */
public interface TeacherService {

    /**
     * 分页获取教师
     */
    Page<Teacher> pageTeachers(Pageable pageable);

    /**
     * 获取教师详情
     */
    Teacher selectTeacher(Long id);

    /**
     * 新增教师
     */
    void insertTeacher(Teacher teacher);

    /**
     * 修改老师
     */
    void updateTeacher(Teacher teacher);

    /**
     * 删除老师
     */
    void deleteTeacher(Long id);

    /**
     * 批量删除老师
     */
    void batchDeleteTeacher(IDSRequest request);
}
