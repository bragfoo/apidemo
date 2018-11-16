package com.liuhx.apidemo.model.dto.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HourWeather {

    /**
     * day : 02日08时
     * wea : 多云
     * tem : 16℃
     * win : 西南风
     * win_speed : <3级
     */

    private String day;
    private String wea;
    private String tem;
    private String win;
    @JsonProperty("win_speed")
    private String winSpeed;

}
