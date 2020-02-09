package com.upffice.controller;


import com.upffice.model.ApprovalDto;
import com.upffice.model.DepartmentDto;
import com.upffice.model.EmployeeDto;
import com.upffice.repo.ApprovalRepository;
import com.upffice.repo.DepartmentRepository;
import com.upffice.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/app")
public class ApprovalController {

    @Autowired
    ApprovalRepository repository;

    @Autowired
    DepartmentRepository depRepo;

    @Autowired
    EmployeeRepository empRepo;


    //select all --결재대기함---
    @GetMapping("/{emp_id}")
    public List<ApprovalDto> getAllApproval(@PathVariable("emp_id") int emp_id) {
        /*자신이 결재자에 포함된 문서 불러오기*/
        List<ApprovalDto> approval = repository.findBySignId(emp_id, emp_id, emp_id);

        return approval;

    }

    @GetMapping("/writer/{emp_id}")
    public List<ApprovalDto> getAllApprovals(@PathVariable("emp_id") int emp_id) {
        /*자신이 상신한 문서 불러오기*/
        List<ApprovalDto> dtoArr = repository.findByWriterId(emp_id);

        return dtoArr;
    }

    @GetMapping("/writer/title/{query}")
    public List<ApprovalDto> getTitleApprovals(@PathVariable("query") String query) {
        /*제목으로 검색*/
        List<ApprovalDto> dtoArr = repository.findByTitle("%"+query+"%");
        return dtoArr;
    }

    @GetMapping("/writer/content/{query}")
    public List<ApprovalDto> getContentApprovals(@PathVariable("query") String query) {
        /*내용으로 검색*/
        List<ApprovalDto> dtoArr = repository.findByContent("%" + query + "%");
        return dtoArr;
    }

    @GetMapping("/all")
    public List<ApprovalDto> getAllDocs() {
        /*모든문서 가져오기*/
        List<ApprovalDto> dtoArr = repository.findDocs();
        return dtoArr;
    }

    @GetMapping("/depfind/{dep_id}")
    public List<ApprovalDto> getDepDocs(@PathVariable("dep_id") int dep_id) {

        List<ApprovalDto> dtoArr = repository.findByDepId(dep_id);

        return dtoArr;
    }

    //insert --기안문작성--
    @PostMapping("/doc/write")
    public ApprovalDto saveApproval(@RequestBody ApprovalDto approvalDto) {

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
                        approvalDto.getApp_writer_depid()));

        return approval;
    }


    @PostMapping("/search/dep")
    public Iterable<DepartmentDto> searchDep() {
        Iterable<DepartmentDto> dto = depRepo.findAll();

        return dto;
    }

    @PostMapping("/search/emp")
    public Iterable<EmployeeDto> searchEmp() {
        Iterable<EmployeeDto> dto = empRepo.findAll();

        return dto;

    }

    @GetMapping("/sign/wait/{app_doc_num}")
    public ApprovalDto searchDoc(@PathVariable("app_doc_num") int app_doc_num) {
        ApprovalDto dto = repository.findByApp_doc_num(app_doc_num);

        return dto;
    }

    @PostMapping("/multiple-files/{app_doc_num}")
    public String uploadMultipleFiles(@PathVariable("app_doc_num") String app_doc_num,@RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException {
        /* C:\Users\SH\Documents\TeamProject\UpfficeBack */
        String projectPath = System.getProperty("user.dir");

        /* C:\Users\SH\Documents\TeamProject\UpfficeBack\src\assets\문서번호\파일명 */
        String UPLOADED_FOLDER = projectPath+"\\src\\assets\\"+app_doc_num+"\\";
//        System.out.println(UPLOADED_FOLDER);
//        System.out.println("파일이"+files.length+"개 들어왔음");

        String status = "";
        File dir = new File(UPLOADED_FOLDER);
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            try {
                byte[] bytes = file.getBytes();

                if (!dir.exists())
                    dir.mkdirs();

                File uploadFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(uploadFile));
                outputStream.write(bytes);
                outputStream.close();

                status = status + "You successfully uploaded file=" + file.getOriginalFilename();
            } catch (Exception e) {
                status = status + "Failed to upload " + file.getOriginalFilename()+ " " + e.getMessage();
            }
        }
        return status;
}

    @DeleteMapping("/doc/delete/{app_doc_num}")
    public String deleteTemp(@PathVariable("app_doc_num") int app_doc_num){

        repository.deleteById(app_doc_num);
        if(!repository.existsById(app_doc_num)){
            return "succes";
        }

        return "Fail!";
    }

}
