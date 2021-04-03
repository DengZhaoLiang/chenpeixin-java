package com.chenpeixin.dto.api.teacher;

import lombok.Data;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Data
public class CourseResponse {

    /**
     * 上课信息表ID
     */
    private Long id;

    /**
     * 课程名
     */
    private String name;

    /**
     * 上课地点
     */
    private String place;

    /**
     * 星期
     */
    private Integer weekday;

    /**
     * 开始时间
     */
    private String start;

    /**
     * 结束时间
     */
    private String end;
}
