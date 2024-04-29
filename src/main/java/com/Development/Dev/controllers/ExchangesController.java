package com.Development.Dev.controllers;

import com.Development.Dev.models.DealModel;
import com.Development.Dev.models.ExchangesModel;
import com.Development.Dev.repositories.ExchangesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ExchangesController {
    @Autowired
    private ExchangesRepository exchangesRepository;
    @GetMapping("/exchanges")
    public Iterable<ExchangesModel> getAllExchanges() {
        return exchangesRepository.findAll();
    }
    @PostMapping("/add-exchanges")
    public ExchangesModel addExchanges(@RequestBody ExchangesModel exchange) {
        exchangesRepository.save(exchange);
        return exchange;
    }
}
