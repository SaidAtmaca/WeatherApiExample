package com.said.weatherapiexample.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WindInfo {

    @SerializedName("speed")
    @Expose
    public String speed;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
