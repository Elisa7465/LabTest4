package com.Development.Dev.controllers;

import com.Development.Dev.models.DealModel;
import com.Development.Dev.repositories.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DealController {
    @Autowired
    private DealRepository dealRepository;

    @GetMapping("/deals")
    public Iterable<DealModel> getAllDeals() {
        return dealRepository.findAll();
    }
    @PostMapping("/add-deal")
    public DealModel addDeals(@RequestBody DealModel deal) {
        dealRepository.save(deal);
        return deal;
    }
}
