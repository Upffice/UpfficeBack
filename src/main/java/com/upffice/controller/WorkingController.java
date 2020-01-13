package com.upffice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.upffice.model.WorkingDto;
import com.upffice.repo.WorkingRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/working")
public class WorkingController {

    @Autowired
    WorkingRepository repository;

}