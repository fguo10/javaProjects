package com.example.university_demo.service;

import com.example.university_demo.entity.UserInfo;

import java.util.List;

public interface UniversityService {
    List<UserInfo> searchUserByName(String name);
    List<UserInfo> searchUserByCountryName(String countryName);
}
