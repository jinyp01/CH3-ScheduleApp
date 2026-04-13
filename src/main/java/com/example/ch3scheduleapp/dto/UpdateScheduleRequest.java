package com.example.ch3scheduleapp.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {

    private Long id;
    private String title;
    private String username;
    private String password;

}
