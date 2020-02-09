package com.upffice.repo;

import com.upffice.model.ParticipantsDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParticipantsRepository extends CrudRepository<ParticipantsDto,Integer> {

    @Query("SELECT p from ParticipantsDto p WHERE p.survey_id=?1")
    public List<ParticipantsDto> getAllVote(int survey_id);
}
