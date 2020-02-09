package com.upffice.controller;

import com.upffice.model.EmployeesAddressDto;
import com.upffice.repo.EmployeesAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeesAddressController {

    @Autowired
    EmployeesAddressRepository employeesAddressRepository;

    @GetMapping("/employees")                               /*데이터 다 불러오기*/
    public List<EmployeesAddressDto> getAllEmployees() {
        System.out.println("Get all employees...");

        List<EmployeesAddressDto> employees = new ArrayList<>();
        employeesAddressRepository.findAll().forEach(employees::add);
        return employees;
    }


    @GetMapping("/employees/nameAndPosition/{nameAndPosition}")     /*이름,직책으로 찾기*/
    public List<EmployeesAddressDto> findByNameAndPositionLike(@PathVariable("nameAndPosition") String nameAndPosition) {
        System.out.println("이름,직책으로 찾기");
        List<EmployeesAddressDto> employeesaddress = employeesAddressRepository.findByNameAndPositionLike("%" + nameAndPosition + "%", "%" + nameAndPosition + "%");
        return employeesaddress;
    }

    /* UpfficeFront 의 MypageInfo.vue 가 mounted 되고 그 안의 메소드 호출 시, 매핑 됨 */
    @PostMapping("/detail/{id}")
    public EmployeesAddressDto getEmployeeInfo(@PathVariable("id") int id) {
        Optional<EmployeesAddressDto> emp = employeesAddressRepository.findById(id);

        /* 어차피 id 값이 있을 거라 if 필요없을 것 같긴 하지만,
         안전하게 결과값 존재하는지 조건문으로 검사함. */
        if(emp.isPresent()) {
            EmployeesAddressDto _emp = emp.get();
            return _emp; // emp_id에 해당하는 사원 정보를 리턴한다.
        }

        return null; // 없으면 null 리턴
    }

    @PutMapping("/update/{id}")                             /*내부주소록 수정*/
    public int updateInfo(@PathVariable("id") int id, @RequestBody EmployeesAddressDto data){

        int chk = employeesAddressRepository.managerEmployeesUpdate(data.getName(), data.getEmp_email(),
                data.getPosition(), data.getHire_date(), data.getExtension_number(),
                data.getPhone_number(), data.getDep_id(), id);
        return chk;

    }

    @PostMapping("/employees/add")                                    /*내부주소록 직원 추가*/
    public EmployeesAddressDto addEmployees(@RequestBody EmployeesAddressDto employees) {
        System.out.println(employees);
        EmployeesAddressDto _employees = employeesAddressRepository.save(new EmployeesAddressDto(employees.getEmp_id(),
                employees.getEmp_pw(),employees.getName(), employees.getEmp_email(),employees.getPosition(),
                employees.getHire_date(),employees.getExtension_number(),employees.getPhone_number(), employees.getDep_id()));
        System.out.println(_employees);
        return _employees;

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {
        System.out.println("Delete Employees with ID = " + id + "...");

        employeesAddressRepository.deleteById(id);

        return new ResponseEntity<>("Employees has been deleted!", HttpStatus.OK);
    }

}