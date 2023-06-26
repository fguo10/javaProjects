package com.example.search.controller;

import com.example.search.entity.DetailResponse;
import com.example.search.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Tag(name = "Search REST APIs", description = "Search REST APIs")
@RestController
public class SearchController {

    private final SearchService service;

    public SearchController(SearchService service) {
        this.service = service;
    }

    @Operation(summary = "get details REST API", description = "get details data from student service and university service")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping("/weather/search")
    public ResponseEntity<?> getDetails(@RequestParam String key, @RequestParam String value) throws ExecutionException, InterruptedException {
        DetailResponse response = service.getDetails(key, value);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
