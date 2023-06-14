package com.example.university_demo.controller;

import com.example.university_demo.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("university")
@AllArgsConstructor
public class UniversityController {


    private UniversityService universityService;
    @RequestMapping(value = "/search", params = "country")
    public ResponseEntity<?> searchUserByCountryName(@RequestParam String country) {
        return ResponseEntity.ok(universityService.searchUserByCountryName(country));
    }

    @RequestMapping(value = "/search", params = "name")
    public ResponseEntity<?> searchUserByName(@RequestParam String name) {
        return ResponseEntity.ok(universityService.searchUserByName(name));
    }
}
