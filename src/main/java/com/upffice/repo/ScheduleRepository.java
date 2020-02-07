package com.upffice.repo;

import com.upffice.model.ScheduleDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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
    @Query("SELECT DISTINCT s FROM ScheduleDto s WHERE s.emp_id=?1 AND s.sche_id=?2 AND ?3 BETWEEN s.sche_start_date and s.sche_end_date")
    List<ScheduleDto> getScheduleByScheId(int emp_id, int sche_id, String date);
}
