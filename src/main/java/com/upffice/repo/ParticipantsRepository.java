package com.upffice.repo;

import com.upffice.model.ParticipantsDto;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantsRepository extends CrudRepository<ParticipantsDto,Integer> {

}
