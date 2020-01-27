package com.upffice.model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "approval")
@DynamicInsert
@SequenceGenerator(name = "seq",initialValue =20200000, allocationSize = 1)
public class ApprovalDto {

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @Id
    private int app_doc_num;

    @Column(name = "app_type")
    private String app_type;

    @Column(name = "app_doc_title")
    private String app_doc_title;

    @Column(name = "app_writer_id")
    private int app_writer_id;

    @Column(name = "app_date")
    private String app_date;

    @Column(name = "app_comment")
    private String app_comment;

    @Column(name = "app_ref_id1")
    private int app_ref_id1;

    @Column(name = "app_ref_id2")
    private int app_ref_id2;

    @Column(name = "app_ref_id3")
    private int app_ref_id3;

    @Column(name = "app_ref_file")
    private String app_ref_file;

    @Column(name = "app_content")
    private String app_content;

    @Column(name = "app_sign_id1")
    private int app_sign_id1;

    @Column(name = "app_sign_id2")
    private int app_sign_id2;

    @Column(name = "app_sign_id3")
    private int app_sign_id3;


    @Column(name = "app_sign_date1")
    private String app_sign_date1;

    @Column(name = "app_sign_date2")
    private String app_sign_date2;

    @Column(name = "app_sign_date3")
    private String app_sign_date3;

    @Column(name = "app_status_check")
    private String app_status_check;

    @Column(name = "app_status1")
    private String app_status1;

    @Column(name = "app_status2")
    private String app_status2;

    @Column(name = "app_status3")
    private String app_status3;

    @Column(name = "app_writer_name")
    private String app_writer_name;

    @Column(name = "app_writer_position")
    private String app_writer_position;

    @Column(name = "app_writer_depid")
    private int app_writer_depid;

    @Column(name = "app_writer_depname")
    private String app_writer_depname;




    public ApprovalDto() {
    }


    public ApprovalDto(int app_doc_num,
                       String app_type,
                       String app_doc_title,
                       int app_writer_id,
                       String app_date,
                       String app_comment,
                       int app_ref_id1,
                       int app_ref_id2,
                       int app_ref_id3,
                       String app_ref_file,
                       String app_content,
                       int  app_sign_id1,
                       int  app_sign_id2,
                       int  app_sign_id3,
                       String  app_sign_date1,
                       String   app_sign_date2,
                       String   app_sign_date3,
                       String   app_status_check,
                       String  app_status1,
                       String  app_status2,
                       String  app_status3,
                       String  app_writer_name,
                       String  app_writer_position,
                       String  app_writer_depname,
                       int  app_writer_depid){


                this.app_doc_num= app_doc_num;
                this.app_type=app_type;
                this.app_doc_title =app_doc_title;
                this.app_writer_id = app_writer_id;
                this.app_date = app_date;
                this.app_comment = app_comment;
                this.app_ref_id1 =app_ref_id1;
                this.app_ref_id2 = app_ref_id2;
                this.app_ref_id3 = app_ref_id3;
                this.app_ref_file = app_ref_file;
                this.app_content = app_content;
                this.app_sign_id1 = app_sign_id1;
                this.app_sign_id2 = app_sign_id2;
                this.app_sign_id3 = app_sign_id3;
                this.app_sign_date1 = app_sign_date1;
                this.app_sign_date2 = app_sign_date2;
                this.app_sign_date3 = app_sign_date3;
                this.app_status_check = app_status_check;
                this.app_status1 = app_status1;
                this.app_status2 = app_status2;
                this.app_status3 = app_status3;
                this.app_writer_name = app_writer_name;
                this.app_writer_position = app_writer_position;
                this.app_writer_depname = app_writer_depname;
                this.app_writer_depid = app_writer_depid;
    }



    public int getApp_doc_num() {
        return app_doc_num;
    }

    public void setApp_doc_num(int app_doc_num) {
        this.app_doc_num = app_doc_num;
    }

    public String getApp_type() {
        return app_type;
    }

    public void setApp_type(String app_type) {
        this.app_type = app_type;
    }

    public String getApp_doc_title() {
        return app_doc_title;
    }

    public void setApp_doc_title(String app_doc_title) {
        this.app_doc_title = app_doc_title;
    }

    public int getApp_writer_id() {
        return app_writer_id;
    }

    public void setApp_writer_id(int app_writer_id) {
        this.app_writer_id = app_writer_id;
    }

    public String getApp_date() {
        return app_date.substring(0, 16);
    }


    public void setApp_date(String app_date) {
        this.app_date = app_date;
    }

    public String getApp_comment() {
        return app_comment;
    }

    public void setApp_comment(String app_comment) {
        this.app_comment = app_comment;
    }

    public int getApp_ref_id1() {
        return app_ref_id1;
    }

    public void setApp_ref_id1(int app_ref_id1) {
        this.app_ref_id1 = app_ref_id1;
    }

    public int getApp_ref_id2() {
        return app_ref_id2;
    }

    public void setApp_ref_id2(int app_ref_id2) {
        this.app_ref_id2 = app_ref_id2;
    }

    public int getApp_ref_id3() {
        return app_ref_id3;
    }

    public void setApp_ref_id3(int app_ref_id3) {
        this.app_ref_id3 = app_ref_id3;
    }

    public String getApp_ref_file() {
        return app_ref_file;
    }

    public void setApp_ref_file(String app_ref_file) {
        this.app_ref_file = app_ref_file;
    }

    public String getApp_content() {
        return app_content;
    }

    public void setApp_content(String app_content) {
        this.app_content = app_content;
    }

    public int getApp_sign_id1() {
        return app_sign_id1;
    }

    public void setApp_sign_id1(int app_sign_id1) {
        this.app_sign_id1 = app_sign_id1;
    }

    public int getApp_sign_id2() {
        return app_sign_id2;
    }

    public void setApp_sign_id2(int app_sign_id2) {
        this.app_sign_id2 = app_sign_id2;
    }

    public int getApp_sign_id3() {
        return app_sign_id3;
    }

    public void setApp_sign_id3(int app_sign_id3) {
        this.app_sign_id3 = app_sign_id3;
    }

    public String getApp_sign_date1() {
        return app_sign_date1.substring(0, 16);
    }

    public void setApp_sign_date1(String app_sign_date1) {
        this.app_sign_date1 = app_sign_date1;
    }

    public String getApp_sign_date2() {
        return app_sign_date2.substring(0, 16);

    }

    public void setApp_sign_date2(String app_sign_date2) {
        this.app_sign_date2 = app_sign_date2;
    }

    public String getApp_sign_date3() {
        return app_sign_date3.substring(0, 16);

    }

    public void setApp_sign_date3(String app_sign_date3) {
        this.app_sign_date3 = app_sign_date3;
    }

    public String getApp_status_check() {
        return app_status_check;
    }

    public void setApp_status_check(String app_status_check) {
        this.app_status_check = app_status_check;
    }

    public String getApp_status1() {
        return app_status1;
    }

    public void setApp_status1(String app_status1) {
        this.app_status1 = app_status1;
    }

    public String getApp_status2() {
        return app_status2;
    }

    public void setApp_status2(String app_status2) {
        this.app_status2 = app_status2;
    }

    public String getApp_status3() {
        return app_status3;
    }

    public void setApp_status3(String app_status3) {
        this.app_status3 = app_status3;
    }

    public String getApp_writer_name() {
        return app_writer_name;
    }

    public void setApp_writer_name(String app_writer_name) {
        this.app_writer_name = app_writer_name;
    }

    public String getApp_writer_position() {
        return app_writer_position;
    }

    public void setApp_writer_position(String app_writer_position) {
        this.app_writer_position = app_writer_position;
    }

    public int getApp_writer_depid() {
        return app_writer_depid;
    }

    public void setApp_writer_depid(int app_writer_depid) {
        this.app_writer_depid = app_writer_depid;
    }

    public String getApp_writer_depname() {
        return app_writer_depname;
    }

    public void setApp_writer_depname(String app_writer_depname) {
        this.app_writer_depname = app_writer_depname;
    }

    @Override
    public String toString() {
        return "ApprovalDto{" +
                "app_doc_num=" + app_doc_num +
                ", app_type='" + app_type + '\'' +
                ", app_doc_title='" + app_doc_title + '\'' +
                ", app_writer_id=" + app_writer_id +
                ", app_date=" + app_date +
                ", app_comment='" + app_comment + '\'' +
                ", app_ref_id1=" + app_ref_id1 +
                ", app_ref_id2=" + app_ref_id2 +
                ", app_ref_id3=" + app_ref_id3 +
                ", app_ref_file='" + app_ref_file + '\'' +
                ", app_content='" + app_content + '\'' +
                ", app_sign_id1=" + app_sign_id1 +
                ", app_sign_id2=" + app_sign_id2 +
                ", app_sign_id3=" + app_sign_id3 +
                ", app_sign_date1=" + app_sign_date1 +
                ", app_sign_date2=" + app_sign_date2 +
                ", app_sign_date3=" + app_sign_date3 +
                ", app_status_check='" + app_status_check + '\'' +
                ", app_status1='" + app_status1 + '\'' +
                ", app_status2='" + app_status2 + '\'' +
                ", app_status3='" + app_status3 + '\'' +
                ", app_writer_name='" + app_writer_name + '\'' +
                ", app_writer_position='" + app_writer_position + '\'' +
                ", app_writer_depid=" + app_writer_depid +
                ", app_writer_depname='" + app_writer_depname + '\'' +
                '}';
    }
}
