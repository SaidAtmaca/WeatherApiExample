package com.said.weatherapiexample;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // Istanbul https://api.openweathermap.org/data/2.5/weather?q=Istanbul,turkey&appid=9d63dc3d5d1a21ac26b585bd0b47dc69

    // Izmir https://api.openweathermap.org/data/2.5/weather?q=Izmir,turkey&appid=9d63dc3d5d1a21ac26b585bd0b47dc69

    // Denizli https://api.openweathermap.org/data/2.5/weather?q=Denizli,turkey&appid=9d63dc3d5d1a21ac26b585bd0b47dc69

    // Ankara https://api.openweathermap.org/data/2.5/weather?q=Ankara,turkey&appid=9d63dc3d5d1a21ac26b585bd0b47dc69

    // Antalya https://api.openweathermap.org/data/2.5/weather?q=Antalya,turkey&appid=9d63dc3d5d1a21ac26b585bd0b47dc69


    private static final String BASE_URL= "https://api.openweathermap.org/";
    WeatherInfo weatherInfos;
    List<TempInfo> tempInfoList;
    Retrofit retrofit;
    TextView txt1,txt2,txt3,txt4;
    EditText edtx;


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
        txt2=findViewById(R.id.temp);
        txt3=findViewById(R.id.pressure);
        txt4=findViewById(R.id.humidity);
        edtx=findViewById(R.id.editTextNumber);


    }

    public void loadData(){
        WeatherApi weatherApi=retrofit.create(WeatherApi.class);

        Call<WeatherInfo> call=weatherApi.getData();

        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                WeatherInfo weatherInfo=response.body();


               System.out.println(weatherInfo.name);
                System.out.println(weatherInfo.main.temp);
                System.out.println(weatherInfo.main.pressure);
                System.out.println(weatherInfo.main.humidity);

                txt1.setText(weatherInfo.name);
                //txt2.setText(weatherInfo.main.temp);
                txt2.setText(String.valueOf(weatherInfo.main.pressure));
                txt3.setText(String.valueOf(weatherInfo.main.humidity));



            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                t.printStackTrace();
            }
        });



    }





}