package com.example.ch3scheduleapp.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {
    private final String title;
    private final String content;
    private final String username;
    private final LocalDateTime created_at;
    private final LocalDateTime updated_at;

    public CreateScheduleResponse(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }
}
