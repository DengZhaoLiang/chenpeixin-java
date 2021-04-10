package com.chenpeixin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenpeixin.dto.api.score.ScoreResponse;
import com.chenpeixin.model.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Mapper
@Repository
public interface ScoreMapper extends BaseMapper<Score> {

    List<ScoreResponse> selectScoreList(Wrapper<Score> wrapper);

    ScoreResponse queryById(Long id);
}