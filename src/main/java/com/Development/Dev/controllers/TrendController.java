package com.Development.Dev.controllers;

import com.Development.Dev.models.CoinModel;
import com.Development.Dev.models.ExchangesModel;
import com.Development.Dev.models.TrendModel;
import com.Development.Dev.repositories.CoinRepository;
import com.Development.Dev.repositories.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TrendController {
    @Autowired
    private TrendRepository trendRepository;
    @Autowired
    private CoinRepository coinRepository;
    @GetMapping("/trends")
    public Iterable<TrendModel> getAllTrends() {
        return trendRepository.findAll();
    }
    @PostMapping("/add-trends")
    public TrendModel addTrends(@RequestBody CoinModel COIN){
    CoinModel coin= coinRepository.findById(COIN.getId()).orElse(null);
    if( coin!=null){
        TrendModel trend= new TrendModel(coin.getCoin_name(),coin.getCoin_code(),coin.get_24h());
        trendRepository.save(trend);
        return trend;
    }else{
        return null;
    }
    }
}
