package com.example.ch3scheduleapp.controller;

import com.example.ch3scheduleapp.dto.CreateScheduleRequest;
import com.example.ch3scheduleapp.dto.CreateScheduleResponse;
import com.example.ch3scheduleapp.dto.GetOneScheduleResponse;
import com.example.ch3scheduleapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request){
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedules/{username}")
    public List<GetOneScheduleResponse> getAllSchedules(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.FOUND).body(scheduleService.getAll(username)).getBody();
    }


}
