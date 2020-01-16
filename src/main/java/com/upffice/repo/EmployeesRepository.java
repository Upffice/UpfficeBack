package com.upffice.repo;

import com.upffice.model.EmployeesAddressDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeesRepository extends CrudRepository<EmployeesAddressDto,Integer>{
    List<EmployeesAddressDto> findByNameLike(String emp_name);

}
