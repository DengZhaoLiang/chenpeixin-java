package com.chenpeixin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Data
public class Score {

    /**
     * 成绩表ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 成绩
     */
    private String score;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 上课信息表ID
     */
    private Long courseInfoId;

    /**
     * 创建时间
     */
    private Long createdAt;

    /**
     * 更新时间
     */
    private Long updatedAt;
}
