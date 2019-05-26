package com.canvasjs.chart.daos;

import java.io.IOException;

public interface ExchangeRateDao {
    void setExchangeData(String exchangeFrom, String exchangeTo) throws IOException;

    String getExchangeData() throws IOException;
}
