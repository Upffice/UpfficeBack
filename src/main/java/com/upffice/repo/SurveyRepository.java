package com.upffice.repo;

import com.upffice.model.PostDto;
import com.upffice.model.SurveyDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;


public interface SurveyRepository extends CrudRepository<SurveyDto,Integer> {
    @Query("SELECT s FROM SurveyDto s WHERE s.end_date >=?1 ORDER BY s.survey_id desc")
    public List<SurveyDto> getAllSurveys(Timestamp current_date);

    @Query("SELECT s FROM SurveyDto s WHERE s.end_date <?1 ORDER BY s.survey_id desc")
    public List<SurveyDto> getEndSurveys(Timestamp current_date);
}
