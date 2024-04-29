package com.Development.Dev.controllers;

import com.Development.Dev.models.CoinModel;
import com.Development.Dev.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping("/coins")
    public Iterable<CoinModel> getAllCoins() {
        return coinRepository.findAll();
    }
    @PostMapping("/add-coins")
    public CoinModel addCoins(@RequestBody CoinModel coin){
    coinRepository.save(coin);
    return coin;
    }

}
