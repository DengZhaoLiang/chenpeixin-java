package com.chenpeixin.service.api.score;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chenpeixin.assembler.TeacherAssembler;
import com.chenpeixin.assembler.UserAssembler;
import com.chenpeixin.constant.RoleType;
import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.dto.api.score.ScoreResponse;
import com.chenpeixin.dto.api.teacher.CourseResponse;
import com.chenpeixin.mapper.CourseMapper;
import com.chenpeixin.mapper.ScoreMapper;
import com.chenpeixin.mapper.SpecialityMapper;
import com.chenpeixin.mapper.UserMapper;
import com.chenpeixin.model.Score;
import com.chenpeixin.model.Speciality;
import com.chenpeixin.model.Teacher;
import com.chenpeixin.model.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenpeixin
 * 2021-03-29
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper mScoreMapper;

    @Override
    public Page<ScoreResponse> pageScores(Pageable pageable) {
        PageRequest page = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        List<ScoreResponse> specialities = mScoreMapper.selectScoreList(wrapper);
        return new PageImpl<>(specialities.stream()
                .skip((page.getPageNumber()) * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList()), page, specialities.size());
    }

    @Override
    public ScoreResponse selectScore(Long id) {
        return mScoreMapper.queryById(id);
    }

    @Override
    public void insertScore(Score score) {
        mScoreMapper.insert(score);
    }

    @Override
    public void updateScore(Score score) {
        UpdateWrapper<Score> wrapper = new UpdateWrapper<>();
        wrapper.set(Strings.isNotBlank(score.getScore()), "score", score.getScore());
        score.setUpdatedAt(Instant.now().getEpochSecond());
        wrapper.eq("id", score.getId());
        mScoreMapper.update(score, wrapper);
    }

    @Override
    public void deleteScore(Long id) {
        mScoreMapper.deleteById(id);
    }

    @Override
    public void batchDeleteScore(IDSRequest request) {
        mScoreMapper.deleteBatchIds(request.getIds());
    }
}
