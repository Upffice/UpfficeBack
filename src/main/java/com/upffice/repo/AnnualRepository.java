package com.upffice.repo;

import com.upffice.model.AnnualDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface AnnualRepository extends CrudRepository<AnnualDto, Integer> {
    //List<AnnualDto> findByEmpId(int empId);
    /*
     * Annual 테이블에 해당하는 Repository
     */

    /* 특정 직원(emdId)의 연차 사용 기록 조회 */
    @Query(value="select annual_date from annual where emp_id=?1 ", nativeQuery=true)
    List<Object> findAnnualDateByEmpId(int empId);

    /* UpfficeFront의 근속년수를 일단위로 가져옴 */
    @Query(value = "select DATEDIFF(curdate(),?1)", nativeQuery=true)
    int getWorkingDays(Date hireDate);
}
