package com.example.university.controller;

import com.example.university.service.UniversityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("university")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @RequestMapping(value = "/search", params = "country")
    public ResponseEntity<?> searchUserByCountryName(@RequestParam String country) {
        System.out.println("start search country: " + country);
        return ResponseEntity.ok(universityService.searchUserByCountryName(country));
    }

    @RequestMapping(value = "/search", params = "name")
    public ResponseEntity<?> searchUserByName(@RequestParam String name) {
        return ResponseEntity.ok(universityService.searchUserByName(name));
    }
}
