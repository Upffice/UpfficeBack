package com.upffice.repo;

import com.upffice.model.EmployeeDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeDto, Integer> {

    @Query("SELECT COUNT(emp_id) FROM EmployeeDto WHERE emp_id=?1 and emp_pw=?2")
    int checkLogin(int emp_id, String emp_pw);

    @Query("SELECT emp_name FROM EmployeeDto WHERE emp_id=?1")
    String getNameById(int emp_id);
}
