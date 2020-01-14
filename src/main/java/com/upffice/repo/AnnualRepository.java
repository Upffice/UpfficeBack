package com.upffice.repo;

import com.upffice.model.AnnualDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnnualRepository extends CrudRepository<AnnualDto, Integer> {
    //List<AnnualDto> findByEmpId(int empId);
    @Query(value="select annual_date from annual where emp_id=?1 ", nativeQuery=true)
    List<Object> findAnnualDateByEmpId(int empId);

}
