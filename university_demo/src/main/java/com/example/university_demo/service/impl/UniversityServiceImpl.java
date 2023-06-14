package com.example.university_demo.service.impl;

import com.example.university_demo.entity.UserInfo;
import com.example.university_demo.service.UniversityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final RestTemplate restTemplate;
    @Override
    public List<UserInfo> searchUserByName(String name) {
        String url = "http://universities.hipolabs.com/search?name=" + name;
        log.info("searchUserByName: " + url);
        UserInfo[] userInfos = restTemplate.getForObject(url, UserInfo[].class);

        log.info("url resp: " + userInfos.toString());
        return Arrays.asList(userInfos);
    }

    @Override
    public List<UserInfo> searchUserByCountryName(String countryName) {
        String url = "http://universities.hipolabs.com/search?country=" + countryName;
        log.info("searchUserByCountryName: " + url);
        UserInfo[] userInfos = restTemplate.getForObject(url, UserInfo[].class);
        log.info("url resp: " + userInfos.toString());
        return Arrays.asList(userInfos);
    }
}
