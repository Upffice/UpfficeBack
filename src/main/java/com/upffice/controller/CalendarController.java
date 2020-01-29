package com.upffice.controller;

import com.upffice.model.CalendarDto;
import com.upffice.repo.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/calendar")
public class CalendarController {
    /*
    * UpfficeFront 의 일정관리 기능에 사용되는 Controller
    */

    @Autowired
    CalendarRepository repository;

    /* UpfficeFront 의 ScheduleSubMenu.vue의 getCalendarList() 메소드와 매핑됨 : 모든 calendar 리스트를 emp_id 로 가져오기 */
    @PostMapping("/list/{emp_id}")
    public List<CalendarDto> getCalendar(@PathVariable("emp_id") int emp_id) {
        List<CalendarDto> _calendarDto = repository.getCalendarByEmpId(emp_id);

        return _calendarDto;
    }

    /* UpfficeFront 의 ScheduleSubMenu.vue의 addCalender() 메소드와 매핑됨 : calendar 추가하기*/
    @PostMapping("/add/{emp_id}")
    public CalendarDto addCalendar(@PathVariable("emp_id") int emp_id, @RequestBody CalendarDto calendar) {
        CalendarDto _calendarDto = repository.save(new CalendarDto(emp_id, calendar.getCalendar_name(), calendar.getCalendar_color()));

        return _calendarDto;
    }

}
