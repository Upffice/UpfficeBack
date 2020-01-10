package com.upffice.controller;

import com.upffice.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dep")
public class DepartmentController {
    @Autowired
    DepartmentRepository repository;

    @PostMapping("/{dep_id}")
    public String getDep_Name(@PathVariable("dep_id") int dep_id) {
        System.out.println("getDep_name + " + dep_id);

        String dep_name = repository.getDepNameById(dep_id);

        return dep_name;
    }
}
