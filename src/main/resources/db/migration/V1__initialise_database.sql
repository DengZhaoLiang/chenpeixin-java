-- 用户
CREATE TABLE `user`
(
    `id`            BIGINT(13)          NOT NULL AUTO_INCREMENT,
    `phone`         VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '电话号码',
    `password`      VARCHAR(64)         NOT NULL DEFAULT '' COMMENT '密码',
    `name`          VARCHAR(64)         NOT NULL DEFAULT '' COMMENT '昵称',
    `gender`        INT(1)              NOT NULL DEFAULT 1 COMMENT '性别,1-男 2-女',
    `avatar`        TEXT COMMENT '头像',
    `role`          INT(1)              NOT NULL DEFAULT 0 COMMENT '角色 1-管理员 2-教师 3-学生',
    `number`        VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '学号',
    `speciality_id` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '专业ID',
    `portfolio_id`  BIGINT(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '学籍ID',
    `created_at`    BIGINT(13)          NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at`    BIGINT(13)          NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 课程表
CREATE TABLE `course`
(
    `id`         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '课程名',
    `user_id`    BIGINT(20) UNSIGNED NOT NULL COMMENT '教师ID',
    `created_at` BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at` BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT '课程表';

-- 专业表
CREATE TABLE `speciality`
(
    `id`         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '专业名',
    `created_at` BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at` BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT '专业表';

-- 学籍表
CREATE TABLE `portfolio`
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `grade`         VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '年级',
    `clbum`         VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '班级',
    `speciality_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '专业ID',
    `created_at`    BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at`    BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT '学籍表';

-- 上课信息表
CREATE TABLE `course_info`
(
    `id`           BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `course_id`    BIGINT(20) UNSIGNED NOT NULL COMMENT '课程ID',
    `portfolio_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '学籍ID',
    `place`        VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '上课地点',
    `weekday`      INT(1) UNSIGNED     NOT NULL DEFAULT 1 COMMENT '星期',
    `start`        VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '开始时间',
    `end`          VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '结束时间',
    `created_at`   BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at`   BIGINT(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT '上课信息表';

-- 学期表
CREATE TABLE `semester`
(
    `id`         BIGINT(13)   NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(255) NOT NULL DEFAULT '' COMMENT '学期名',
    `created_at` BIGINT(13)   NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at` BIGINT(13)   NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 学期课程信息表
CREATE TABLE `semester_course_info`
(
    `id`             BIGINT(13)          NOT NULL AUTO_INCREMENT,
    `semester_id`    BIGINT(20) UNSIGNED NOT NULL COMMENT '学期表ID',
    `course_info_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '上课信息表ID',
    `created_at`     BIGINT(13)          NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at`     BIGINT(13)          NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 成绩表
CREATE TABLE `score`
(
    `id`             BIGINT(13)          NOT NULL AUTO_INCREMENT,
    `score`          VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '成绩',
    `user_id`        BIGINT(20) UNSIGNED NOT NULL COMMENT '用户ID',
    `course_info_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '上课信息表ID',
    `created_at`     BIGINT(13)          NOT NULL DEFAULT 0 COMMENT '创建时间',
    `updated_at`     BIGINT(13)          NOT NULL DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

