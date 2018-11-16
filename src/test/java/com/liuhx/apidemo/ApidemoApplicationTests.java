package com.liuhx.apidemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuhx.apidemo.model.dto.weather.CityWeather;
import com.liuhx.apidemo.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.NestedServletException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ApidemoApplicationTests {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WeatherService weatherService;

    @BeforeAll
    public static void beforeAll() {
        log.info("开始测试");
    }

    @org.junit.jupiter.api.Test
    public void contextLoads() {
        assertThat("abc").isEqualTo("abc");
    }

    @org.junit.jupiter.api.Test
    public void helloTest() throws Exception {
        String result = mvc.perform(get("/hello"))
                .andExpect(handler().methodName("hello"))
                .andExpect(status().isOk())
                // jsonPath用法参考 https://github.com/json-path/JsonPath#operators
                .andExpect(content().string("hello"))
                .andReturn().getResponse().getContentAsString();
        log.info("hello result: {}", result);
    }

    @org.junit.jupiter.api.Test
    public void exText() throws Exception {
        try {
            mvc.perform(get("/ex"))
                    .andExpect(status().isInternalServerError())
            //.andDo(print())
            ;
        } catch (NestedServletException e) {
            // e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    public void pingTest() throws Exception {
        String result = mvc.perform(get("/ping"))
                .andExpect(handler().methodName("ping"))
                .andExpect(status().isOk())
                // jsonPath用法参考 https://github.com/json-path/JsonPath#operators
                .andExpect(jsonPath("$.attachment", is("PONG")))
                .andExpect(jsonPath("$.msg_code", is(200)))
                .andReturn().getResponse().getContentAsString();
        log.info("ping result: {}", result);
    }

    @org.junit.jupiter.api.Test
    public void userAddTest() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", "测试名称");
        map.add("age", "12");
        map.add("address", "北京");

        String result = mvc.perform(post("/users/save").params(map))
                .andExpect(status().is4xxClientError())
                .andReturn().getResponse().getContentAsString();
        log.info("ping result: {}", result);
    }

    @Test
    public void weatherServiceTest() {
        CityWeather r = weatherService.get("上海");
        assertThat(r.getCity()).isEqualTo("上海");
    }

    @AfterAll
    public static void afterAll() {
        log.info("结束测试");
    }

}
