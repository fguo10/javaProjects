package com.example.search.controller;

import com.example.search.entity.DetailResponse;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private final SearchService service;

    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/weather/search")
    public ResponseEntity<?> getDetails(@RequestParam String key, @RequestParam String value) {
        //TODO
        DetailResponse response = service.getDetails(key, value);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
