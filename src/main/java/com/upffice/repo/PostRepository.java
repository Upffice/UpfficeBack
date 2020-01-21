package com.upffice.repo;
import com.upffice.model.PostDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public interface PostRepository extends CrudRepository<PostDto,Integer> {

    @Query("SELECT p FROM PostDto p WHERE p.post_dep_id=0 ORDER BY p.post_id desc")
    public List<PostDto> getAllPosts();

    @Modifying
    @Transactional
    @Query("UPDATE PostDto SET post_subject = ?1, post_content = ?2, created = ?3 WHERE post_id = ?4")
    public void updatePost(String post_subject, String post_content, Date created, int post_id);

}
