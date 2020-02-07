package com.upffice.controller;

import com.upffice.model.AnnualDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/file")
public class FileController {
    /*
     * UpfficeFront 의 자료실 기능에 사용되는 Controller
     */
    //    @Value("${file.dir}")
    //    private String fileDir;

    @PostMapping("/uploadFiles/{empId}")
    public void uploadFiles(@PathVariable("empId") int empId, @RequestParam("files") MultipartFile filees) {
        System.out.println("사번"+empId);
    }
}
