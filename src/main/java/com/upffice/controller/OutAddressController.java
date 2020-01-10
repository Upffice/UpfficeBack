package com.upffice.controller;


import com.upffice.model.OutAddressDto;
import com.upffice.repo.OutAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                outAddressDto.getOut_email(), outAddressDto.getOut_company(), outAddressDto.getOut_dep_phone()));
        return _outaddress;
    }

    @DeleteMapping("/outaddress/{out_id}")
    public ResponseEntity<String> deleteOutaddress(@PathVariable("out_id") int out_id) {
        System.out.println("Delete outaddress with ID = " + out_id + "...");

        repository.deleteById(out_id);

        return new ResponseEntity<>("outaddress has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/outaddress/out_name/{out_name}")
    public List<OutAddressDto> findByNameLike(@PathVariable("out_name") String out_name) {
        System.out.println("게시판 찾기");
        List<OutAddressDto> outaddress = repository.findByOutNameLike("%"+out_name+"%");
        return outaddress;
    }

    @PutMapping("/outaddress/{out_id}")
    public ResponseEntity<OutAddressDto> updateBoard(@PathVariable("out_id") int out_id, @RequestBody OutAddressDto outaddress) {
        System.out.println("Update Outaddress with ID = " + out_id + "...");

        Optional<OutAddressDto> outaddressData = repository.findById(out_id);

        if (outaddressData.isPresent()) {
            OutAddressDto _Outaddress = outaddressData.get();
            _Outaddress.setOut_id(outaddress.getOut_id());
            _Outaddress.setOutName(outaddress.getOutName());
            _Outaddress.setOut_mobile(outaddress.getOut_mobile());
            _Outaddress.setOut_email(outaddress.getOut_email());
            _Outaddress.setOut_company(outaddress.getOut_company());
            _Outaddress.setOut_dep_phone(outaddress.getOut_dep_phone());
            return new ResponseEntity<>(repository.save(_Outaddress), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
