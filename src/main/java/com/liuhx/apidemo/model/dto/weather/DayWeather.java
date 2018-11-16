package com.liuhx.apidemo.model.dto.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DayWeather {
    /**
     * day : 2日（今天）
     * date : 2018-11-02
     * week : 星期五
     * wea : 多云转阴
     * air : 27
     * air_level : 优
     * air_tips : 空气很好，可以外出活动，呼吸新鲜空气，拥抱大自然！
     * alarm : []
     * tem1 : 20℃
     * tem2 : 16℃
     * win : ["西南风","西风"]
     * win_speed : <3级
     * hours : [{"day":"02日08时","wea":"多云","tem":"16℃","win":"西南风","win_speed":"<3级"},{"day":"02日11时","wea":"多云","tem":"19℃","win":"西南风","win_speed":"<3级"},{"day":"02日14时","wea":"多云","tem":"19℃","win":"西南风","win_speed":"<3级"},{"day":"02日17时","wea":"多云","tem":"18℃","win":"西南风","win_speed":"<3级"},{"day":"02日20时","wea":"多云","tem":"17℃","win":"西南风","win_speed":"<3级"},{"day":"02日23时","wea":"阴","tem":"16℃","win":"西风","win_speed":"<3级"},{"day":"03日02时","wea":"阴","tem":"16℃","win":"西风","win_speed":"<3级"},{"day":"03日05时","wea":"阴","tem":"16℃","win":"西风","win_speed":"<3级"}]
     * index : [{"title":"紫外线指数","level":"最弱","desc":"辐射弱，涂擦SPF8-12防晒护肤品。"},{"title":"减肥指数","level":null,"desc":"天气较舒适，减肥正当时。"},{"title":"健臻·血糖指数","level":"较易波动","desc":"血糖较易波动，注意监测。"},{"title":"穿衣指数","level":"较舒适","desc":"建议穿薄外套或牛仔裤等服装。"},{"title":"洗车指数","level":"较适宜","desc":"无雨且风力较小，易保持清洁度。"},{"title":"空气污染扩散指数","level":"中","desc":"易感人群应适当减少室外活动。"}]
     */

    private String day;
    private LocalDate date;
    private String week;
    private String wea;
    private int air;
    @JsonProperty("air_level")
    private String airLevel;
    private String air_tips;
    private String tem1;
    private String tem2;
    @JsonProperty("win_speed")
    private String winSpeed;
    private List<String> alarm;
    private List<String> win;
    private List<HourWeather> hours;

}
