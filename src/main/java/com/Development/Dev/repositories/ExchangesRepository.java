package com.Development.Dev.repositories;

import com.Development.Dev.models.DealModel;
import com.Development.Dev.models.ExchangesModel;
import org.springframework.data.repository.CrudRepository;

public interface ExchangesRepository extends CrudRepository<ExchangesModel,Long> {
}
