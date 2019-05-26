package com.canvasjs.chart.services;

import java.io.IOException;

public interface ExchangeRateService {

    void setExchangeDao(String exchangeFrom, String exchangeTo) throws IOException;

    String getExchangeDao() throws IOException;
}
