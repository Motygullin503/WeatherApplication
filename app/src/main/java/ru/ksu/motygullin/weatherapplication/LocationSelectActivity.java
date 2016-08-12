package ru.ksu.motygullin.weatherapplication;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.EditText;
import android.widget.ProgressBar;

import ru.ksu.motygullin.weatherapplication.R;

/**
 * Created by UseR7 on 03.07.2016.
 */
public class LocationSelectActivity extends AppCompatActivity {
    private ProgressBar bar;
    private String recentCity = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_select_activity);
    }


    private void searchCities() {
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        alert.setTitle(this.getString(R.string.search_title));
//        final EditText input = new EditText(this);
//        input.setInputType(InputType.TYPE_CLASS_TEXT);
//        input.setMaxLines(1);
//        input.setSingleLine(true);
//        alert.setView(input, 32, 0, 32, 0);
//        alert.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int whichButton) {
//                String result = input.getText().toString();
//                if (!result.isEmpty()) {
//                    saveLocation(result);
//                }
//            }
//        });
//        alert.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int whichButton) {
//
//            }
//        });
//        alert.show();
//    }
//
//    private void saveLocation(String result) {
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
//        recentCity = preferences.getString("city", SyncStateContract.Constants.DEFAULT_CITY);
//
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("city", result);
//        editor.commit();
//
//        if (!recentCity.equals(result)) {
//            getTodayWeather();
//            getLongTermWeather();
//        }
//    }

    }
}
