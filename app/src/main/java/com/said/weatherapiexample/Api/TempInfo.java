package com.said.weatherapiexample.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TempInfo {

    @SerializedName("temp")
    @Expose
    public float temp;

    @SerializedName("pressure")
    @Expose
    public String pressure;

    @SerializedName("humidity")
    @Expose
    public String humidity;


    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
