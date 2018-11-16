package com.liuhx.apidemo.config.filter;

import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 请求计时过滤器
 *
 * @author shiyongbiao
 */
public class DurationFilter extends OncePerRequestFilter {

    private static final String REQ_START_MS_KEY = "_req_start_ms";
    private static final String REQ_DURATION_MS_KEY = "duration";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        MDC.remove(REQ_DURATION_MS_KEY);
        request.setAttribute(REQ_START_MS_KEY, System.currentTimeMillis());
        Object start = request.getAttribute(REQ_START_MS_KEY);
        try {
            filterChain.doFilter(request, response);
            if (start != null) {
                long duration = System.currentTimeMillis() - Long.valueOf(Objects.toString(start));
                MDC.put(REQ_DURATION_MS_KEY, String.valueOf(duration));
            }
        } finally {
            request.removeAttribute(REQ_START_MS_KEY);
        }
    }
}
