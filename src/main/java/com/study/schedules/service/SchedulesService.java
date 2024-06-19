package com.study.schedules.service;

import com.study.schedules.dto.SchedulesUpdateDto;
import com.study.schedules.entity.Schedules;
import com.study.schedules.repository.SchedulesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulesService {

    private final SchedulesRepository schedulesRepository;

    public void updateSchedules(Long id, SchedulesUpdateDto updateDto) {
        Schedules schedules=schedulesRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("선택한 일정이 없습니다."));

        schedules.update(updateDto.getComment());
        schedulesRepository.save(schedules);
    }

    public void delete(Long id){
        schedulesRepository.deleteById(id);
    }
}
