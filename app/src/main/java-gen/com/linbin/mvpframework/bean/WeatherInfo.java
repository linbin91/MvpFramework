package com.linbin.mvpframework.bean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "WEATHER_INFO".
 */
public class WeatherInfo {

    private Long id;
    /** Not-null value. */
    private String weather;
    /** Not-null value. */
    private String temp;

    public WeatherInfo() {
    }

    public WeatherInfo(Long id) {
        this.id = id;
    }

    public WeatherInfo(Long id, String weather, String temp) {
        this.id = id;
        this.weather = weather;
        this.temp = temp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getWeather() {
        return weather;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /** Not-null value. */
    public String getTemp() {
        return temp;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTemp(String temp) {
        this.temp = temp;
    }

}
