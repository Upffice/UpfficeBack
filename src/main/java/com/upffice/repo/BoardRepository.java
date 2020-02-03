package com.upffice.repo;
import com.upffice.model.BoardDto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<BoardDto,Integer> {

    @Query("SELECT p from BoardDto p WHERE p.dep_id=?1")
    public List<BoardDto> getAllboard(int dep_id);



}
