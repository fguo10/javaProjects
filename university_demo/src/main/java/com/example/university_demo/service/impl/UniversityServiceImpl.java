package com.example.university_demo.service.impl;

import com.example.university_demo.entity.University;
import com.example.university_demo.service.UniversityService;
import lombok.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.lang.String;

@Slf4j
@Service
public class UniversityServiceImpl implements UniversityService {

    @Value("${university.url}")
    private String baseurl;
    private final RestTemplate restTemplate;

    public UniversityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<University> searchUserByName(String name) {
        String url = baseurl + "/search?name=" + name;
        log.info("searchUserByName: " + url);
        University[] Universitys = restTemplate.getForObject(url, University[].class);

        assert Universitys != null;
        log.info("url resp: " + Universitys.toString());
        return Arrays.asList(Universitys);
    }

    @Override
    public List<University> searchUserByCountryName(String countryName) {
        String url = baseurl + "/search?country=" + countryName;
        log.info("searchUserByCountryName: " + url);
        University[] Universitys = restTemplate.getForObject(url, University[].class);
        log.info("url resp: " + Universitys.toString());
        return Arrays.asList(Universitys);
    }
}
