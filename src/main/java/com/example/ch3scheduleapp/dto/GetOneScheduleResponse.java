package com.example.ch3scheduleapp.dto;

import java.time.LocalDateTime;

public class GetOneScheduleResponse {

    private final String title;
    private final String content;
    private final String username;
    private final LocalDateTime created_at;
    private final LocalDateTime updated_at;


    public GetOneScheduleResponse(String title, String content, String username, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
    }
}
