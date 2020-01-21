package com.upffice.controller;


import com.upffice.model.ParticipantsDto;
import com.upffice.model.SurveyDto;
import com.upffice.repo.ParticipantsRepository;
import com.upffice.repo.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/survey")
public class SurveyVoteController {
    @Autowired
    ParticipantsRepository P_repository;

    @PutMapping("/vote")
    public ParticipantsDto saveVote(@RequestBody ParticipantsDto participantsDto){
        System.out.println("이곳은 vote");
        System.out.println(participantsDto+"의 값");
        ParticipantsDto _savesurvey = new ParticipantsDto(participantsDto.getSurvey_id(),participantsDto.getEmp_id(),participantsDto.getSelection());
        P_repository.save(_savesurvey);
        System.out.println(_savesurvey+"찍자");
        return _savesurvey;
    }
}
