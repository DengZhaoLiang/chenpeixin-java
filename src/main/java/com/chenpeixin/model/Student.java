package com.chenpeixin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author chenpeixin
 * 2021-01-30
 */
@Data
public class Student {

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String name;

    /**
     * 性别 1-男 2-女
     */
    private Integer gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 角色 1-管理员 2-教师 3-学生
     */
    private Integer role;

    /**
     * 专业ID
     */
    private Long specialityId;

    /**
     * 学籍ID
     */
    private Long portfolioId;

    /**
     * 专业
     */
    private String speciality;

    /**
     * 年级
     */
    private String grade;

    /**
     * 学号
     */
    private String number;

    /**
     * 班级
     */
    private String clbum;

    /**
     * 创建时间
     */
    private Long createdAt;

    /**
     * 更新时间
     */
    private Long updatedAt;
}
