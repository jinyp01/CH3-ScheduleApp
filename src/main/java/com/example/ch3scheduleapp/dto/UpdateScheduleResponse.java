package com.example.ch3scheduleapp.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String username;
    private final LocalDateTime updated_At;

    public UpdateScheduleResponse(Long id, String title, String content, String username, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.updated_At = updatedAt;
    }
}
