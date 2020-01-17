package com.upffice.controller;


import com.upffice.model.ApprovalDto;
import com.upffice.repo.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/app")
public class ApprovalController {

    @Autowired
    ApprovalRepository repository;

    //select all --결재대기함---
    @GetMapping("/{emp_id}")
    public List<ApprovalDto> getAllApproval(@PathVariable("emp_id") int emp_id) {

        List<ApprovalDto> approval =repository.findBySignId(emp_id,emp_id,emp_id);

        return approval;

    }

    //insert --기안문작성--
    @PostMapping("/doc/write")
    public ApprovalDto saveApproval(@RequestBody ApprovalDto approvalDto){

        approvalDto.setApp_date(new SimpleDateFormat("yyyy/MM/dd hh:mm").format(System.currentTimeMillis()));
        approvalDto.setApp_sign_date1(new SimpleDateFormat("yyyy/MM/dd hh:mm").format(System.currentTimeMillis()));
        approvalDto.setApp_sign_date2(new SimpleDateFormat("yyyy/MM/dd hh:mm").format(System.currentTimeMillis()));
        approvalDto.setApp_sign_date3(new SimpleDateFormat("yyyy/MM/dd hh:mm").format(System.currentTimeMillis()));

        ApprovalDto approval =
                repository.save(new ApprovalDto(
                                approvalDto.getApp_doc_num(),
                                approvalDto.getApp_type(),
                                approvalDto.getApp_doc_title(),
                                approvalDto.getApp_writer_id(),
                                approvalDto.getApp_date(),
                                approvalDto.getApp_comment(),
                                approvalDto.getApp_ref_id1(),
                                approvalDto.getApp_ref_id2(),
                                approvalDto.getApp_ref_id3(),
                                approvalDto.getApp_ref_file(),
                                approvalDto.getApp_content(),
                                approvalDto.getApp_sign_id1(),
                                approvalDto.getApp_sign_id2(),
                                approvalDto.getApp_sign_id3(),
                                approvalDto.getApp_sign_date1(),
                                approvalDto.getApp_sign_date2(),
                                approvalDto.getApp_sign_date3(),
                                approvalDto.getApp_status_check(),
                                approvalDto.getApp_status1(),
                                approvalDto.getApp_status2(),
                                approvalDto.getApp_status3(),
                                approvalDto.getApp_writer_name(),
                                approvalDto.getApp_writer_position(),
                                approvalDto.getApp_writer_depname(),
                                approvalDto.getApp_writer_depid()    ));

        return approval;
    }

}
