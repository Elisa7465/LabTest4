package com.Development.Dev.controllers;

import com.Development.Dev.dto.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;
@RestController
public class MainController {
    @GetMapping("/coinst")
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
    @GetMapping("/trendst")
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
    @GetMapping("/exchangest")
    public List<ExchangesClass> getExchanges() {
        // Создаем список изменений
        List<ExchangesClass> exchanges = new ArrayList<>();

        ExchangesClass exchange1=new ExchangesClass();
        exchange1.setName("Binance");
        exchange1.setScore(9.0);
        exchange1.setVolume24h(364578658725.0);
        exchange1.setMarkets(67.0);
        exchange1.setCoins(45.0);
        exchange1.setLastVolume(List.of(324, 436, 584, 987, 674));

        exchanges.add(exchange1);
        return exchanges;
    }
    @GetMapping("/portfoliot")
    public List<PortfolioClass> getPortfolio(){
        List<PortfolioClass> portfolios=new ArrayList<>();

        List<CoinClass> coins=new ArrayList<>();
        CoinClass coin1=new CoinClass();
        coin1.setCoinName("Bitcoin");
        coin1.setCoinCode("BTC");
        coin1.setVolume(34.0);
        coin1.setPrice(3289476278.0);
        coin1.setLastPrice(List.of(324, 436, 584, 987, 674));
        coins.add(coin1);

        List<DealClass> deals=new ArrayList<>();
        DealClass deal1=new DealClass();
        deal1.setDate("2024-02-02T12:33:33");
        deal1.setType("sell");
        deal1.setPrice(3543256.0);
        deal1.setVolume(3.0);
        deal1.setCoinName("Bitcoin");
        deal1.setCoinCode("BTC");
        deals.add(deal1);

        PortfolioClass portfolio1=new PortfolioClass();
        portfolio1.setCoins(coins);
        portfolio1.setDeals(deals);
        portfolio1.setProfile_volume_usd(List.of(324.0,436.0,584.0,987.0,674.0));
        portfolio1.setProfile_volume_btc(List.of(324.0,436.0,584.0,987.0,674.0));
        portfolio1.setCurrent_volume_usd(345.0);
        portfolio1.setCurrent_volume_btc(345.0);
        portfolios.add(portfolio1);
        return portfolios;
    }

    private final List<DealClass> deals = new ArrayList<>();
    @PostMapping("/add-dealt")
    public List<DealClass> addDeal(@RequestBody DealClass deal) {

        // Добавляем сделку в список
        deals.add(deal);
        // Возвращаем список всех сделок после добавления новой
        return deals;
    }
}
