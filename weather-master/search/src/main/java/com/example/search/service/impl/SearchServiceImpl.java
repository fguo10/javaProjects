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
    public DetailResponse getDetails(String key, String value) {
        String university_url = univsersity_baseurl + "/search?" + key + "=" + value;
        University[] universities = restTemplate.getForObject(university_url, University[].class);
        Student[] students = restTemplate.getForObject(student_baseurl, Student[].class);
        DetailResponse detailResponse = new DetailResponse();
        detailResponse.setStudents(students);
        detailResponse.setUniversities(universities);
        return detailResponse;
    }
}
