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
//@WebFilter(urlPatterns = "/actuator") // TODO: 이거 안먹네.. 이런 urlPattern이 아니어도 다 거쳐가는걸..
public class MyFilter extends OncePerRequestFilter {
    // Security Filter로 들어가기 전에 request check용
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("/{} {}", request.getMethod(), request.getRequestURL());
        filterChain.doFilter(request, response);
    }
}