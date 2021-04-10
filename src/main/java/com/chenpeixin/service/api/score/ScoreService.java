package com.chenpeixin.service.api.score;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.dto.api.score.ScoreResponse;
import com.chenpeixin.model.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author chenpeixin
 * 2021-03-29
 */
public interface ScoreService {

    /**
     * 分页获取成绩
     */
    Page<ScoreResponse> pageScores(Pageable pageable);

    /**
     * 获取成绩详情
     */
    ScoreResponse selectScore(Long id);

    /**
     * 新增成绩
     */
    void insertScore(Score score);

    /**
     * 修改成绩
     */
    void updateScore(Score score);

    /**
     * 删除成绩
     */
    void deleteScore(Long id);

    /**
     * 批量删除成绩
     */
    void batchDeleteScore(IDSRequest request);
}
