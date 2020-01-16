package com.upffice.controller;

import com.upffice.model.PostDto;
import com.upffice.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pst")
public class PostController {
    @Autowired
    PostRepository repository;

    // 게시글 저장 하는 메소드
        @PostMapping("/post")
        public PostDto postBoard(@RequestBody PostDto postDto){
            System.out.println(postDto + "post 찍어보기");
            PostDto _post=repository.save(new PostDto(postDto.getBoard_name(), postDto.getHeader(), postDto.getPost_writer(), postDto.getPost_subject(), postDto.getPost_content()));
            System.out.println(_post+"_post");
            return _post;
    }

    //저장된 게시물을 보내주는 메소드
    @GetMapping("/posts")
    public List<PostDto> getAllPosts(){

            List<PostDto> posts =new ArrayList<>();
            repository.findAll().forEach(posts::add);

            return posts;
    }
    @DeleteMapping("/delete/{post_id}")
    public ResponseEntity<String> deletePost(@PathVariable("post_id")int post_id){
            System.out.println("Delete Customer with ID =" + post_id+"...");
            repository.deleteById(post_id);

            return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
    }
    //이 기능을 수행하면 조회수가 +1 되어 DB에 저장되는 메서드
    @PutMapping("/view/{post_id}")
    public ResponseEntity<PostDto> updateView(@PathVariable("post_id") int post_id){
        System.out.println("get post_view");
        Optional<PostDto> PostsData = repository.findById(post_id);


        if(PostsData.isPresent()){
            PostDto _postDto = PostsData.get();
            _postDto.setPost_views(_postDto.getPost_views()+1);
            return new ResponseEntity<>(repository.save(_postDto),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    //post_id 값의 모든 데이터를 불러와 수정하는 메서드
    @PutMapping("/update/{post_id}")
    public void updatePost(@PathVariable("post_id")int post_id, @RequestBody PostDto updateData) {
        System.out.println("post_id, 수정데이터 "+ post_id +"  "+ updateData);
        repository.updatePost(updateData.getPost_subject(), updateData.getPost_content(), null, post_id);
    }



}
