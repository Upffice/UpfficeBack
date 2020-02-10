package com.upffice.repo;

import com.upffice.model.ScheduleDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.lang.String;
import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<ScheduleDto, Integer> {
    /*
     * Schedule 테이블에 해당하는 Repository
     */

    // between 써서 날짜 사이에 ?1 가 끼어있는 일정들 출력 - 전부 출력
    @Query("SELECT DISTINCT s FROM ScheduleDto s WHERE s.emp_id=?1 AND ?2 BETWEEN s.sche_start_date AND s.sche_end_date")
    List<ScheduleDto> getScheduleByEmpId(int emp_id, Date date);

    // between 써서 날짜 사이에 ?1 가 끼어있는 일정들 - calendarId 로 캘린더 목록 구분해 출력
    @Query("SELECT DISTINCT s FROM ScheduleDto s WHERE s.emp_id=?1 AND s.calendar_id=?2 AND ?3 BETWEEN s.sche_start_date and s.sche_end_date")
    List<ScheduleDto> getScheduleByScheId(int emp_id, int calendar_id, Date date);

    /* emp_id와 calendar_id 로 캘린더 이름 수정*/
    @Modifying
    @Transactional
    @Query("UPDATE ScheduleDto SET calendar_id=?1, sche_name=?2, sche_start_date=?3, sche_start_time=?4, " +
            "sche_end_date=?5, sche_end_time=?6, sche_place=?7, sche_detail=?8" +
            " WHERE emp_id=?9 AND sche_id=?10")
    int updateSchedule(int calendar_id, String sche_name, Date sche_start_date, String sche_start_time,
                       Date sche_end_date,String sche_end_time, String sche_place, String sche_detail, int emp_id, int sche_id);

    // schedule delete 하는 메소드
    @Modifying
    @Transactional
    @Query("DELETE FROM ScheduleDto s WHERE s.emp_id=?1 AND s.sche_id=?2")
    int deleteSchedule(int emp_id, int calendar_id);

    // 일정 이름으로 검색
    @Query("SELECT s FROM ScheduleDto s WHERE s.emp_id=?1 AND s.sche_name like ?2")
    List<ScheduleDto> searchScheduleByScheName(int emp_id, String sche_name);
}
