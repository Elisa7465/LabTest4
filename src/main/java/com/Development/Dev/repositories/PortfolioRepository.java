package com.Development.Dev.repositories;

import com.Development.Dev.models.DealModel;
import com.Development.Dev.models.PortfolioModel;
import org.springframework.data.repository.CrudRepository;

public interface PortfolioRepository extends CrudRepository<PortfolioModel,Long> {
}
