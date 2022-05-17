package com.programming.java.JSoup;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BnbForeignCurrencyRates {
    private Date date;
    private List<ExchangeRate> exchangeRates;
}
