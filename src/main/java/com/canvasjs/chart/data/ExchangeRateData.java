package com.canvasjs.chart.data;

import com.canvasjs.chart.useful.HandleJson;
import org.json.JSONObject;

import java.io.IOException;

import static com.canvasjs.chart.useful.HandleJson.readJsonFromUrl;

public class ExchangeRateData {
    private static JSONObject resources;

    static {
        try {
            resources = readJsonFromUrl("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=JPY&apikey=5BH9VE5T22Y2EW49");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getExchangeRate(){
        return resources.getJSONObject("Realtime Currency Exchange Rate").get("5. Exchange Rate").toString().substring(0,6);
    }

    public static void setExchangeRate(String exchangeFrom, String exchangeTo) throws IOException {
        String apikey = "OSXGKBSLM61SZEI1";
        String adress = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency="+
                exchangeFrom + "&to_currency=" + exchangeTo + "&apikey=" + apikey;

        resources = HandleJson.readJsonFromUrl(adress);
        //JSONObject exchangeRateObject = HandleJson.readJsonFromUrl(adress).getJSONObject("Realtime Currency Exchange Rate");
    }
}
