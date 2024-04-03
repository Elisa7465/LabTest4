package com.Development.Dev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Development.Dev.dto.DealClass;
import com.Development.Dev.dto.CoinClass;
import com.Development.Dev.dto.TrendClass;

import java.util.ArrayList;
import java.util.List;
@RestController
public class MainController {
    @GetMapping("/coins")
    public List<CoinClass> getCoins() {
        List<CoinClass> coins = new ArrayList<>();

        // Создаем объекты CoinClass и добавляем их в список
        CoinClass coin1 = new CoinClass();
        coin1.setCoinName("Bitcoin");
        coin1.setCoinCode("BTC");
        coin1.setPrice(50000.0);
        coin1.set_1h(-25.0);
        coin1.set_24h(23.0);
        coin1.set_7d(56.0);
        coin1.setMarketCap(2303534050432.0);
        coin1.setVolume(4395723867.0);
        coin1.setLastPrice(List.of(324, 436, 584, 987, 674));
        coins.add(coin1);

        return coins;
    }
    @GetMapping("/trends")
    public List<TrendClass> getTrends() {
        // Создаем список трендов
        List<TrendClass> trends = new ArrayList<>();
        //Создаём объекты тренда
        TrendClass trend1 = new TrendClass();
        trend1.setCoinCode("Bitcoin");
        trend1.setCoinCode("BTC");
        trend1.set_24h(23.0);

        TrendClass trend2 = new TrendClass();
        trend2.setCoinCode("Bitcoin");
        trend2.setCoinCode("BTC");
        trend2.set_24h(30.0);
        //Добавляем объекты в список
        trends.add(trend1);
        trends.add(trend2);

        return trends;
    }


    private final List<DealClass> deals = new ArrayList<>();
    @PostMapping("/add-deal")
    public List<DealClass> addDeal(@RequestBody DealClass deal) {

        // Добавляем сделку в список
        deals.add(deal);
        // Возвращаем список всех сделок после добавления новой
        return deals;
    }
}
