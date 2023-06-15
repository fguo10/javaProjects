package com.example.university_demo.service;

import com.example.university_demo.entity.University;

import java.util.List;

public interface UniversityService {
    List<University> searchUserByName(String name);
    List<University> searchUserByCountryName(String countryName);
}
