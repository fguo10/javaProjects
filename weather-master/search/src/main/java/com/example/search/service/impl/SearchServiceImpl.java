package com.example.search.service.impl;

import com.example.search.entity.DetailResponse;
import com.example.search.entity.Student;
import com.example.search.entity.University;
import com.example.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    @Value("${university.url}")
    private String univsersity_baseurl;

    @Value("${student.url}")
    private String student_baseurl;

    private final RestTemplate restTemplate;

    public SearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public DetailResponse getDetails(String key, String value) throws ExecutionException, InterruptedException {
        String university_url = univsersity_baseurl + "/search?" + key + "=" + value;

        CompletableFuture<University[]> future1 = CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject(university_url, University[].class);
        });

        CompletableFuture<Student[]> future2 = CompletableFuture.supplyAsync(() -> {
            return restTemplate.getForObject(student_baseurl, Student[].class);
        });

        CompletableFuture<DetailResponse> combinedFuture = future1.thenCombine(future2, (universities, students) -> {
            // Process and combine the results
            DetailResponse detailResponse = new DetailResponse();
            detailResponse.setStudents(students);
            detailResponse.setUniversities(universities);
            return detailResponse;
        });

        return combinedFuture.get();


//        University[] universities = restTemplate.getForObject(university_url, University[].class);
//        Student[] students = restTemplate.getForObject(student_baseurl, Student[].class);
//        DetailResponse detailResponse = new DetailResponse();
//        detailResponse.setStudents(students);
//        detailResponse.setUniversities(universities);
//        return detailResponse;
    }
}
