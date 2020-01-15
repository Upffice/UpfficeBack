package com.upffice.model;


import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(name="posts")
public class PostDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int post_id;

    @Column(name = "board_name")
    private String board_name;

    @Column(name = "header")
    private String header;

    @Column(name = "post_writer")
    private String post_writer;

    @Column(name = "post_subject")
    private String post_subject;

    @Column(name = "post_content")
    private String post_content;

    @Column(name = "post_created")
    private Date created;

    @Column(name = "post_views")
    private int post_views;


    public PostDto() {
    }

    public PostDto(String board_name, String header, String post_writer, String post_subject, String post_content) {
        this.board_name=board_name;
        this.header=header;
        this.post_writer=post_writer;
        this.post_subject=post_subject;
        this.post_content=post_content;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getBoard_name() {
        return board_name;
    }

    public void setBoard_name(String board_name) {
        this.board_name = board_name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPost_writer() {
        return post_writer;
    }

    public void setPost_writer(String post_writer) {
        this.post_writer = post_writer;
    }

    public String getPost_subject() {
        return post_subject;
    }

    public void setPost_subject(String post_subject) {
        this.post_subject = post_subject;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getCreated() {
        return new SimpleDateFormat("yyyy/MM/dd hh:mm").format(created);
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getPost_views() {
        return post_views;
    }

    public void setPost_views(int post_views) {
        this.post_views = post_views;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "post_id=" + post_id +
                ", board_name='" + board_name + '\'' +
                ", header='" + header + '\'' +
                ", post_writer='" + post_writer + '\'' +
                ", post_subject='" + post_subject + '\'' +
                ", post_content='" + post_content + '\'' +
                ", created=" + created +
                ", post_views=" + post_views +
                '}';
    }


}
