package com.liuhx.apidemo.config.unified.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.util.List;

/**
 * 把ResponseBody的返回值转化成统一返回类型
 *
 * @author shiyongbiao
 * @see UnifiedResponse 统一返回类型
 */
public class UnifiedRequestResponseBodyMethodProcessor extends RequestResponseBodyMethodProcessor {

    public UnifiedRequestResponseBodyMethodProcessor(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException, HttpMessageNotWritableException {
        if (returnValue instanceof UnifiedResponse) { // 如果是统一返回类型，不做处理
            handleReturnValue(returnValue, returnType, mavContainer, webRequest);
        } else {
            // 如果不是统一返回类型，转成统一返回类型
            super.handleReturnValue(
                    UnifiedResponse
                            .builder()
                            .msgCode(HttpStatus.OK.value())
                            .message("success")
                            .attachment(returnValue)
                            .build(),
                    returnType,
                    mavContainer,
                    webRequest);
        }
    }
}
