package com.said.weatherapiexample.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi { //In here, We request the weather infos on based city

    @GET("data/2.5/weather?q=Istanbul,turkey&appid=API KEY")
    Call<WeatherInfo> getData();

}
