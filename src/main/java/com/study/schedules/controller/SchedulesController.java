package com.study.schedules.controller;

import com.study.schedules.dto.SchedulesRequestDto;
import com.study.schedules.dto.SchedulesResponseDto;
import com.study.schedules.dto.SchedulesUpdateDto;
import com.study.schedules.service.SchedulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SchedulesController {

    private final SchedulesService schedulesService;

    //Update
    @PutMapping("/schedules/{id}")
    public SchedulesResponseDto createSchedules(@PathVariable Long id, @RequestBody SchedulesUpdateDto updateDto){
        if(!Object.equals(id, updateDto.getId())){
            throw new IllegalArgumentException("ID가 불일치합니다.");
        }
        schedulesService.updateSchedules(id, updateDto);
        return null;;
    }

    //Delete
    @DeleteMapping("/schedules{id}")
    public String deleteSchedules(@PathVariable Long id){
        schedulesService.delete(id);
        return "삭제 완료";
    }


}
