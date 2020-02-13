package com.upffice.repo;
import com.upffice.model.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<PostDto,Integer> {

    // post_dep_id에 맞춰서 전체 게시글 가져오는 쿼리
    @Query("SELECT p FROM PostDto p WHERE p.post_dep_id=?1 ORDER BY p.post_id desc")
    public List<PostDto> getAllPosts(int post_dep_id);

    @Query("SELECT u FROM PostDto u WHERE u.board_name=?1")
    public List<PostDto> getAllDepPosts(String board_name);


    @Query("select SearchSubject from PostDto SearchSubject WHERE SearchSubject.post_subject like ?1")
    List<PostDto> findBySearchSubjectLike(String post_subject);

    @Modifying
    @Transactional
    @Query("UPDATE PostDto SET post_subject = ?1, post_content = ?2, created = ?3 WHERE post_id = ?4")
    public void updatePost(String post_subject, String post_content, Date created, int post_id);

}
