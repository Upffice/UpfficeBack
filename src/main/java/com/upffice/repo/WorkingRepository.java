package com.upffice.repo;

import com.upffice.model.WorkingDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface WorkingRepository extends CrudRepository<WorkingDto, Integer> {
}