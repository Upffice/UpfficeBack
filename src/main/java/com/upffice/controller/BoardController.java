package com.upffice.controller;


import com.upffice.model.BoardDto;
import com.upffice.repo.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardRepository b_repository;

    //새 게시판을 저장하는 메서드
    @PostMapping("/saveBoard")
   public BoardDto saveBoard(@RequestBody BoardDto boardDto){
        BoardDto _board=b_repository.save(new BoardDto(boardDto.getBoard_name(),boardDto.getDep_id()));
        System.out.println(_board+"  저장된 값");
        return _board;
    }
    //저장된 게시판 이름을 보내주는 메서드
    @GetMapping("/getBoard/{dep_id}")
    public List<BoardDto> getBoard(@PathVariable("dep_id")int dep_id){
        List<BoardDto> boards = b_repository.getAllboard(dep_id);
        System.out.println(boards+"  보내준 데이터");
        return boards;

    }




}
