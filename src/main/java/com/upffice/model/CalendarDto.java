package com.upffice.model;

import javax.persistence.*;

@Entity
@Table(name = "calendar")
public class CalendarDto {
    /*
     * Calendar 테이블에 해당하는 Dto
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "calendar_id")
    private int calendar_id;

    @Column(name = "emp_id")
    private int emp_id;

    @Column(name = "calendar_name")
    private String calendar_name;

    @Column(name = "calendar_color")
    private String calendar_color;

    public CalendarDto() {
    }

    public CalendarDto(int emp_id, String calendar_name, String calendar_color) {
        this.emp_id = emp_id;
        this.calendar_name = calendar_name;
        this.calendar_color = calendar_color;
    }
    public int getCalendar_id() {
        return calendar_id;
    }

    public void setCalendar_id(int calendar_id) {
        this.calendar_id = calendar_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getCalendar_name() {
        return calendar_name;
    }

    public void setCalendar_name(String calendar_name) {
        this.calendar_name = calendar_name;
    }

    public String getCalendar_color() {
        return calendar_color;
    }

    public void setCalendar_color(String calendar_color) {
        this.calendar_color = calendar_color;
    }

    @Override
    public String toString() {
        return "CalendarDto{" +
                "calendar_id=" + calendar_id +
                ", emp_id=" + emp_id +
                ", calendar_name='" + calendar_name + '\'' +
                ", calendar_color='" + calendar_color + '\'' + '}';
    }
}
