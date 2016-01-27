package com.example.rhernande.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rhernande on 1/25/16.
 */
public class WeatherDataParser {
    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        JSONObject obj = new JSONObject(weatherJsonStr);
        JSONArray days = obj.getJSONArray("list");
        if (days != null && !days.isNull(dayIndex)) {
            JSONObject day = days.getJSONObject(dayIndex);
            JSONObject temp = day.getJSONObject("temp");
            return temp.getDouble("max");
        }
        return -1;
    }
}
