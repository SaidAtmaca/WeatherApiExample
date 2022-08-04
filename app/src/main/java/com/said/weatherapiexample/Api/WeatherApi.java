package com.said.weatherapiexample.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {

    @GET("data/2.5/weather?q=Antalya,turkey&appid=9d63dc3d5d1a21ac26b585bd0b47dc69")
    Call<WeatherInfo> getData();

}
