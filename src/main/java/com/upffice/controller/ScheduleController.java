package com.upffice.controller;

import com.upffice.model.ScheduleDto;
import com.upffice.repo.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    /*
    * UpfficeFront 의 일정관리 기능에 사용되는 Controller
    */

    @Autowired
    ScheduleRepository repository;

    /* UpfficeFront 의 ResiterPopup.vue의 register() 메소드와 매핑됨 : schedule 추가하기*/
    @PostMapping("/add/{emp_id}")
    public ScheduleDto addSchedule(@PathVariable("emp_id") int emp_id, @RequestBody ScheduleDto schedule) {
        ScheduleDto _scheduleDto = repository.save( new ScheduleDto(emp_id, schedule.getCalendar_id(), schedule.getSche_name(),
                schedule.getSche_start_date(),schedule.getSche_start_time(), schedule.getSche_end_date(), schedule.getSche_end_time(),
                schedule.getSche_place(), schedule.getSche_detail()) );

        return _scheduleDto;
    }

    /* UpfficeFront 의 Calendar.vue의 getAllSchedule() 메소드와 매핑됨 : 모든 schedule 리스트를 emp_id 로 가져오기 */
    @PostMapping("/all/{emp_id}")
    public List<ScheduleDto> getAllSchedules(@PathVariable("emp_id") int emp_id, @RequestBody String date) throws ParseException {
        System.out.println("getAllSchedules() 들어오나 보자 : emp_id " +"- "+emp_id + "/ date : " + date);
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
        Date date1 = dt.parse(date);
        List<ScheduleDto> _scheduleDto = repository.getScheduleByEmpId(emp_id, date1);

        for(ScheduleDto d : _scheduleDto) {
            System.out.println("all + " + d);
        }

        return _scheduleDto;
    }

    /* 날짜, 카테고리에 해당되는 일정만....? */
    @PostMapping("/list/{emp_id}")
    public List<ScheduleDto> getSchedule(@PathVariable("emp_id") int emp_id, @RequestBody int[] schedules, @RequestBody String date) {
        System.out.println(schedules + "schedules");
        List<ScheduleDto> schedule = new ArrayList<>();

        // schedule 배열 안에 포함된 sche_id 에 해당 되고
        for(int i=0; i<schedules.length; i++) {
            // start_date 와 end_date 사이에 date 가 포함된 일정 불러오기
            List<ScheduleDto> schedule2 = new ArrayList<>();
            schedule2 = repository.getScheduleByScheId(emp_id, schedules[i], date);
            schedule.addAll(schedule2); // list 끼리 합치기
        }

        for(ScheduleDto d : schedule) {
            System.out.println("리스트 + " + d);
        }

        return schedule;
    }

}
