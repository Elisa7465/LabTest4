package com.Development.Dev.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CoinModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coin_name;
    private String coin_code;
    private Double price;
    private Double _1h;
    private Double _24h;
    private Double _7d;
    private Double market_cap;
    private Double volume;
    @ElementCollection
    private List<Double> lastPrice;

    public CoinModel() {
    }
    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public String getCoin_code() {
        return coin_code;
    }

    public void setCoin_code(String coin_code) {
        this.coin_code = coin_code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double get_1h() {
        return _1h;
    }

    public void set_1h(Double _1h) {
        this._1h = _1h;
    }

    public Double get_24h() {
        return _24h;
    }

    public void set_24h(Double _24h) {
        this._24h = _24h;
    }

    public Double get_7d() {
        return _7d;
    }

    public void set_7d(Double _7d) {
        this._7d = _7d;
    }

    public Double getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(Double market_cap) {
        this.market_cap = market_cap;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public List<Double> getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(List<Double> lastPrice) {
        this.lastPrice = lastPrice;
    }

    public CoinModel(String coin_name, String coin_code, Double price, Double _1h, Double _24h, Double _7d, Double market_cap, Double volume, List<Double> lastPrice) {
        this.coin_name = coin_name;
        this.coin_code = coin_code;
        this.price = price;
        this._1h = _1h;
        this._24h = _24h;
        this._7d = _7d;
        this.market_cap = market_cap;
        this.volume = volume;
        this.lastPrice = lastPrice;
    }
}
