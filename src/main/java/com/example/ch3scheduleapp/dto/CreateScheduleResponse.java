package com.example.ch3scheduleapp.dto;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {
    private final String title;
    private final String content;
    private final String username;
    private final LocalDateTime created_at;
    private final LocalDateTime updated_at;

    public CreateScheduleResponse(String title, String content, String username, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
    }
}
