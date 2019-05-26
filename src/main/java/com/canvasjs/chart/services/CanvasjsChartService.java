//CanvasjsChartService.java
package com.canvasjs.chart.services;

import java.io.IOException;

public interface CanvasjsChartService {

    String getHistoricalExchange() throws IOException;

    void setHistoricalExchange(String exchangeFrom, String exchangeTo) throws IOException;

    String getTrendLine() throws IOException;

    void setTrednLine(String exchangeFrom, String exchangeTo) throws IOException;

    String getModeLine() throws IOException;

    void setModeLine(String exchangeFrom, String exchangeTo) throws IOException;

}