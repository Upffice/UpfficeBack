package com.upffice.repo;

import com.upffice.model.AnnualDto;
import com.upffice.model.WorkingDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface AnnualRepository extends CrudRepository<AnnualDto, Integer> {
    //List<AnnualDto> findByEmpId(int empId);
    /*
     * Annual 테이블에 해당하는 Repository
     */

    /* 특정 직원(emdId)의 연차 사용 기록 조회 */
    @Query(value="select annual_date from annual where emp_id=?1 and annual_date > ?2", nativeQuery=true)
    List<Object> findAnnualDatesByEmpId(int empId,String janFirst);

    /* UpfficeFront의 근속년수를 일단위로 가져옴 */
    @Query(value = "select DATEDIFF(curdate(),?1)", nativeQuery=true)
    int getWorkingDays(Date hireDate);

    /* 특정 직원(emdId)이 특정 날짜에 연차를 사용했는지 조회 */
    @Query(value="select * from annual where emp_id=?1 and annual_date = ?2", nativeQuery=true)
    Optional<AnnualDto> findAnnualByEmpId(int empId, String applyDate);

}
