package com.example.springsecuritydemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/*
    1. Command + O: 打开类浏览器，可以通过类名进行搜索和导航。
        - SecurityFilterChain



 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class Security {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }
}
