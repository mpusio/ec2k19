package com.canvasjs.chart.data;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.canvasjs.chart.useful.HandleJson.readJsonFromUrl;

public class CurriesData {

    private static JSONObject json = null;

    static {

        try {
            json = readJsonFromUrl("https://openexchangerates.org/api/currencies.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONArray convertToArrayJSON(JSONObject resources){
        return new JSONArray(resources);
    }

    public static String getCurriesList() {
        return convertToArrayJSON(json).toString();
    }

}


