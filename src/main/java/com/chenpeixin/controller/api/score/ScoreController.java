package com.chenpeixin.controller.api.score;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.dto.api.score.ScoreResponse;
import com.chenpeixin.model.Score;
import com.chenpeixin.service.api.score.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Validated
@RestController
@RequestMapping("/api/score")
public class ScoreController {

    @Autowired
    private ScoreService mScoreService;

    @GetMapping("")
    public Page<ScoreResponse> pageScores(Pageable pageable) {
        return mScoreService.pageScores(pageable);
    }

    @GetMapping("/{id}")
    public ScoreResponse selectScore(@PathVariable Long id) {
        return mScoreService.selectScore(id);
    }

    @PostMapping("")
    public void insertScore(@RequestBody @Validated Score score) {
        mScoreService.insertScore(score);
    }

    @PutMapping("")
    public void updateScore(@RequestBody @Validated Score score) {
        mScoreService.updateScore(score);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Long id) {
        mScoreService.deleteScore(id);
    }

    @DeleteMapping("/batch")
    public void batchDeleteScore(@RequestBody @Validated IDSRequest request) {
        mScoreService.batchDeleteScore(request);
    }
}
