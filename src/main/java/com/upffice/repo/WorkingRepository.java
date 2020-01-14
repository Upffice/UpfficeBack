package com.upffice.repo;

import com.upffice.model.WorkingDto;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface WorkingRepository extends CrudRepository<WorkingDto, Integer> {
    Optional<WorkingDto> findByEmpIdAndWorkingDate(int empId, Date workingDate);
}