package com.upffice.repo;

import com.upffice.model.AnnualDto;
import com.upffice.model.CalendarDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalendarRepository extends CrudRepository<CalendarDto, Integer> {
    /*
     * Calendar 테이블에 해당하는 Repository
     */

    @Query(value="select c from CalendarDto c where c.emp_id=?1 ")
    List<CalendarDto> getCalendarByEmpId(int empId);

}
