package com.upffice.controller;

import com.upffice.model.OutAddressDto;
import com.upffice.repo.OutAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/outaddress")
public class OutAddressController {
    @Autowired
    OutAddressRepository repository;

    @GetMapping("/outaddress")
    public List<OutAddressDto> getAllOutaddress() {
        System.out.println("Get all outaddress...");

        List<OutAddressDto> outaddresses = new ArrayList<>();
        repository.findAll().forEach(outaddresses::add);
        return outaddresses;
    }


    @GetMapping("/outaddress/nameAndCompany/{nameAndCompany}")
    public List<OutAddressDto> findByNameAndOutCompanyLike(@PathVariable("nameAndCompany")  String nameAndCompany) {
        System.out.println("성명,회사로 찾기");
        List<OutAddressDto> outaddress = repository.findByNameAndOutCompanyLike("%"+nameAndCompany+"%","%"+nameAndCompany+"%");
        return outaddress;
    }


    @GetMapping("/outaddress/outCompany")
    public List<OutAddressDto> findAllByOrderByOutCompanyAsc() {
        System.out.println("회사 이름으로 정렬");
        List<OutAddressDto> outaddress = repository.findAllByOrderByOutCompanyAsc();
        return outaddress;
    }


    @GetMapping("/outaddress/outName")
    public List<OutAddressDto> findAllByOrderByOutNameAsc() {
        System.out.println("외부 이름으로 정렬");
        List<OutAddressDto> outaddress = repository.findAllByOrderByOutNameAsc();
        return outaddress;
    }


    @PutMapping("/update/{id}")
    public int outAddressUpdate(@PathVariable("id") int id, @RequestBody OutAddressDto data){
        int _outAddress = repository.managerOutUpdate(data.getOutName(), data.getOut_mobile(),
                data.getOut_email(),data.getOutCompany(), data.getOut_dep_phone(), id);
        return _outAddress;
    }

    @PostMapping("/outaddress/add")                                    /*내부주소록 직원 추가*/
    public OutAddressDto addEmployees(@RequestBody OutAddressDto outAddressDto) {
        System.out.println(outAddressDto);
        OutAddressDto _outAddress = repository.save(new OutAddressDto(outAddressDto.getOut_id(),
                outAddressDto.getOutName(),outAddressDto.getOut_mobile(), outAddressDto.getOut_email(),outAddressDto.getOutCompany(),
                outAddressDto.getOut_dep_phone()));
        System.out.println(_outAddress);
        return _outAddress;

    }

    @DeleteMapping("/outaddress/{id}")
    public ResponseEntity<String> deleteOutAddress(@PathVariable("id") int id) {
        System.out.println("Delete OutAddress with ID = " + id + "...");

       repository.deleteById(id);

        return new ResponseEntity<>("OutAddress has been deleted!", HttpStatus.OK);
    }




}
