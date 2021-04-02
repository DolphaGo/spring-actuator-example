package com.example.monitoring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {
    @GetMapping("/")
    public ResponseEntity hello(){
        return ResponseEntity.ok("hello");
    }
}
