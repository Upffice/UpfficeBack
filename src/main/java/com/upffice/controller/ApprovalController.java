package com.upffice.controller;


import com.upffice.model.ApprovalDto;
import com.upffice.repo.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    ApprovalRepository repository;

    @GetMapping("/sign/wait/{emp_id}")
    public Optional<ApprovalDto> getAllApproval(@PathVariable("emp_id") int emp_id) {
        System.out.println("Get all waitList...");

        List<ApprovalDto> approvals = new ArrayList<>();
        Optional<ApprovalDto> approval =repository.findBySignId(emp_id,emp_id,emp_id);

        System.out.println(emp_id);

//        if(approval.isPresent()){
//            return approval;
//        }

        return approval;

    }
}
