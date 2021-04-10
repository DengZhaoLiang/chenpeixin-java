package com.chenpeixin.service.api.course;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.mapper.CourseInfoMapper;
import com.chenpeixin.mapper.CourseMapper;
import com.chenpeixin.mapper.SemesterCourseInfoMapper;
import com.chenpeixin.model.Course;
import com.chenpeixin.model.CourseInfo;
import com.chenpeixin.model.SemesterCourseInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper mCourseMapper;

    @Autowired
    private CourseInfoMapper mCourseInfoMapper;

    @Autowired
    private SemesterCourseInfoMapper mSemesterCourseInfoMapper;

    @Override
    public Page<Course> pageCourses(Pageable pageable) {
        PageRequest page = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        List<Course> courses = mCourseMapper.selectList(wrapper);
        return new PageImpl<>(courses.stream()
                .skip((page.getPageNumber()) * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList()), page, courses.size());
    }

    @Override
    public Course selectCourse(Long id) {
        return mCourseMapper.selectById(id);
    }

    @Override
    public void insertCourse(Course course) {
        mCourseMapper.insert(course);
    }

    @Override
    public void updateCourse(Course course) {
        UpdateWrapper<Course> wrapper = new UpdateWrapper<>();
        wrapper.set(Strings.isNotBlank(course.getName()), "name", course.getName());
//        wrapper.set(!Objects.isNull(course.getUserId()), "user_id", course.getUserId());
        course.setUpdatedAt(Instant.now().getEpochSecond());
        wrapper.eq("id", course.getId());
        mCourseMapper.update(course, wrapper);
    }

    @Override
    public void deleteCourse(Long id) {
        mCourseMapper.deleteById(id);
    }

    @Override
    public void batchDeleteCourses(IDSRequest request) {
        mCourseMapper.deleteBatchIds(request.getIds());
    }

    @Override
    public void updateCourseInfo(Long portfolioId, CourseInfo courseInfo) {
        courseInfo.setPortfolioId(portfolioId);
        QueryWrapper<CourseInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseInfo.getCourseId());
        wrapper.eq("portfolio_id", portfolioId);
        CourseInfo info = mCourseInfoMapper.selectOne(wrapper);
        if (Optional.ofNullable(info).isPresent()) {
            UpdateWrapper<CourseInfo> updateWrapper = new UpdateWrapper<>();
            updateWrapper.set(Strings.isNotBlank(courseInfo.getPlace()), "place", courseInfo.getPlace());
            updateWrapper.set(Strings.isNotBlank(courseInfo.getStart()), "start", courseInfo.getStart());
            updateWrapper.set(Strings.isNotBlank(courseInfo.getEnd()), "end", courseInfo.getEnd());
            updateWrapper.set(!Objects.isNull(courseInfo.getWeekday()), "weekday", courseInfo.getWeekday());
            updateWrapper.set(!Objects.isNull(courseInfo.getCourseId()), "course_id", courseInfo.getCourseId());
            updateWrapper.set(!Objects.isNull(courseInfo.getPortfolioId()), "portfolio_id", courseInfo.getPortfolioId());
            info.setUpdatedAt(Instant.now().getEpochSecond());
            updateWrapper.eq("id", info.getId());
            mCourseInfoMapper.update(info, updateWrapper);
        } else {
            mCourseInfoMapper.insert(courseInfo);
        }
    }

    @Override
    public void updateSemester(Long semesterId, Long courseId, Long portfolioId) {
        QueryWrapper<CourseInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        wrapper.eq("portfolio_id", portfolioId);
        Optional.ofNullable(mCourseInfoMapper.selectOne(wrapper))
                .ifPresent(info -> {
                    QueryWrapper<SemesterCourseInfo> semesterWrapper = new QueryWrapper<>();
                    wrapper.eq("semester_id", semesterId);
                    wrapper.eq("course_info_id", info.getId());
                    SemesterCourseInfo semester = mSemesterCourseInfoMapper.selectOne(semesterWrapper);
                    if (!Optional.ofNullable(semester).isPresent()) {
                        SemesterCourseInfo semesterCourseInfo = new SemesterCourseInfo();
                        semesterCourseInfo.setSemesterId(semesterId);
                        semesterCourseInfo.setCourseInfoId(info.getId());
                        semesterCourseInfo.setCreatedAt(Instant.now().getEpochSecond());
                        semesterCourseInfo.setUpdatedAt(Instant.now().getEpochSecond());
                        mSemesterCourseInfoMapper.insert(semesterCourseInfo);
                    }
                });
    }

    @Override
    public void deleteSemester(Long semesterId, Long courseId, Long portfolioId) {
        QueryWrapper<CourseInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        wrapper.eq("portfolio_id", portfolioId);
        Optional.ofNullable(mCourseInfoMapper.selectOne(wrapper))
                .ifPresent(info -> {
                    QueryWrapper<SemesterCourseInfo> semesterWrapper = new QueryWrapper<>();
                    wrapper.eq("semester_id", semesterId);
                    wrapper.eq("course_info_id", info.getId());
                    SemesterCourseInfo semester = mSemesterCourseInfoMapper.selectOne(semesterWrapper);
                    if (Optional.ofNullable(semester).isPresent()) {
                        mSemesterCourseInfoMapper.deleteById(semester.getId());
                    }
                });
    }
}
