package com.upffice.repo;

import com.upffice.model.LoginDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginDto, Integer> {
    @Query("SELECT COUNT(emp_id) FROM LoginDto WHERE emp_id=?1 and emp_pw=?2")
    int checkLogin(int emp_id, String emp_pw);
}
