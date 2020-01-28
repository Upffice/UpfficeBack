package com.upffice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.upffice.controller.SqlTimeDeserializer;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "schedule")
public class ScheduleDto {
    /*
     * Schedule 테이블에 해당하는 Dto
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sche_id")
    private int sche_id;

    @Column(name = "sche_name")
    private String sche_name;

    @Column(name = "sche_start_date")
    private Date sche_start_date;

    @JsonFormat(pattern = "HH:mm")
    @JsonDeserialize(using = SqlTimeDeserializer.class)
    @Column(name = "sche_start_time")
    private Time sche_start_time;

    @Column(name = "sche_end_date")
    private Date sche_end_date;

    @JsonFormat(pattern = "HH:mm")
    @JsonDeserialize(using = SqlTimeDeserializer.class)
    @Column(name = "sche_end_time")
    private Time sche_end_time;

    @Column(name = "sche_place")
    private String sche_place;

    @Column(name = "sche_detail")
    private String sche_detail;

    @Column(name = "emp_id")
    private int emp_id;

    @Column(name = "calendar_id")
    private int calendar_id;

    public ScheduleDto() {
    }

    public ScheduleDto(int emp_id, int calendar_id, String sche_name, Date sche_start_date, Time sche_start_time, Date sche_end_date, Time sche_end_time, String sche_place, String sche_detail) {
        this.emp_id = emp_id;
        this.calendar_id = calendar_id;
        this.sche_name = sche_name;
        this.sche_start_date = sche_start_date;
        this.sche_start_time = sche_start_time;
        this.sche_end_date = sche_end_date;
        this.sche_end_time = sche_end_time;
        this.sche_place = sche_place;
        this.sche_detail = sche_detail;
    }

    public int getSche_id() {
        return sche_id;
    }

    public void setSche_id(int sche_id) {
        this.sche_id = sche_id;
    }

    public String getSche_name() {
        return sche_name;
    }

    public void setSche_name(String sche_name) {
        this.sche_name = sche_name;
    }

    public Date getSche_start_date() {
        return sche_start_date;
    }

    public void setSche_start_date(Date sche_start_date) {
        this.sche_start_date = sche_start_date;
    }

    public Time getSche_start_time() {
        return sche_start_time;
    }

    public void setSche_start_time(Time sche_start_time) {
        this.sche_start_time = sche_start_time;
    }

    public Date getSche_end_date() {
        return sche_end_date;
    }

    public void setSche_end_date(Date sche_end_date) {
        this.sche_end_date = sche_end_date;
    }

    public Time getSche_end_time() {
        return sche_end_time;
    }

    public void setSche_end_time(Time sche_end_time) {
        this.sche_end_time = sche_end_time;
    }

    public String getSche_place() {
        return sche_place;
    }

    public void setSche_place(String sche_place) {
        this.sche_place = sche_place;
    }

    public String getSche_detail() {
        return sche_detail;
    }

    public void setSche_detail(String sche_detail) {
        this.sche_detail = sche_detail;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getCalendar_id() {
        return calendar_id;
    }

    public void setCalendar_id(int calendar_id) {
        this.calendar_id = calendar_id;
    }

    @Override
    public String toString() {
        return "ScheduleDto{" +
                "sche_id=" + sche_id +
                ", sche_name='" + sche_name + '\'' +
                ", sche_start_date=" + sche_start_date +
                ", sche_start_time=" + sche_start_time +
                ", sche_end_date=" + sche_end_date +
                ", sche_end_time=" + sche_end_time +
                ", sche_place='" + sche_place + '\'' +
                ", sche_detail='" + sche_detail + '\'' +
                ", emp_id=" + emp_id +
                ", calendar_id=" + calendar_id +
                '}';
    }
}
