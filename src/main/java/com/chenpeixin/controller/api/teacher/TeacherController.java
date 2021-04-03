package com.chenpeixin.controller.api.teacher;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.dto.api.teacher.CourseResponse;
import com.chenpeixin.model.Teacher;
import com.chenpeixin.service.api.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpeixin
 * 2021-03-29
 */
@Validated
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService mTeacherService;

    @GetMapping("")
    public Page<Teacher> pageTeachers(Pageable pageable) {
        return mTeacherService.pageTeachers(pageable);
    }

    @GetMapping("/{id}")
    public Teacher selectTeacher(@PathVariable Long id) {
        return mTeacherService.selectTeacher(id);
    }

    @PostMapping("")
    public void insertTeacher(@RequestBody @Validated Teacher teacher) {
        mTeacherService.insertTeacher(teacher);
    }

    @PutMapping("")
    public void updateTeacher(@RequestBody @Validated Teacher teacher) {
        mTeacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        mTeacherService.deleteTeacher(id);
    }

    @DeleteMapping("/batch")
    public void batchDeleteTeacher(@RequestBody @Validated IDSRequest request) {
        mTeacherService.batchDeleteTeacher(request);
    }

    @GetMapping("/course/{id}")
    public Page<CourseResponse> pageCourses(Pageable pageable, @PathVariable Long id) {
        return mTeacherService.pageCourses(pageable, id);
    }
}
