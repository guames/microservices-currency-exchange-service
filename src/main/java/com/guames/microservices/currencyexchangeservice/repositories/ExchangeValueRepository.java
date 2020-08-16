package com.guames.microservices.currencyexchangeservice.repositories;

import com.guames.microservices.currencyexchangeservice.entities.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    Optional<ExchangeValue> findExchangeValueByFromAndTo(String from, String to);

}
