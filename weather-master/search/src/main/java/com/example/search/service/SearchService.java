package com.example.search.service;


import com.example.search.entity.DetailResponse;

import java.util.List;

public interface SearchService {
    DetailResponse getDetails(String key, String value);
}
