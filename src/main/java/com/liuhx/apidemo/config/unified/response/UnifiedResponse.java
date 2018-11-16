package com.liuhx.apidemo.config.unified.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

/**
 * 接口统一返回结构体
 *
 * @author shiyongbiao
 */
@Builder
@Data
public class UnifiedResponse {

    @JsonProperty("msg_code")
    private int msgCode;
    private String message;
    private Object attachment;

    public String toJsonString() {
        return
                String.format(
                        "{\"msg_code\":%d,\"message\":\"%s\",\"attachment\":\"%s\"}",
                        msgCode, message, Objects.toString(attachment, "")
                );
    }

}
