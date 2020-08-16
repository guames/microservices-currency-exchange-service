package com.guames.microservices.currencyexchangeservice.services;

import com.guames.microservices.currencyexchangeservice.entities.ExchangeValue;
import com.guames.microservices.currencyexchangeservice.exceptions.NotFoundException;
import com.guames.microservices.currencyexchangeservice.protocols.ExchangeValueResponse;
import com.guames.microservices.currencyexchangeservice.repositories.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Autowired
    private Environment environment;

    public ExchangeValueResponse fetchExchangeValueByFromAndTo(String from, String to) throws NotFoundException {
        Optional<ExchangeValue> exchangeValue = exchangeValueRepository.findExchangeValueByFromAndTo(from, to);
        ExchangeValueResponse exchangeValueResponse = ExchangeValueResponse.of(exchangeValue);
        exchangeValueResponse.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValueResponse;
    }
}
