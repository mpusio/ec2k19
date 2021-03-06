package com.canvasjs.chart.data;

import java.io.IOException;

import org.json.JSONObject;

import static com.canvasjs.chart.useful.HandleJson.parseSpecificJSON;
import static com.canvasjs.chart.useful.HandleJson.readJsonFromUrl;


public class HistoricalExchangeData {

    private static JSONObject resources;

    static {
        try {
            resources = readJsonFromUrl("https://www.alphavantage.co/query?function=FX_DAILY&from_symbol=USD&to_symbol=JPY&apikey=O6KQVKR3VL8CRUIS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setJsonData(String exchangeFrom, String exchangeTo) throws IOException {
        String apikey = "O6KQVKR3VL8CRUIS";
        String adress = "https://www.alphavantage.co/query?function=FX_DAILY&from_symbol=" +
                exchangeFrom + "&to_symbol=" + exchangeTo + "&outputsize=full&apikey=" + apikey;

        resources = readJsonFromUrl(adress);
    }

    public static String getJsonData() throws IOException {
        return parseSpecificJSON(resources, "Time Series FX (Daily)", "4. close").toString();
    }

}
