package com.upffice.controller;

import com.upffice.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dep")
public class DepartmentController {
    /*
     * 부서번호에 해당하는 부서명 가져오는 데 사용되는 Controller
     * UpfficeFront 의 vue 컴포넌트 중 필요한 곳에서 호출하시면 됩니다.
     * ex) UpfficeFront의 TopMenu.vue 에서 사용됨.(참고)
     */

    @Autowired
    DepartmentRepository repository;

    @PostMapping("/{dep_id}")
    public String getDep_Name(@PathVariable("dep_id") int dep_id) {
        String dep_name = repository.getDepNameById(dep_id);

        return dep_name;
    }
}
