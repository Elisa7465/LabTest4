package com.Development.Dev.dto;
import java.util.List;
public class ExchangesClass {
    private String name;
    private Double score;
    private Double volume24h;
    private Double markets;
    private Double coins;
    private List<Integer> lastVolume;

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

    public List<Integer> getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(List<Integer> lastVolume) {
        this.lastVolume = lastVolume;
    }
}
