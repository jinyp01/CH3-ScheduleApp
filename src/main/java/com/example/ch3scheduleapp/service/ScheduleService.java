package com.example.ch3scheduleapp.service;


import com.example.ch3scheduleapp.dto.CreateScheduleRequest;
import com.example.ch3scheduleapp.dto.CreateScheduleResponse;
import com.example.ch3scheduleapp.entity.Schedule;
import com.example.ch3scheduleapp.repoository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                saveSchedule.getUsername()
        );
    }




}
