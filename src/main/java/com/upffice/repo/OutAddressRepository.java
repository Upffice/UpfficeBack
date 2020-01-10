package com.upffice.repo;

import com.upffice.model.OutAddressDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OutAddressRepository extends CrudRepository<OutAddressDto, Integer> {
    List<OutAddressDto> findByOutNameLike(String outName);
}
