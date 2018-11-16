package com.liuhx.apidemo.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 自增ID
     */
    private long id;
    /**
     * 用户唯一编号
     */
    private String userNo;
    private String name;
    /**
     * 用户密钥，一般情况不做展示
     */
    private String secretKey;
    private String mobile;
    private Integer age;
    private String address;
    private String email;
    private Date createTime;
    private Date lastUpdateTime;
}
