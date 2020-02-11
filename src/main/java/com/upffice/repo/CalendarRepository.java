package com.upffice.repo;

import com.upffice.model.AnnualDto;
import com.upffice.model.CalendarDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CalendarRepository extends CrudRepository<CalendarDto, Integer> {
    /*
     * Calendar 테이블에 해당하는 Repository
     */

    /* emp_id 에 해당하는 모든 캘린더 목록 가져오기 */
    @Query("SELECT c FROM CalendarDto c WHERE c.emp_id=?1")
    List<CalendarDto> getCalendarByEmpId(int empId);

    /* emp_id 와 calendar_id 로 캘린더 리스트 가져오기 */
    @Query("SELECT c FROM CalendarDto c WHERE c.emp_id=?1 AND c.calendar_id=?2")
    CalendarDto getCalendarByCalId(int emp_id, int calendar_id);

    /* emp_id 와 calendar_id 로 캘린더 목록 삭제 */
    @Modifying
    @Transactional
    @Query("DELETE FROM CalendarDto WHERE emp_id=?1 AND calendar_id=?2")
    int deleteCalendar(int emp_id, int calendar_id);

    /* emp_id와 calendar_id 로 캘린더 이름, 색 수정*/
    @Modifying
    @Transactional
    @Query("UPDATE CalendarDto SET calendar_name=?1, calendar_color=?2 WHERE emp_id=?3 AND calendar_id=?4")
    int updateCalendar(String calendar_name, String calendar_color, int emp_id, int calendar_id);
}
