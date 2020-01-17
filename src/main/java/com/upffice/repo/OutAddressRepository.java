package com.upffice.repo;

import com.upffice.model.OutAddressDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OutAddressRepository extends CrudRepository<OutAddressDto, Integer> {
    List<OutAddressDto> findByOutNameLike(String outName);

    List<OutAddressDto> findByOutCompanyLike(String outCompany);




    @Query("SELECT nameAndCompany from OutAddressDto nameAndCompany WHERE nameAndCompany.outName=?1 or nameAndCompany.outCompany=?2")
    public List<OutAddressDto> findByNameAndOutCompanyLike(String outName, String outCompany);



}
