package com.upffice.repo;

import com.upffice.model.WorkingDto;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface WorkingRepository extends CrudRepository<WorkingDto, Integer> {
    /*
     * working 테이블에 해당하는 Repository
     */

    /* working의 기본키(emdId,workingDate)로 해당 직원의 해당일의 근태기록 조회 */
    Optional<WorkingDto> findByEmpIdAndWorkingDate(int empId, Date workingDate);
}