package com.chenpeixin.service.api.portfolio;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.model.Portfolio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author chenpeixin
 * 2021-04-03
 */
public interface PortfolioService {

    /**
     * 分页获取学籍信息
     */
    Page<Portfolio> pagePortfolios(Pageable pageable);

    /**
     * 新增学籍
     */
    void insertPortfolio(Portfolio portfolio);

    /**
     * 修改学籍
     */
    void updatePortfolio(Portfolio portfolio);

    /**
     * 删除学籍
     */
    void deletePortfolio(Long id);

    /**
     * 批量删除学籍
     */
    void batchDeletePortfolios(IDSRequest request);
}
