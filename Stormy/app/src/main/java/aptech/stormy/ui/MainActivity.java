package aptech.stormy.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import aptech.stormy.R;
import aptech.stormy.weather.Current;
import aptech.stormy.weather.Day;
import aptech.stormy.weather.Forecast;
import aptech.stormy.weather.Hour;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private Forecast mforecast;




    private TextView temperature;
    private TextView time;
    private TextView location;
    private TextView humidity;
    private TextView rain;
    private TextView summary;
    private ImageView iconview;
    private ImageView refreshicon;
    private ProgressBar progressBar;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        temperature = (TextView) findViewById(R.id.temperature);
        location = (TextView) findViewById(R.id.LocationLabel);
        time = (TextView) findViewById(R.id.time);
        summary = (TextView) findViewById(R.id.textView);
        humidity = (TextView) findViewById(R.id.humidityValue);
        rain = (TextView) findViewById(R.id.rainprobab);
        iconview = (ImageView) findViewById(R.id.IconimageView);
        refreshicon = (ImageView) findViewById(R.id.refresh);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        refreshicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                refreshForecaster();
                Togglebutton();

            }
        });
        refreshForecaster();


    }

    private void Togglebutton() {
        if (progressBar.getVisibility() == View.INVISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
            refreshicon.setVisibility(View.INVISIBLE);
        }
        else {

            refreshicon.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    private void refreshForecaster() {

        if (isNetworkThere()) {


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Togglebutton();
                }
            });


            String apiKey = "f54021bfc6e536f70c212e24c1b628dc";
            double latitude = 19.0760;
            double longitude = 72.8777;
            String forecastUrl = "https://api.forecast.io/forecast/" + apiKey + "/" + latitude + "," + longitude;


            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(forecastUrl).build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Togglebutton();
                    progressBar.setVisibility(View.VISIBLE);


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                    Log.e(TAG, "Excaught");


                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Togglebutton();
                        }
                    });

                    try {

                        final String jsondata = response.body().string();
                        if (response.isSuccessful()) {
                            mforecast = parseForecastDetails(jsondata);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Current current = mforecast.getMcurrentWeather();


                                    temperature.setText((current.getmTemp() - 32) * 5 / 9 + "");
                                    time.setText("AT " + current.getFormattedTime() + " it will be");
                                    humidity.setText(current.getmHumidity() + "");
                                    rain.setText(current.getmPrecipChance() + "%");
                                    summary.setText(current.getmSummary() + "");
                                    Drawable drawable = getResources().getDrawable(current.getIconId());
                                    iconview.setImageDrawable(drawable);
                                    location.setText("Mumbai ,India");


                                }
                            });


                        } else {
                            Handler a = new Handler(Looper.getMainLooper());
                            a.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this, "What's up something wrong ?", Toast.LENGTH_SHORT).show();
                                }
                            }, 500);


                        }
                    } catch (JSONException e)

                    {
                        Log.e(TAG, "JSON caught", e);

                    }


                }
            });
            } else {

            Toast.makeText(MainActivity.this, "Network is Unavailable", Toast.LENGTH_SHORT).show();
        }
    }



    private Forecast parseForecastDetails(String jsondata) throws JSONException {

        Forecast forecast = new Forecast();
        forecast.setMcurrentWeather(getAllDetails(jsondata));
        forecast.setmHourlyForecast(getHourlyForecast(jsondata));
        forecast.setmDailyForecast(getDailyForecast(jsondata));


        return forecast;
    }

    private Day[] getDailyForecast(String jsondata )throws JSONException {
        JSONObject forecaster = new JSONObject(jsondata);
        String timezone = forecaster.getString("timezone");
        JSONObject daily = forecaster.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");
        Day[] day = new Day[data.length()];
        for (int i = 0; i <data.length() ; i++) {

        JSONObject jsonday = data.getJSONObject(i);
        Day dayobject=new  Day();
            dayobject.setmSummary(jsonday.getString("summary"));
            dayobject.setmTime(jsonday.getLong("time"));
            dayobject.setmIcon(jsonday.getString("icon"));
            dayobject.setmTempMax(jsonday.getDouble("temperatureMax"));
            dayobject.setmTimezone(timezone);
            day[i]= dayobject;

    }
        return day;
}
    private Hour[] getHourlyForecast(String jsondata) throws JSONException{
        JSONObject forecaster = new JSONObject(jsondata);
        String timezone = forecaster.getString("timezone");
        JSONObject hourly = forecaster.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        Hour[] hours = new Hour[data.length()];
        for (int i = 0; i < data.length(); i++) {

            JSONObject jsonHour = data.getJSONObject(i);
            Hour hour = new Hour();
            hour.setmSummary(jsonHour.getString("summary"));
            hour.setmTemperature(jsonHour.getDouble("temperature"));
            hour.setmIcon(jsonHour.getString("icon"));
            hour.setmTimezone(timezone);
            hour.setMtime(jsonHour.getLong("timezone"));

            hours[i] = hour;



            
        }
        return hours;


    }

    private Current getAllDetails(String jsondata) throws JSONException {
        JSONObject forecast = new JSONObject(jsondata);


        JSONObject currentForecast = forecast.getJSONObject("currently");

        Current curr = new Current();
        curr.setmHumidity(currentForecast.getDouble("humidity"));
        curr.setmTime(currentForecast.getLong("time"));
        curr.setmIcon(currentForecast.getString("icon"));
        curr.setmPrecipChance(currentForecast.getDouble("precipProbability"));
        curr.setmSummary(currentForecast.getString("summary"));
        curr.setmTemp(currentForecast.getDouble("temperature")-32*(5/9));









        return curr;

    }

    private boolean isNetworkThere() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {

            isAvailable = true;
        }
        return isAvailable;

    }

}
