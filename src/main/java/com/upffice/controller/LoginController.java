package com.upffice.controller;

import com.upffice.model.EmployeeDto;
import com.upffice.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    EmployeeRepository repository;

    @PostMapping("login")
    public int checkLogin(@RequestBody EmployeeDto dto) {
        int login_emp_id = repository.checkLogin(dto.getEmp_id(), dto.getEmp_pw()); // id와 pw가 일치하면, 사용자의 사번 return.
        System.out.println(dto);
        if(login_emp_id != 0) {
            return dto.getEmp_id();
        }
        return 0; // login_emp_id이 0일 때, 즉 검색된 값이 없을 때
    }

    @PostMapping("login/name/{id}")
    public String getName(@PathVariable int id) {
        String name = repository.getNameById(id);

        if(name != null) {
            return name;
        }

        return "";
    }

}
