package com.upffice.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import com.upffice.model.AnnualDto;
import com.upffice.model.WorkingDto;
import com.upffice.repo.AnnualRepository;
import com.upffice.repo.WorkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/working")
public class WorkingController {

    @Autowired
    WorkingRepository workingRepository;

    @Autowired
    AnnualRepository annualRepository;

    @GetMapping("/readIn/{empId}")
    public ResponseEntity<String> workingReadIn(@PathVariable("empId") int empId) {
        Optional<WorkingDto> workingData = workingRepository.findByEmpIdAndWorkingDate(empId,new Date(System.currentTimeMillis()));

        if (workingData.isPresent()) {
            WorkingDto _working = workingData.get();
            return new ResponseEntity<>(_working.getWorkingIn()+"", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/readOut/{empId}")
    public ResponseEntity<String> workingReadOut(@PathVariable("empId") int empId) {
        Optional<WorkingDto> workingData = workingRepository.findByEmpIdAndWorkingDate(empId,new Date(System.currentTimeMillis()));

        if (workingData.isPresent()) {
            WorkingDto _working = workingData.get();
            return new ResponseEntity<>(_working.getWorkingOut()+"", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/saveIn/{empId}")
    public String workingSaveIn(@PathVariable("empId") int empId) {
        workingRepository.save(new WorkingDto(empId, new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis())));
        System.out.println(new Date(System.currentTimeMillis()));
        return new Time(System.currentTimeMillis()) + "";
    }

    @GetMapping("/saveOut/{empId}")
    public ResponseEntity<String> workingSaveOut(@PathVariable("empId") int empId) {
        Optional<WorkingDto> workingData = workingRepository.findByEmpIdAndWorkingDate(empId,new Date(System.currentTimeMillis()));

        if (workingData.isPresent()) {
            WorkingDto _working = workingData.get();
            _working.setWorkingOut(new Time(System.currentTimeMillis()));
            workingRepository.save(_working);
            return new ResponseEntity<>(_working.getWorkingOut()+"", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/annuals/{empId}")
    public List<Object> readAnnual(@PathVariable( "empId") int empId) {
       List<Object> annuals = annualRepository.findAnnualDateByEmpId(empId);
        return annuals;
    }

    @GetMapping("/annuals/count/{empId}")
    public List<Object> countAnnual(@PathVariable( "empId") int empId) {
        System.out.println("연차 조회");
        List<Object> annuals = annualRepository.findAnnualDateByEmpId(empId);
        return annuals;
    }
}