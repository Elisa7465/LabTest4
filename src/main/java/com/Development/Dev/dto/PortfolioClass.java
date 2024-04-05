package com.Development.Dev.dto;
import java.util.List;
public class PortfolioClass {
    private List<CoinClass> coins;
    private List<DealClass> deals;
    private List<Double> profile_volume_usd;
    private List<Double> profile_volume_btc;
    private Double current_volume_usd;
    private Double current_volume_btc;

    public List<CoinClass> getCoins() {
        return coins;
    }

    public void setCoins(List<CoinClass> coins) {
        this.coins = coins;
    }

    public List<DealClass> getDeals() {
        return deals;
    }

    public void setDeals(List<DealClass> deals) {
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
