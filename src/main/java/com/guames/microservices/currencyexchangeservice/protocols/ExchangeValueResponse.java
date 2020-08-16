package com.guames.microservices.currencyexchangeservice.protocols;

import com.guames.microservices.currencyexchangeservice.entities.ExchangeValue;
import com.guames.microservices.currencyexchangeservice.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ExchangeValueResponse {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;

    public static ExchangeValueResponse of(Optional<ExchangeValue> exchangeValue) throws NotFoundException {
        return exchangeValue.map(exchangeVal -> ExchangeValueResponse.builder()
                .id(exchangeVal.getId())
                .from(exchangeVal.getFrom())
                .to(exchangeVal.getTo())
                .conversionMultiple(exchangeVal.getConversionMultiple())
                .build())
                .orElseThrow(NotFoundException::new);
    }
}
