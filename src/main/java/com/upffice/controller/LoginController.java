package com.upffice.controller;

import com.upffice.model.LoginDto;
import com.upffice.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    LoginRepository repository;

    @PostMapping("login")
    public int checkLogin(@RequestBody LoginDto dto) {
        int login_emp_id = repository.checkLogin(dto.getEmp_id(), dto.getEmp_pw()); // id와 pw가 일치하면, 사용자의 사번 return.

        if(login_emp_id != 0) {
            return dto.getEmp_id();
        }
        return 0; // login_emp_id이 0일 때, 즉 검색된 값이 없을 때
    }
}
