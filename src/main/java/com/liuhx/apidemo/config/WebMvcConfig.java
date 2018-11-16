package com.liuhx.apidemo.config;

import com.liuhx.apidemo.config.filter.DurationFilter;
import com.liuhx.apidemo.config.unified.response.UnifiedRequestResponseBodyMethodProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Web基础配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Resource
    RequestMappingHandlerAdapter adapter;

    /**
     * 统一所有rest api接口的返回值结构
     */
    @PostConstruct
    public void init() {
        // 统一返回值结构
        List<HandlerMethodReturnValueHandler> handlers = adapter.getReturnValueHandlers();
        if (handlers != null) {
            List<HandlerMethodReturnValueHandler> newHandlers = handlers.stream().map(handler -> {
                if (handler instanceof RequestResponseBodyMethodProcessor) {
                    return new UnifiedRequestResponseBodyMethodProcessor(adapter.getMessageConverters());
                } else {
                    return handler;
                }
            }).collect(Collectors.toList());
            // 替换returnValueHandlers
            adapter.setReturnValueHandlers(newHandlers);
        }
    }


    /**
     * 日志记录过滤器
     *
     * @return 日志记录过滤器
     */
    @Bean
    public CommonsRequestLoggingFilter commonsRequestLoggingFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludeHeaders(true);
        filter.setIncludePayload(true);
        filter.setIncludeClientInfo(true);
        filter.setMaxPayloadLength(1024);
        return filter;
    }

    /**
     * 请求计时过滤器
     *
     * @return 请求计时过滤器
     */
    @Bean
    public DurationFilter durationFilter() {
        return new DurationFilter();
    }

    /**
     * 添加拦截器
     *
     * @param registry 　拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

}
