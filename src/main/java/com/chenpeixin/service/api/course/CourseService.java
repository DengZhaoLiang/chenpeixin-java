package com.chenpeixin.service.api.course;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.model.Course;
import com.chenpeixin.model.CourseInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author chenpeixin
 * 2021-04-03
 */
public interface CourseService {

    /**
     * 分页获取课程信息
     */
    Page<Course> pageCourses(Pageable pageable);

    /**
     * 获取课程信息
     */
    Course selectCourse(Long id);

    /**
     * 新增课程
     */
    void insertCourse(Course course);

    /**
     * 修改课程
     */
    void updateCourse(Course course);

    /**
     * 删除课程
     */
    void deleteCourse(Long id);

    /**
     * 批量删除课程
     */
    void batchDeleteCourses(IDSRequest request);

    /**
     * 设置上课信息
     */
    void updateCourseInfo(Long portfolioId, CourseInfo courseInfo);

    /**
     * 设置上课学期
     */
    void updateSemester(Long semesterId, Long courseId, Long portfolioId);

    /**
     * 删除上课学期
     */
    void deleteSemester(Long semesterId, Long courseId, Long portfolioId);
}
