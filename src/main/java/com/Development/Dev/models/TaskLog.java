package com.Development.Dev.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class TaskLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime executionTime;
    private boolean success;
    private Double bitcoinPriceUsd;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Double getBitcoinPriceUsd() {
        return bitcoinPriceUsd;
    }

    public void setBitcoinPriceUsd(Double bitcoinPriceUsd) {
        this.bitcoinPriceUsd = bitcoinPriceUsd;
    }
}

