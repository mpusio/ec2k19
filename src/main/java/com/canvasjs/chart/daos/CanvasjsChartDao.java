package com.canvasjs.chart.daos;

import java.io.IOException;


public interface CanvasjsChartDao {

    String getHistoricalExchangeData() throws IOException;

    void setHisoricalExchangeData(String exchageFrom, String exchangeTo) throws IOException;

    String getTrendLineData() throws IOException;

    void setTrednLineData(String exchangeFrom, String exchangeTo) throws IOException;

    String getModeLineData() throws IOException;

    public void setModeLineData(String exchangeFrom, String exchangeTo) throws IOException;

}