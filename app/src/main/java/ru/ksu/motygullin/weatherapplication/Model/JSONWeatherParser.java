package ru.ksu.motygullin.weatherapplication.Model;

import android.location.Location;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ru.ksu.motygullin.weatherapplication.resources.location;
import ru.ksu.motygullin.weatherapplication.resources.weather;

public class JSONWeatherParser {

    public static weather getWeather(String data) throws JSONException {
        weather weather = new weather();

        // Creating JSONObject from the data
        JSONObject jObj = new JSONObject(data);

        // Extracting the info
        location loc = new location();

        JSONObject sysObj = getObject("sys", jObj);
        loc.setCountry(getString("country", sysObj));

        loc.setCity(getString("name", jObj));
        weather.location = loc;

        // Getting weather info
        JSONArray jArr = jObj.getJSONArray("weather");

        JSONObject JSONWeather = jArr.getJSONObject(0);
        weather.currentCondition.setId(getInt("id", JSONWeather));
        weather.currentCondition.setDescription(getString("description", JSONWeather));
        weather.currentCondition.setMain(getString("main", JSONWeather));
        weather.currentCondition.setIcon(getString("icon", JSONWeather));

        JSONObject mainObj = getObject("main", jObj);
        weather.currentCondition.setTemp(getFloat("temp", mainObj));

        return weather;
    }


    private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        return jObj.getJSONObject(tagName);

    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }


    private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }

}
