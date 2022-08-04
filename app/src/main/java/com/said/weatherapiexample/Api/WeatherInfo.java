package com.said.weatherapiexample.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherInfo {


    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("main")
    @Expose
    public TempInfo main;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TempInfo getMain() {
        return main;
    }

    public void setMain(TempInfo main) {
        this.main = main;
    }
}
