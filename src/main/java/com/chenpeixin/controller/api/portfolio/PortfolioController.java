package com.chenpeixin.controller.api.portfolio;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.dto.api.score.ScoreResponse;
import com.chenpeixin.model.Portfolio;
import com.chenpeixin.service.api.portfolio.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Validated
@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService mPortfolioService;

    @GetMapping("")
    public Page<Portfolio> pagePortfolios(Portfolio portfolio, Pageable pageable) {
        return mPortfolioService.pagePortfolios(portfolio, pageable);
    }

    @GetMapping("/{id}")
    public Portfolio selectScore(@PathVariable Long id) {
        return mPortfolioService.selectPortfolios(id);
    }

    @PostMapping("")
    public void insertPortfolio(@RequestBody @Validated Portfolio portfolio) {
        mPortfolioService.insertPortfolio(portfolio);
    }

    @PutMapping("")
    public void updatePortfolio(@RequestBody @Validated Portfolio portfolio) {
        mPortfolioService.updatePortfolio(portfolio);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable Long id) {
        mPortfolioService.deletePortfolio(id);
    }

    @DeleteMapping("/batch")
    public void batchDeletePortfolios(@RequestBody @Validated IDSRequest request) {
        mPortfolioService.batchDeletePortfolios(request);
    }
}
