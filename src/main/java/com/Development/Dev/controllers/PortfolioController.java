package com.Development.Dev.controllers;

import com.Development.Dev.models.*;
import com.Development.Dev.repositories.CoinRepository;
import com.Development.Dev.repositories.DealRepository;
import com.Development.Dev.repositories.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class PortfolioController {
    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private DealRepository dealRepository;
    @Autowired
    private CoinRepository coinRepository;
    @GetMapping ("/portfolios")
    public Iterable<PortfolioModel> getAllPortfolios() {
        return portfolioRepository.findAll();
    }
    @GetMapping("/portfolios/{id}")
    public PortfolioModel getPortfolioById(@PathVariable Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }
    @PostMapping("/add-portfolio")
    public PortfolioModel addPortfolio(@RequestBody PortfolioModel portfolio) {
        // Сначала сохраняем связанные объекты
        for (CoinModel coin : portfolio.getCoins()) {
            coinRepository.save(coin);
        }
        for (DealModel deal : portfolio.getDeals()) {
            dealRepository.save(deal);
        }
        // Потом сохраняем портфель
        portfolioRepository.save(portfolio);
        return portfolio;
    }
    @PostMapping("/portfolio/{id}/add-deal")
    public DealModel ADD_Deal(@PathVariable Long id, @RequestBody DealModel DEAL) {
        PortfolioModel portfolio = portfolioRepository.findById(id).orElse(null);
        if (portfolio != null) {
            portfolio.getDeals().add(DEAL);
            dealRepository.save(DEAL);
            portfolioRepository.save(portfolio);
            return DEAL;
        } else {
            return null;
        }
    }
    @PostMapping("/portfolio/{id}/add-coin")
    public CoinModel ADD_Coin(@PathVariable Long id, @RequestBody CoinModel COIN) {
        PortfolioModel portfolio = portfolioRepository.findById(id).orElse(null);
        if (portfolio != null) {
            CoinModel coin = coinRepository.findById(COIN.getId()).orElse(null);
            if (coin != null) {
                portfolio.getCoins().add(coin);
                portfolioRepository.save(portfolio);
                return coin;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
