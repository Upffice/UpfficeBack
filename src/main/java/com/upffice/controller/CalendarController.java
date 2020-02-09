package com.upffice.controller;

import com.upffice.model.CalendarDto;
import com.upffice.repo.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    @GetMapping("/list/{emp_id}")
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

    /* ScheduleSubMenu.vue 에서 Calendar_id 로 캘린더 목록 삭제 할 때 사용함. */
    @DeleteMapping("/list/{emp_id}")
    public int deleteSchedule(@PathVariable("emp_id") int emp_id, @RequestParam("calendar_id") String calendars) {
        int del_count = 0;  // delete 한 row 개수 return 하기 위한 변수

        String[] calendars_id = calendars.split(",");   // 콤마 기준으로 String 나누기
        int[] cal_ids = Arrays.stream(calendars_id).mapToInt(Integer::parseInt).toArray();  //  String 배열을 int 배열로 변환

        // schedule 배열 안에 포함된 sche_id 에 해당 되고
        for(int i=0; i<cal_ids.length; i++) {
            del_count += repository.deleteCalendar(emp_id, cal_ids[i]);
        }

        return del_count;
    }

    /* UpfficeFront 의 ScheduleSubMenu.vue 에서 캘린더 수정 버튼 눌렀을 때 매핑 됨 : 캘린더 이름 수정 */
    @PutMapping("/update/{emp_id}")
    public int updateCalendarName(@PathVariable("emp_id") int emp_id, @RequestBody String[] calendars) {
        int chk = 0;

        for(int i=0; i<calendars.length; i++) {
            String[] calendarInfo = new String[2];
            System.out.println(calendars[i]);
            calendarInfo = calendars[i].split(",");

            // 수정 된 행의 갯수를 받아온다. chk이 1이면 1개의 row가 수정 되었다는 뜻.
            chk += repository.updateCalendar( calendarInfo[1], emp_id, Integer.parseInt(calendarInfo[0]) );
        }

        return chk;
    }

}
