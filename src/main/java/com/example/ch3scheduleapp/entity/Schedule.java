package com.example.ch3scheduleapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name="Schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String title;
    private String content;
    private String username;
    private String password;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    public Schedule(String title, String content, String username, String password){
        this.title = title;
        this.content = content;
        this.username = username;
        this.password = password;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public void updateSchedule(String title, String username){
        this.title = title;
        this.username = username;
        this.updated_at = LocalDateTime.now();
    }




}
