package com.Development.Dev.models;

import com.Development.Dev.dto.CoinClass;
import com.Development.Dev.dto.DealClass;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
public class PortfolioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<CoinModel> coins;
    @OneToMany
    private List<DealModel> deals;
    @ElementCollection
    private List<Double> profile_volume_usd = new ArrayList<>();
    @ElementCollection
    private List<Double> profile_volume_btc = new ArrayList<>();
    private Double current_volume_usd;
    private Double current_volume_btc;

    public PortfolioModel() {
    }

    public PortfolioModel(List<CoinModel> coins, List<DealModel> deals, List<Double> profile_volume_usd, List<Double> profile_volume_btc, Double current_volume_usd, Double current_volume_btc) {
        this.coins = coins;
        this.deals = deals;
        this.profile_volume_usd = profile_volume_usd;
        this.profile_volume_btc = profile_volume_btc;
        this.current_volume_usd = current_volume_usd;
        this.current_volume_btc = current_volume_btc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CoinModel> getCoins() {
        return coins;
    }

    public void setCoins(List<CoinModel> coins) {
        this.coins = coins;
    }

    public List<DealModel> getDeals() {
        return deals;
    }

    public void setDeals(List<DealModel> deals) {
        this.deals = deals;
    }

    public List<Double> getProfile_volume_usd() {
        return profile_volume_usd;
    }

    public void setProfile_volume_usd(List<Double> profile_volume_usd) {
        this.profile_volume_usd = profile_volume_usd;
    }

    public List<Double> getProfile_volume_btc() {
        return profile_volume_btc;
    }

    public void setProfile_volume_btc(List<Double> profile_volume_btc) {
        this.profile_volume_btc = profile_volume_btc;
    }

    public Double getCurrent_volume_usd() {
        return current_volume_usd;
    }

    public void setCurrent_volume_usd(Double current_volume_usd) {
        this.current_volume_usd = current_volume_usd;
    }

    public Double getCurrent_volume_btc() {
        return current_volume_btc;
    }

    public void setCurrent_volume_btc(Double current_volume_btc) {
        this.current_volume_btc = current_volume_btc;
    }
}
