package com.upffice.controller;


import com.upffice.model.OutAddressDto;
import com.upffice.repo.OutAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/outaddress")
    public OutAddressDto postBoard(@RequestBody OutAddressDto outAddressDto) {
        OutAddressDto _outaddress = repository.save(new OutAddressDto(outAddressDto.getOut_id(),
                outAddressDto.getOutName(), outAddressDto.getOut_mobile(),
                outAddressDto.getOut_email(), outAddressDto.getOutCompany(), outAddressDto.getOut_dep_phone()));
        return _outaddress;
    }


    @GetMapping("/outaddress/outName/{outName}")
    public List<OutAddressDto> findByNameLike(@PathVariable("out_name") String outName) {
        System.out.println("이름으로 찾기");
        List<OutAddressDto> outaddress = repository.findByOutNameLike("%"+outName+"%");
        return outaddress;
    }

    @GetMapping("/outaddress/outCompany/{outCompany}")
    public List<OutAddressDto> findByOutCompanyLike(@PathVariable("outCompany") String outCompany) {
        System.out.println("회사 이름으로 찾기");
        List<OutAddressDto> outaddress = repository.findByOutCompanyLike("%"+outCompany+"%");
        return outaddress;
    }

    @GetMapping("/outaddress/nameAndCompany/{nameAndCompany}")
    public List<OutAddressDto> findByNameAndOutCompanyLike(@PathVariable("nameAndCompany") String outCompany, String outName) {
        System.out.println("회사 이름으로 찾기");
        List<OutAddressDto> outaddress = repository.findByNameAndOutCompanyLike("%+outName+%","%"+outCompany+"%");
        return outaddress;
    }



}
