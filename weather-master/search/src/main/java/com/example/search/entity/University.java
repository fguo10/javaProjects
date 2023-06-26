package com.example.search.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class University {
    @JsonProperty("country")
    private String country;

    @JsonProperty("alpha_two_code")
    private String alpha_two_code;

    @JsonProperty("name")
    private String name;
}
