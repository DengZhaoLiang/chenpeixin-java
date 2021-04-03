package com.chenpeixin.service.api.student;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.dto.api.teacher.CourseResponse;
import com.chenpeixin.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author chenpeixin
 * 2021-03-30
 */
public interface StudentService {

    /**
     * 分页获取学生
     */
    Page<Student> pageStudents(Pageable pageable);

    /**
     * 获取学生信息
     */
    Student selectStudent(Long id);

    /**
     * 新增学生
     */
    void insertStudent(Student student);

    /**
     * 修改学生信息
     */
    void updateStudent(Student student);

    /**
     * 删除学生
     */
    void deleteStudent(Long id);

    /**
     * 批量删除学生
     */
    void batchDeleteStudent(IDSRequest request);

    /**
     * 查看课程
     */
    Page<CourseResponse> pageCourses(Pageable pageable, Long id, String semesterName);
}
