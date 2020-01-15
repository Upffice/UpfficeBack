package com.upffice.repo;
import com.upffice.model.PostDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.sql.Date;

public interface PostRepository extends CrudRepository<PostDto,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE PostDto SET post_subject = ?1, post_content = ?2, created = ?3 WHERE post_id = ?4")
    public void updatePost(String post_subject, String post_content, Date created, int post_id);

/*    post_writer : this.post.post_writer,
    post_subject : this.post.post_subject,
    post_content : this.post.post_content,
    created : this.post.created,
    post_view : this.post.post_view*/
}
