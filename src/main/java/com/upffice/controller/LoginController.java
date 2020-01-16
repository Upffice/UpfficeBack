package com.upffice.controller;

import com.upffice.model.EmployeeDto;
import com.upffice.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class LoginController {
    /*
     * UpfficeFront의 로그인 기능에 사용되는 Controller
     */

    @Autowired
    EmployeeRepository repository;

    /* UpfficeFront의 MainView.vue에서 로그인 시 매핑됨. */
    @PostMapping("login")
    public int checkLogin(@RequestBody EmployeeDto dto) {
        int login_emp_id = repository.checkLogin(dto.getEmp_id(), dto.getEmp_pw()); // id와 pw가 일치하면, 사용자의 사번 return.

        if(login_emp_id != 0) {
            return dto.getEmp_id();
        }// 결과 값이 0이 아니면 DB에 있다는 뜻이므로 emp_id를 리턴해준다.

        return 0; // login_emp_id이 0일 때, 즉 검색된 값이 없을 때 0을 리턴한다.
    }

    /* UpfficeFront의 TopMenu.vue 에 들어갈 이름을 가져오기 위한 메소드 */
    @PostMapping("login/name/{id}")
    public String getName(@PathVariable int id) {
        String name = repository.getNameById(id);

        if(name != null) {
            return name;
        }

        return "";
    }

}
