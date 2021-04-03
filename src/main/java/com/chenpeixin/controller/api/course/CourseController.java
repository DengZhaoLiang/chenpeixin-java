package com.chenpeixin.controller.api.course;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.model.Course;
import com.chenpeixin.model.CourseInfo;
import com.chenpeixin.service.api.course.CourseService;
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
 * 2021-04-03
 */
@Validated
@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService mCourseService;

    @GetMapping("")
    public Page<Course> pageCourses(Pageable pageable) {
        return mCourseService.pageCourses(pageable);
    }

    @PostMapping("")
    public void insertCourse(@RequestBody @Validated Course course) {
        mCourseService.insertCourse(course);
    }

    @PutMapping("")
    public void updateCourse(@RequestBody @Validated Course course) {
        mCourseService.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        mCourseService.deleteCourse(id);
    }

    @DeleteMapping("/batch")
    public void batchDeleteCourses(@RequestBody @Validated IDSRequest request) {
        mCourseService.batchDeleteCourses(request);
    }

    @PutMapping("/info/{portfolioId}")
    public void updateCourseInfo(@PathVariable Long portfolioId, @RequestBody @Validated CourseInfo courseInfo) {
        mCourseService.updateCourseInfo(portfolioId, courseInfo);
    }

    @PutMapping("/semester/{semesterId}/{courseId}/{portfolioId}")
    public void updateSemester(@PathVariable Long semesterId, @PathVariable Long courseId, @PathVariable Long portfolioId) {
        mCourseService.updateSemester(semesterId, courseId, portfolioId);
    }

    @DeleteMapping("/semester/{semesterId}/{courseId}/{portfolioId}")
    public void deleteSemester(@PathVariable Long semesterId, @PathVariable Long courseId, @PathVariable Long portfolioId) {
        mCourseService.deleteSemester(semesterId, courseId, portfolioId);
    }
}
