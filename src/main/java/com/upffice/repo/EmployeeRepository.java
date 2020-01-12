package com.upffice.repo;

import com.upffice.model.EmployeeDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface EmployeeRepository extends CrudRepository<EmployeeDto, Integer> {

    @Query("SELECT COUNT(emp_id) FROM EmployeeDto WHERE emp_id=?1 and emp_pw=?2")
    int checkLogin(int emp_id, String emp_pw);

    @Query("SELECT emp_name FROM EmployeeDto WHERE emp_id=?1")
    String getNameById(int emp_id);

    @Modifying
    @Transactional
    @Query("UPDATE EmployeeDto SET phone_number = ?1 WHERE emp_id = ?2")
    int updatePhone(String phone_number, int emp_id);
}
