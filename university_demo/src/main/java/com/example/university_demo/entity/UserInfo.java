package com.example.university_demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfo {
    @JsonProperty("name")
    private String user_name;
    private Address address;
}
