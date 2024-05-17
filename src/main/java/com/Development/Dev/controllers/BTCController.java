package com.Development.Dev.controllers;

import com.Development.Dev.models.BTCModels;
import com.Development.Dev.repositories.BTCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.stream.StreamSupport;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@Controller
public class BTCController {
    @Autowired
    private BTCRepository btcRepository;
    @GetMapping("/api/bitcoins")
    @ResponseBody
    public Iterable<BTCModels> getBitcoins(){
        Iterable<BTCModels> bitcoins = btcRepository.findAll();
        return bitcoins;
    }

    @GetMapping("/api/current-bitcoin")
    @ResponseBody
    public BTCModels getBitcoin(){
        // Создание экземпляра RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Выполнение GET-запроса и получение ответа в виде ResponseEntity
        ResponseEntity<String> response = restTemplate.getForEntity("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);
        // Извлечение тела ответа в виде строки JSON
        String json = response.getBody();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(json).getAsJsonObject();
        String time = jsonObject.getAsJsonObject("time").get("updated").getAsString();
        Double usd = jsonObject.getAsJsonObject("bpi").getAsJsonObject("USD").get("rate_float").getAsDouble();
        BTCModels newBitcoin = new BTCModels(time, usd);
        // Если количество записей больше 10, удаляем самую старую запись
        if (btcRepository.count() == 10) {
            Iterable<BTCModels> bitcoins = btcRepository.findAll();
            BTCModels[] bitcoinArray = StreamSupport.stream(bitcoins.spliterator(), false).toArray(BTCModels[]::new);
            BTCModels oldBitcoin = bitcoinArray[0];
            btcRepository.deleteById(oldBitcoin.getId());
        }
        btcRepository.save(newBitcoin);
        return newBitcoin;
    }
}
