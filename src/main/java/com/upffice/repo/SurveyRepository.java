package com.upffice.repo;

import com.upffice.model.PostDto;
import com.upffice.model.SurveyDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SurveyRepository extends CrudRepository<SurveyDto,Integer> {
    @Query("SELECT s FROM SurveyDto s ORDER BY s.survey_id desc")
    public List<SurveyDto> getAllSurveys();
}
