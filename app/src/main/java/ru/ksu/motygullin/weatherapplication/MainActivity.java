package ru.ksu.motygullin.weatherapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;

import ru.ksu.motygullin.weatherapplication.Model.JSONWeatherParser;
import ru.ksu.motygullin.weatherapplication.Model.WeatherHttpClient;
import ru.ksu.motygullin.weatherapplication.resources.weather;

public class MainActivity extends AppCompatActivity {

    private ImageView WeatherIconImageView;
    private TextView conditionTextView;
    private TextView temperatureTextView;
    private TextView locationTextView;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String default_city = "Kazan,RU";

        WeatherIconImageView = (ImageView) findViewById(R.id.WeatherIconImageView);
        conditionTextView = (TextView) findViewById(R.id.conditionTextView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        WeatherTask task = new WeatherTask();
        task.execute(new String[]{default_city});
        dialog.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void selection(View view) {
        Intent intent = new Intent(this, LocationSelectActivity.class);

    }


    private class WeatherTask extends AsyncTask<String, Void, weather> {

        @Override
        protected weather doInBackground(String... params) {
            weather weather = new weather();
            String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));

            try {
                weather = JSONWeatherParser.getWeather(data);
                weather.iconData = (new WeatherHttpClient()).getImage(weather.currentCondition.getIcon());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return weather;

        }

        @Override
    protected void onPostExecute(weather weather) {
        super.onPostExecute(weather);

        if (weather.iconData != null && weather.iconData.length > 0) {
            Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
            WeatherIconImageView.setImageBitmap(img);
        }

            locationTextView.setText(weather.location.getCity() + "," + weather.location.getCountry());
            conditionTextView.setText(weather.currentCondition.getDescription());
            temperatureTextView.setText((Math.round(weather.currentCondition.getTemp()-273.15) ) +"\u00B0"+ "C");
          }



}
}

