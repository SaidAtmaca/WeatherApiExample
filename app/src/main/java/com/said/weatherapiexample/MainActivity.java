package com.said.weatherapiexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.said.weatherapiexample.Api.TempInfo;
import com.said.weatherapiexample.Api.WeatherApi;
import com.said.weatherapiexample.Api.WeatherInfo;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private static final String BASE_URL= "https://api.openweathermap.org/";
    Retrofit retrofit;
    TextView txt1,txt2,txt3,txt4,txt5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       init();

        Gson gson=new GsonBuilder().setLenient().create();


        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();



            loadData();







    }

    public void init(){
        txt1=findViewById(R.id.name);
        txt2=findViewById(R.id.tempoo);
        txt3=findViewById(R.id.pressure);
        txt4=findViewById(R.id.humidity);
        txt5=findViewById(R.id.wind);

    }

    public void loadData(){
        WeatherApi weatherApi=retrofit.create(WeatherApi.class);

        Call<WeatherInfo> call=weatherApi.getData();

        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                WeatherInfo weatherInfo=response.body();

                String temp_val=String.valueOf(Math.round(weatherInfo.main.temp-272));


                txt1.setText(weatherInfo.name.toUpperCase(Locale.ROOT));
                txt2.setText(temp_val);
                txt3.setText(weatherInfo.main.pressure);
                txt4.setText(weatherInfo.main.humidity+"%");
                txt5.setText(weatherInfo.wind.speed+" km/s");



            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                t.printStackTrace();
            }
        });



    }





}