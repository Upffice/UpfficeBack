package com.upffice.controller;

import com.upffice.model.EmployeesAddressDto;
import com.upffice.repo.EmployeesRepository;
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
    EmployeesRepository employeesRepository;

    @GetMapping("/employees")
    public List<EmployeesAddressDto> getAllEmployees() {
        System.out.println("Get all employees...");

        List<EmployeesAddressDto> employees = new ArrayList<>();
        employeesRepository.findAll().forEach(employees::add);
        return employees;
    }

    @PostMapping("/employees")
    public EmployeesAddressDto postBoard(@RequestBody EmployeesAddressDto employeesAddressDto) {
        EmployeesAddressDto _employeesAddressDto = employeesRepository.save(new EmployeesAddressDto(employeesAddressDto.getEmp_id(), employeesAddressDto.getEmp_pw(),
                employeesAddressDto.getName(), employeesAddressDto.getEmp_email(), employeesAddressDto.getPosition(), employeesAddressDto.getHire_date(),
                employeesAddressDto.getExtension_number(), employeesAddressDto.getPhone_number(), employeesAddressDto.getDep_id()));
        return _employeesAddressDto;
    }

    @DeleteMapping("/employees/{emp_id}")
    public ResponseEntity<String> deleteBoard(@PathVariable("emp_id") int emp_id) {
        System.out.println("Delete employees with ID = " + emp_id + "...");

        employeesRepository.deleteById(emp_id);

        return new ResponseEntity<>("eEmployees has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/employees/emp_name/{emp_name}")
    public List<EmployeesAddressDto> findByNameLike(@PathVariable("emp_name") String emp_name) {
        System.out.println("게시판 찾기");
        List<EmployeesAddressDto> employees = employeesRepository.findByNameLike("%"+emp_name+"%");
        return employees;
    }

    @PutMapping("/employees/{emp_id}")
    public ResponseEntity<EmployeesAddressDto> updateBoard(@PathVariable("emp_id") int emp_id, @RequestBody EmployeesAddressDto employeesAddressDto) {
        System.out.println("Update Employees with ID = " + emp_id + "...");

        Optional<EmployeesAddressDto> employeesData = employeesRepository.findById(emp_id);

        if (employeesData.isPresent()) {
            EmployeesAddressDto _EmployeesAddressDto = employeesData.get();
            _EmployeesAddressDto.setEmp_id(employeesAddressDto.getEmp_id());
            _EmployeesAddressDto.setName(employeesAddressDto.getName());
            _EmployeesAddressDto.setDep_id(employeesAddressDto.getDep_id());
            _EmployeesAddressDto.setPosition(employeesAddressDto.getPosition());
            _EmployeesAddressDto.setPhone_number(employeesAddressDto.getPhone_number());
            _EmployeesAddressDto.setEmp_email(employeesAddressDto.getEmp_email());
            _EmployeesAddressDto.setExtension_number(employeesAddressDto.getExtension_number());
            return new ResponseEntity<>(employeesRepository.save(_EmployeesAddressDto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}