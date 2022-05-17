package com.programming.java.JSoup;

import lombok.Data;

@Data
public class ExchangeRate {
    private String currencyNameBG;
    private String currencySymbol;
    private int amountForeignUnits;
    private double priceInBGN;
    private double singeUnitPriceInBGN;
}
