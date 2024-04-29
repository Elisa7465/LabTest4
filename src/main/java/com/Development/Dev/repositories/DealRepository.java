package com.Development.Dev.repositories;

import com.Development.Dev.models.CoinModel;
import com.Development.Dev.models.DealModel;
import org.springframework.data.repository.CrudRepository;

public interface DealRepository extends CrudRepository<DealModel,Long> {
}
