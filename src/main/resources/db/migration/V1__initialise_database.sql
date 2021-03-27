-- 用户
CREATE TABLE `user`
(
    `id`         BIGINT(13)   NOT NULL AUTO_INCREMENT,
    `phone`      VARCHAR(255) NOT NULL DEFAULT '' COMMENT '电话号码',
    `password`   VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '密码',
    `name`       VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '昵称',
    `gender`     INT(1)       NOT NULL DEFAULT 1 COMMENT '性别,1-男 2-女',
    `avatar`     TEXT COMMENT '头像',
    `role`       INT(1)       NOT NULL DEFAULT 0 COMMENT '角色 1-管理员 2-教师 3-学生',
    `speciality` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '专业',
    `grade`      VARCHAR(255) NOT NULL DEFAULT '' COMMENT '年级',
    `number`     VARCHAR(255) NOT NULL DEFAULT '' COMMENT '学号',
    `clbum`      VARCHAR(255) NOT NULL DEFAULT '' COMMENT '班级',
    `created_at` BIGINT(13)   NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at` BIGINT(13)   NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 成绩表
CREATE TABLE `score`
(
    `id`         BIGINT(13)          NOT NULL AUTO_INCREMENT,
    `score`      VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '成绩',
    `user_id`    BIGINT(20) UNSIGNED NOT NULL COMMENT '用户ID',
    `course_id`  BIGINT(20) UNSIGNED NOT NULL COMMENT '课程ID',
    `created_at` BIGINT(13)          NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at` BIGINT(13)          NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 课程表
CREATE TABLE `course`
(
    `id`         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '课程名',
    `speciality` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '专业',
    `grade`      VARCHAR(255) NOT NULL DEFAULT '' COMMENT '年级',
    `created_at` BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at` BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT '课程表';

-- 上课时间表
CREATE TABLE `course_time`
(
    `id`         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `course_id`  BIGINT(20) UNSIGNED NOT NULL COMMENT '课程ID',
    `clbum`      VARCHAR(255) NOT NULL DEFAULT '' COMMENT '班级',
    `created_at` BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at` BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT '上课时间表';
