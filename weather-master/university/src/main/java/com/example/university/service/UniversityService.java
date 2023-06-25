package com.example.university.service;

import com.example.university.entity.University;

import java.util.List;

public interface UniversityService {
    List<University> searchUserByName(String name);
    List<University> searchUserByCountryName(String countryName);
}
