package com.example.search.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class DetailResponse {
    @JsonProperty("students")
    Student[] students;
    @JsonProperty("universities")
    University[] universities;
}
