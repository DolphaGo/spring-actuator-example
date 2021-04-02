package com.example.monitoring.filter;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// MyFilter를 SecurityConfig에 적용하기 위함(SecurityFilter 전에 MyFilter를 먼저 거치게 하기 위함)
public class MyFilterSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Override
    public void configure(HttpSecurity http) {
        MyFilter myFilter = new MyFilter();
        http.addFilterBefore(myFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
/** My 필터의 효과 : Spring Security에 user 등록여부, 비밀번호 일치여부, 권한 여부(Role) 검사 전에 요청을 미리 체크함
 *
 * POST /actuator/shutdown
 *
 * 시큐리티에 없는 사람 정보로 요청할 때
 * {
 *     "timestamp": "2021-04-02T18:52:11.415+00:00",
 *     "status": 401,
 *     "error": "Unauthorized",
 *     "message": "",
 *     "path": "/actuator/shutdown"
 * }
 *
 * 시큐리티에 등록되어 있지만 유저정보가 맞지 않을 때
 *
 * {
 *     "timestamp": "2021-04-02T18:52:34.591+00:00",
 *     "status": 401,
 *     "error": "Unauthorized",
 *     "message": "",
 *     "path": "/actuator/shutdown"
 * }
 *
 *
 * 시큐리티에 등록되어 있지만, 권한 문제가 있을 때(ROLE이 ACTUATOR_ADMIN이 아닐 때)
 *  {
 *      "timestamp": "2021-04-02T18:51:23.537+00:00",
 *      "status": 403,
 *      "error": "Forbidden",
 *      "message": "",
 *      "path": "/actuator/shutdown"
 *  }
 *
 *
 * 시큐리티에도 등록되어 있고, 권한이 올바를 때 => 서버 종료
 *{
 *     "message": "Shutting down, bye..."
 * }
 */
