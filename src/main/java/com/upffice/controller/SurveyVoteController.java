package com.upffice.controller;


import com.upffice.model.ParticipantsDto;
import com.upffice.repo.ParticipantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/survey")
public class SurveyVoteController {
    @Autowired
    ParticipantsRepository P_repository;

    //입력받은 설문 데이터를 저장하는 메서드
    @PutMapping("/vote")
    public ParticipantsDto saveVote(@RequestBody ParticipantsDto participantsDto){
        System.out.println("이곳은 vote");
        System.out.println(participantsDto+"의 값");
        ParticipantsDto _savesurvey = new ParticipantsDto(participantsDto.getSurvey_id(),participantsDto.getEmp_id(),participantsDto.getSelection());
        P_repository.save(_savesurvey);
        System.out.println(_savesurvey+"찍자");
        return _savesurvey;
    }

    //survey_id 에 해당하는 모든 값을 가져오는 메서드
    @GetMapping("/getvote/{survey_id}")
   public List<ParticipantsDto> getVote(@PathVariable("survey_id")int survey_id){
        List<ParticipantsDto> Vote =P_repository.getAllVote(survey_id);
        System.out.println(Vote +"여기는 보트까지 들어오나");
        for(int i=0; i<Vote.size(); i++) {
            System.out.println(Vote.get(i)+"getvote");
        }
        return Vote;
    }

}


