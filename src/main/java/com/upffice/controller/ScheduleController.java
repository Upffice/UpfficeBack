package com.upffice.controller;

import com.upffice.model.ScheduleDto;
import com.upffice.repo.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
    @GetMapping("/all/{emp_id}")
    public List<ScheduleDto> getAllSchedules(@PathVariable("emp_id") int emp_id, @RequestParam("sche_date") String date) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dt.parse(date);
        List<ScheduleDto> _scheduleDto = repository.getScheduleByEmpId(emp_id, date1);

        return _scheduleDto;
    }

    /* UpfficeFront 의 Calendar.vue의 getSchedule() 메소드와 매핑됨 : 특정 calendar_id, emp_id에 대한 schedule 리스트를 가져오기 */
    @GetMapping("/list/{emp_id}")
    public List<ScheduleDto> getSchedules(@PathVariable("emp_id") int emp_id, @RequestParam("calendar_id") int calendar_id, @RequestParam("sche_date") String date) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dt.parse(date);
        List<ScheduleDto> _scheduleDto = repository.getScheduleByScheId(emp_id, calendar_id, date1);

        return _scheduleDto;
    }

    /* UpfficeFront 의 ScheduleDetailModal.vue 에서 수정 버튼 눌렀을 때 매핑 됨 : 캘린더 이름 수정 */
    @PutMapping("/update/{emp_id}")
    public int updateCalendarName(@PathVariable("emp_id") int emp_id, @RequestBody ScheduleDto schedule) {
        System.out.println("sche + "+ schedule);
        int chk = 0;
        int sche_id = schedule.getSche_id();

        // 수정 된 행의 갯수를 받아온다. chk이 1이면 1개의 row가 수정 되었다는 뜻. : 확인 할 때 사용하면 된다
        chk = repository.updateSchedule(schedule.getCalendar_id(), schedule.getSche_name(), schedule.getSche_start_date(),
                                            schedule.getSche_start_time(), schedule.getSche_end_date(),
                                            schedule.getSche_end_time(), schedule.getSche_place(), schedule.getSche_detail(), emp_id, sche_id);

        return chk;
    }

    /* ScheduleDetailModal.vue 에서 스케줄 삭제 할 때 사용함. */
    @DeleteMapping("/list/{emp_id}")
    public int deleteSchedule(@PathVariable("emp_id") int emp_id, @RequestParam("schedule_id") int schedule_id) {
        int del_count = 0;  // delete 한 row 개수 return 하기 위한 변수

        // 수정 된 행의 갯수를 받아온다. chk이 1이면 1개의 row가 수정 되었다는 뜻. : 확인 할 때 사용하면 된다
        del_count = repository.deleteSchedule(emp_id, schedule_id);

        return del_count;
    }

    /* Calendar.vue 에서 스케줄 검색 할 때 사용함. */
    @GetMapping("/search/{emp_id}")
    public List<ScheduleDto> searchSchedule(@PathVariable("emp_id") int emp_id, @RequestParam("keyword") String keyword) {
        List<ScheduleDto> schedules = repository.searchScheduleByScheName(emp_id, "%" + keyword + "%");

        return schedules;
    }
}
