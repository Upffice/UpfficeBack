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
    /*
    * UpfficeFront 의 마이페이지 기능에 사용되는 Controller
    */

    @Autowired
    EmployeeRepository repository;

    /* UpfficeFront 의 MypageInfo.vue 가 mounted 되고 그 안의 메소드 호출 시, 매핑 됨 */
    @PostMapping("/{id}")
    public EmployeeDto getEmployeeInfo(@PathVariable("id") int id) {
        Optional<EmployeeDto> emp = repository.findById(id);

        /* 어차피 id 값이 있을 거라 if 필요없을 것 같긴 하지만,
         안전하게 결과값 존재하는지 조건문으로 검사함. */
        if(emp.isPresent()) {
            EmployeeDto _emp = emp.get();
            return _emp; // emp_id에 해당하는 사원 정보를 리턴한다.
        }

        return null; // 없으면 null 리턴
    }

    /* UpfficeFront의 MypageInfo.vue에서 정보 수정하기 버튼 눌렀을 때 매핑 됨 : 비밀번호와 휴대폰 번호 수정 */
    @PutMapping("/update/phone/{id}")
    public int updatePhoneInfo(@PathVariable("id") int id, @RequestBody EmployeeDto data) {

       // 수정 된 행의 갯수를 받아온다. chk이 1이면 1개의 row가 수정 되었다는 뜻.
       int chk =  repository.updatePhone(data.getEmp_pw(), data.getPhone_number(), id);

       return chk; // 수정 되었으면 1이 리턴된다. : 수정 성공(데이터 row 하나만 수정 하기 때문.)
    }

}
