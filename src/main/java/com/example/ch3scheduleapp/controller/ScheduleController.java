package com.example.ch3scheduleapp.controller;

import com.example.ch3scheduleapp.dto.*;
import com.example.ch3scheduleapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    // 유저 이름으로 검색 메서드 이름 변경 및 상태코드 반환
    @GetMapping("/schedules/users/{username}")
    ResponseEntity<List<GetOneScheduleResponse>> getUserSchedules(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAll(username));
    }


    // 스케쥴 id로 일정 단건 조회
    @GetMapping("/schedules/{id}")
    ResponseEntity<GetOneScheduleResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOne(id));
    }

    // 일정 수정 진행
    @PutMapping("/schedules/{id}")
    ResponseEntity<UpdateScheduleResponse> update(
            @PathVariable Long id,
            UpdateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(id, request));
    }



    // 삭제 컨트롤러 추가
    @DeleteMapping("/schedules/{id}")
    public ResponseEntity delete(
            @PathVariable long id,
            @RequestBody DeleteRequest request
    ) {

        scheduleService.delete(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
