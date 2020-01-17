package com.upffice.controller;

import com.upffice.model.EmployeesAddressDto;
import com.upffice.repo.EmployeesAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeesAddressController {

    @Autowired
    EmployeesAddressRepository employeesAddressRepository;

    @GetMapping("/employees")
    public List<EmployeesAddressDto> getAllEmployees() {
        System.out.println("Get all employees...");

        List<EmployeesAddressDto> employees = new ArrayList<>();
        employeesAddressRepository.findAll().forEach(employees::add);
        return employees;
    }



    @GetMapping("/employees/name/{name}")
    public List<EmployeesAddressDto> findByNameLike(@PathVariable("name") String name) {
        System.out.println("이름으로 찾기");
        List<EmployeesAddressDto> employeesaddress = employeesAddressRepository.findByNameLike("%"+name+"%");
        return employeesaddress;
    }

}