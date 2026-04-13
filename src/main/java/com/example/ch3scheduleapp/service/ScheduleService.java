package com.example.ch3scheduleapp.service;


import com.example.ch3scheduleapp.dto.CreateScheduleRequest;
import com.example.ch3scheduleapp.dto.CreateScheduleResponse;
import com.example.ch3scheduleapp.dto.GetOneScheduleResponse;
import com.example.ch3scheduleapp.entity.Schedule;
import com.example.ch3scheduleapp.repoository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request){
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getUsername(),
                request.getPassword()
        );
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return  new CreateScheduleResponse(
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getUsername(),
                saveSchedule.getCreated_at(),
                saveSchedule.getUpdated_at()
        );
    }

    // 작성자명을 기준으로 검색된 일정 모두 반환
    public List<GetOneScheduleResponse> getAll(String username) {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<GetOneScheduleResponse> dtos = new ArrayList<>();
        for(Schedule schedule : schedules){
            if(schedule.getUsername().equals(username)){
                GetOneScheduleResponse dto =  new GetOneScheduleResponse(
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getUsername(),
                        schedule.getCreated_at(),
                        schedule.getUpdated_at()
                );
                dtos.add(dto);
            }
        }
        return dtos;
    }








}
