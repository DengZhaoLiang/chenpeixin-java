package com.chenpeixin.service.api.portfolio;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.mapper.PortfolioMapper;
import com.chenpeixin.model.Portfolio;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioMapper mPortfolioMapper;

    @Override
    public Page<Portfolio> pagePortfolios(Portfolio portfolio, Pageable pageable) {
        PageRequest page = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
        QueryWrapper<Portfolio> wrapper = new QueryWrapper<>();
        wrapper.eq(Strings.isNotBlank(portfolio.getGrade()),"grade", portfolio.getGrade());
        wrapper.eq(Objects.nonNull(portfolio.getSpecialityId()),"speciality_id", portfolio.getSpecialityId());
        List<Portfolio> portfolios = mPortfolioMapper.selectList(wrapper);
        return new PageImpl<>(portfolios.stream()
                .skip((page.getPageNumber()) * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList()), page, portfolios.size());
    }

    @Override
    public Portfolio selectPortfolios(Long id) {
        return mPortfolioMapper.selectById(id);
    }

    @Override
    public void insertPortfolio(Portfolio portfolio) {
        // 校验是否成功
        mPortfolioMapper.insert(portfolio);
    }

    @Override
    public void updatePortfolio(Portfolio portfolio) {
        UpdateWrapper<Portfolio> wrapper = new UpdateWrapper<>();
        wrapper.set(Strings.isNotBlank(portfolio.getGrade()), "grade", portfolio.getGrade());
        wrapper.set(Strings.isNotBlank(portfolio.getClbum()), "clbum", portfolio.getClbum());
        wrapper.set(!Objects.isNull(portfolio.getSpecialityId()), "speciality_id", portfolio.getSpecialityId());
        portfolio.setUpdatedAt(Instant.now().getEpochSecond());
        wrapper.eq("id", portfolio.getId());
        mPortfolioMapper.update(portfolio, wrapper);
    }

    @Override
    public void deletePortfolio(Long id) {
        mPortfolioMapper.deleteById(id);
    }

    @Override
    public void batchDeletePortfolios(IDSRequest request) {
        mPortfolioMapper.deleteBatchIds(request.getIds());
    }
}
