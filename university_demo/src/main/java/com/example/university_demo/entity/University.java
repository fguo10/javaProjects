package com.example.university_demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.lang.String;


@Data
public class University {
    @JsonProperty("country")
    private String country;

    @JsonProperty("alpha_two_code")
    private String alpha_two_code;

    @JsonProperty("name")
    private String name;
}
