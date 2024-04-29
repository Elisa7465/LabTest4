package com.Development.Dev.models;

import jakarta.persistence.*;

@Entity
public class TrendModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coin_name;
    private String coin_code;
    private Double _24h;

    public TrendModel() {
    }

    public TrendModel(String coin_name, String coin_code, Double _24h) {
        this.coin_name = coin_name;
        this.coin_code = coin_code;
        this._24h = _24h;
    }

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

    public Double get_24h() {
        return _24h;
    }

    public void set_24h(Double _24h) {
        this._24h = _24h;
    }
}
