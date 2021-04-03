package com.chenpeixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenpeixin.dto.api.teacher.CourseResponse;
import com.chenpeixin.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenpeixin
 * 2021-01-31
 */
@Mapper
@Repository
public interface CourseMapper extends BaseMapper<Course> {

    List<CourseResponse> pageCourses(Long id);
}
