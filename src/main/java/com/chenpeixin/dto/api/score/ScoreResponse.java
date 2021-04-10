package com.chenpeixin.dto.api.score;

import com.chenpeixin.model.Score;
import lombok.Data;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Data
public class ScoreResponse extends Score {
    private String grade;
    private String speciality;
    private String className;
    private String course;
    private String user;
}
