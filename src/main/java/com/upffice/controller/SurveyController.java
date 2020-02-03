package com.upffice.controller;


import com.upffice.model.SurveyDto;
import com.upffice.repo.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
    //진행중인 설문을 모두 출력하는 메서드
    @GetMapping("/allsurvey")
    public List<SurveyDto> getAllSurvey(){
        System.out.println("getAllsurvey");

        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd 09:00:00");
        Calendar cal = Calendar.getInstance();
        String today = formatter.format(cal.getTime());
        Timestamp current_date = Timestamp.valueOf(today);

        List<SurveyDto> survey = repository.getAllSurveys(current_date);

        return survey;
    }
    //등록된 설문을 삭제하는 메서드
    @DeleteMapping("/deletesurvey/{survey_id}")
    public ResponseEntity<String> deleteSurvey(@PathVariable("survey_id")int survey_id){
        System.out.println("Delete Suvey = ? "+ survey_id);
        repository.deleteById(survey_id);

        return new ResponseEntity<>("delete", HttpStatus.OK);
    }

    //마감된 설문을 모두 출력하는 메서드
    @GetMapping("/endsurvey")
    public List<SurveyDto> getEndSurvey(){
        System.out.println("getEndsurvey");

        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd 09:00:00");
        Calendar cal = Calendar.getInstance();
        String today = formatter.format(cal.getTime());
        Timestamp current_date = Timestamp.valueOf(today);

        List<SurveyDto> survey = repository.getEndSurveys(current_date);

        return survey;
    }

}
