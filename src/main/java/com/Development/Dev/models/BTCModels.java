package com.Development.Dev.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BTCModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String time;
    Double usd;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public BTCModels(String time, Double usd) {
        this.time = time;
        this.usd = usd;
    }
    public BTCModels() {
        // Default constructor
    }
}
