package com.Development.Dev.controllers;

import com.Development.Dev.models.CoinModel;
import com.Development.Dev.models.TaskLog;
import com.Development.Dev.repositories.CoinRepository;
import com.Development.Dev.repositories.TaskLogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BitcoinPriceUpdaterService {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private TaskLogRepository taskLogRepository;

    private static final String BITCOIN_API_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    @Scheduled (cron = "0 0 * * * *") //(cron = "0 * * * * *") //         //(cron = "*/10 * * * * *")
    public void updateBitcoinPrice() {
        //создает новый объект TaskLog, чтобы сохранить информацию о выполнении задачи, включая успешность выполнения и цену биткоина.
        TaskLog taskLog = new TaskLog();
        taskLog.setExecutionTime(LocalDateTime.now());

        try {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(BITCOIN_API_URL, String.class);

            // Parse the JSON response to get the bitcoin price
            Double bitcoinPrice = parseBitcoinPrice(response);



            // Логирование выполнения задачи с ценой биткоина
            taskLog.setSuccess(true);
            taskLog.setBitcoinPriceUsd(bitcoinPrice);
        } catch (Exception e) {
            taskLog.setSuccess(false);
        }

        taskLogRepository.save(taskLog);
        cleanupOldLogs();
    }

    private Double parseBitcoinPrice(String response) throws JsonProcessingException {
        // Логика парсинга JSON ответа и извлечения цены биткоина
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
        return node.path("bpi").path("USD").path("rate_float").asDouble();
    }

    private void cleanupOldLogs() {
        // Получает все записи логов задач, упорядоченные по времени выполнения в порядке убывания
        List<TaskLog> logs = taskLogRepository.findAllByOrderByExecutionTimeDesc();

        // Если записей больше 10, удаляем все, кроме последних 10
        if (logs.size() > 10) {
            List<TaskLog> logsToDelete = logs.subList(10, logs.size());
            taskLogRepository.deleteAll(logsToDelete);
        }
    }
}
