package com.Development.Dev.dto;

public class TrendClass {
    private String coinName;
    private String coinCode;
    private Double _24h;

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public Double get_24h() {
        return _24h;
    }

    public void set_24h(Double _24h) {
        this._24h = _24h;
    }
}
