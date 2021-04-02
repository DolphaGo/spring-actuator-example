package com.example.monitoring.filter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Slf4j
@WebFilter(value = "/actuator/**")
@Component
public class MyFilter extends OncePerRequestFilter {
    // 실제 필터링 로직은 doFilterInternal 에 들어감
    // Security Filter로 들어가기 전에 request check용
    // 테스트 결과 : Spring Security Filter 이후에 거치는 필터
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("/{} {}", request.getMethod(), request.getRequestURL());
        filterChain.doFilter(request, response);
    }
}