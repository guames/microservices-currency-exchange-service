package com.guames.microservices.currencyexchangeservice.services;

import com.guames.microservices.currencyexchangeservice.exceptions.NotFoundException;
import com.guames.microservices.currencyexchangeservice.protocols.ExchangeValueResponse;

public interface ExchangeValueService {

    ExchangeValueResponse fetchExchangeValueByFromAndTo(String from, String to) throws NotFoundException;
}