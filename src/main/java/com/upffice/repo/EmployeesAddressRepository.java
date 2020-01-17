package com.upffice.repo;

import com.upffice.model.EmployeesAddressDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeesAddressRepository extends CrudRepository<EmployeesAddressDto,Integer>{
    List<EmployeesAddressDto> findByNameLike(String name);

}
