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

    // 유저 이름으로 일정 모두 검색
    @GetMapping("/schedules/{username}")
    public List<GetOneScheduleResponse> getAllSchedules(@PathVariable String username) {
        return scheduleService.getAll(username);
    }

    // id로 일정검색
    @GetMapping("/schedules/{id}")
    public GetOneScheduleResponse getOne(@PathVariable Long id) {
        return scheduleService.getOne(id);
    }


}
