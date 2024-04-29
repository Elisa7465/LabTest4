package com.Development.Dev.repositories;

import com.Development.Dev.models.DealModel;
import com.Development.Dev.models.TrendModel;
import org.springframework.data.repository.CrudRepository;

public interface TrendRepository extends CrudRepository<TrendModel,Long> {
}
