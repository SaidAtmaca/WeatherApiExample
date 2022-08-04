package com.said.weatherapiexample.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TempInfo {

    @SerializedName("temp")
    @Expose
    public float temp;

    @SerializedName("pressure")
    @Expose
    public int pressure;

    @SerializedName("humidity")
    @Expose
    public int humidity;


    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
