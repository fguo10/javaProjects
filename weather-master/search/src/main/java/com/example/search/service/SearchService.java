package com.example.search.service;


import com.example.search.entity.DetailResponse;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface SearchService {
    DetailResponse getDetails(String key, String value) throws ExecutionException, InterruptedException;
}
