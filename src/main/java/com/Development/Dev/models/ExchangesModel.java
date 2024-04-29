package com.Development.Dev.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ExchangesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double score;
    private Double volume24h;
    private Double markets;
    private Double coins;
    @ElementCollection
    private List<Double> last_volume;

    public ExchangesModel() {
    }

    public ExchangesModel(String name, Double score, Double volume24h, Double markets, Double coins, List<Double> last_volume) {
        this.name = name;
        this.score = score;
        this.volume24h = volume24h;
        this.markets = markets;
        this.coins = coins;
        this.last_volume = last_volume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(Double volume24h) {
        this.volume24h = volume24h;
    }

    public Double getMarkets() {
        return markets;
    }

    public void setMarkets(Double markets) {
        this.markets = markets;
    }

    public Double getCoins() {
        return coins;
    }

    public void setCoins(Double coins) {
        this.coins = coins;
    }

    public List<Double> getLast_volume() {
        return last_volume;
    }

    public void setLast_volume(List<Double> last_volume) {
        this.last_volume = last_volume;
    }
}
