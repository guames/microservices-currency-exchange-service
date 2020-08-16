package com.guames.microservices.currencyexchangeservice.controllers;

import com.guames.microservices.currencyexchangeservice.exceptions.NotFoundException;
import com.guames.microservices.currencyexchangeservice.protocols.ExchangeValueResponse;
import com.guames.microservices.currencyexchangeservice.services.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueService exchangeValueService;

    @GetMapping("from/{from}/to/{to}")
    public ExchangeValueResponse retrieveExchangeValue(@PathVariable String from, @PathVariable String to) throws NotFoundException {
        return exchangeValueService.fetchExchangeValueByFromAndTo(from, to);
    }
}
