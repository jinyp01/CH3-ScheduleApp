package com.example.ch3scheduleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ch3ScheduleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch3ScheduleAppApplication.class, args);
    }

}
