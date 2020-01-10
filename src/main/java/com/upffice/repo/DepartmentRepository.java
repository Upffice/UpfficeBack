package com.upffice.repo;

import com.upffice.model.DepartmentDto;
import com.upffice.model.EmployeeDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentDto, Integer> {

    @Query("SELECT dep_name FROM DepartmentDto WHERE dep_id=?1")
    String getDepNameById(int dep_id);
}
