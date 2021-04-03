package com.chenpeixin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Data
public class Speciality {

    /**
     * 专业ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 专业名
     */
    private String name;

    /**
     * 创建时间
     */
    private Long createdAt;

    /**
     * 更新时间
     */
    private Long updatedAt;
}
