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

    @PutMapping("/update/phone/{id}")
    public int updatePhoneInfo(@PathVariable("id") int id, @RequestBody EmployeeDto data) {
       int chk =  repository.updatePhone(data.getEmp_pw(), data.getPhone_number(), id); // 휴대폰 번호 수정하기
       // 수정 된 행의 갯수 return 해주는 듯 chk이 1이면 1개의 row가 수정 되었다는 뜻
       return chk;
    }

    // 비밀번호 수정하기
}
