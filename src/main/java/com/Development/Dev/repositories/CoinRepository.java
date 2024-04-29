package com.Development.Dev.repositories;
import com.Development.Dev.models.CoinModel;
import org.springframework.data.repository.CrudRepository;
public interface CoinRepository extends CrudRepository<CoinModel,Long>{
}
