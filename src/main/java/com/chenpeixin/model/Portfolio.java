package com.chenpeixin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Data
public class Portfolio {

    /**
     * 学籍ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班级
     */
    private String clbum;

    /**
     * 专业ID
     */
    private Long specialityId;

    /**
     * 创建时间
     */
    private Long createdAt;

    /**
     * 更新时间
     */
    private Long updatedAt;
}
