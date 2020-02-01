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

//    @Query("SELECT DISTINCT s FROM ScheduleDto s WHERE s.emp_id=?1 AND s.sche_start_date <= ?2 and s.sche_end_date >= ?2")
//    List<ScheduleDto> getScheduleByEmpId(int emp_id, Date date);

    @Query("SELECT DISTINCT s FROM ScheduleDto s WHERE s.emp_id=?1 AND ?2 BETWEEN s.sche_start_date and s.sche_end_date")
    List<ScheduleDto> getScheduleByEmpId(int emp_id, Date date);

    // between 써서 날짜 사이에 ?1 가 끼어있는 일정들 출력 - 전부 출력, calendarId 로 구분해 출력하는 메소드 총 2개
    @Query(value="select s from ScheduleDto s where s.emp_id=?1 and s.sche_id =?2 " +
            "and s.sche_start_date <= STR_TO_DATE(?3, '%Y-%m-%d') and s.sche_end_date >= STR_TO_DATE(?3, '%Y-%m-%d')"
            , nativeQuery=true)
    List<ScheduleDto> getScheduleByScheId(int emp_id, int sche_id, String date);
}
