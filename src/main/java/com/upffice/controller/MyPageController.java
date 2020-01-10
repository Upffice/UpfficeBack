package com.upffice.controller;

import com.upffice.model.EmployeeDto;
import com.upffice.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mypage")
public class MyPageController {
    @Autowired
    EmployeeRepository repository;

    @PostMapping("/{id}")
    public EmployeeDto getEmployeeInfo(@PathVariable("id") int id) {
        System.out.println("Get Employee Info");
        Optional<EmployeeDto> emp = repository.findById(id);

        if(emp.isPresent()) {
            EmployeeDto _emp = emp.get();
            return _emp;
        } // 어차피 id 있을 거라 if 필요없나????????????

        return null;
    }

}
