package com.upffice.controller;


import com.upffice.model.ParticipantsDto;
import com.upffice.model.SurveyDto;
import com.upffice.repo.ParticipantsRepository;
import com.upffice.repo.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    SurveyRepository repository;

    //폼에 입력된 데이터 받아 DB에 저장하는 메서드
    @PostMapping("/addsurvey")
    public SurveyDto addSurvey(@RequestBody SurveyDto surveyDto){
        System.out.println(surveyDto + "들어 옵니까 ?");
        SurveyDto _addsurvey=repository.save(new SurveyDto(surveyDto.getSurvey_writer(),surveyDto.getSurvey_detail(),surveyDto.getSurvey_question(),surveyDto.getSurvey_subject(),surveyDto.getAnswer1(),surveyDto.getAnswer2(),surveyDto.getAnswer3(),surveyDto.getStart_date(),surveyDto.getEnd_date()));
        System.out.println(_addsurvey+"찍어보자 데이터");
        return _addsurvey;
    }
    //저장된 데이터를 모두 출력하는 메서드
    @GetMapping("/allsurvey")
    public List<SurveyDto> getAllSurvey(){
        System.out.println("getAllsurvey");
        List<SurveyDto> survey = repository.getAllSurveys();

        return survey;
    }

}
