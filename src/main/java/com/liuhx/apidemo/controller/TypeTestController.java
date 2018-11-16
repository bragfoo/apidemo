package com.liuhx.apidemo.controller;

import com.liuhx.apidemo.model.po.User;
import com.liuhx.apidemo.model.vo.UserDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TypeTestController {

    @GetMapping("int")
    public int anInt() {
        return 100;
    }

    @GetMapping("double")
    public double aDouble() {
        return 23.12d;
    }

    @GetMapping("map")
    public Map<String, Object> aMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "测试");
        map.put("age", 18);
        map.put("adress", "北京");
        map.put("price", 123.24d);
        return map;
    }

    @GetMapping("entity")
    public ResponseEntity<UserDetailVo> anEntity() {
        // 模拟从数据库中查出的数据
        User user = User.builder()
                .name("测试名称")
                .age(18)
                .userNo("1234567890")
                .secretKey("UJMNHYGHJK")
                .email("abc@163.com")
                .mobile("15555555555")
                .build();
        UserDetailVo vo = new UserDetailVo();
        // 转换成vo对象，同时屏蔽敏感信息
        BeanUtils.copyProperties(user, vo);

        // 返回responseEntity定制返回信息，包括返回码、Header、ContentType等
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("r-key", "rtyfghvbntgbygvngr")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(vo);
    }
}
