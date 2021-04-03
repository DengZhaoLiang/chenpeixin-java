package com.chenpeixin.controller.api.student;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.dto.api.teacher.CourseResponse;
import com.chenpeixin.model.Student;
import com.chenpeixin.service.api.student.StudentService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpeixin
 * 2021-03-30
 */
@Validated
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService mStudentService;

    @GetMapping("")
    public Page<Student> pageStudents(Pageable pageable) {
        return mStudentService.pageStudents(pageable);
    }

    @GetMapping("/{id}")
    public Student selectStudent(@PathVariable Long id) {
        return mStudentService.selectStudent(id);
    }

    @PostMapping("")
    public void insertStudent(@RequestBody @Validated Student student) {
        mStudentService.insertStudent(student);
    }

    @PutMapping("")
    public void updateStudent(@RequestBody @Validated Student student) {
        mStudentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        mStudentService.deleteStudent(id);
    }

    @DeleteMapping("/batch")
    public void batchDeleteStudent(@RequestBody @Validated IDSRequest request) {
        mStudentService.batchDeleteStudent(request);
    }

    @GetMapping("/course/{id}")
    public Page<CourseResponse> pageCourses(Pageable pageable, @PathVariable Long id, @RequestParam(required = false) String semesterName) {
        return mStudentService.pageCourses(pageable, id, semesterName);
    }
}
