package com.upffice.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "working")
@IdClass(WorkingDtoPK.class)
public class WorkingDto {
    /*
     * working 테이블에 해당하는 Dto
     */

    @Id
    @Column(name = "emp_id")
    private int empId;

    @Id
    @Column(name = "working_date")
    private Date workingDate;

    @Column(name = "working_in")
    private Time workingIn;

    @Column(name = "working_out")
    private Time workingOut;

    @Column(name = "working_time")
    private String workingTime;

    public WorkingDto() {
    }

    public WorkingDto(int empId, Date workingDate, Time workingIn) {
        this.empId=empId;
        this.workingDate=workingDate;
        this.workingIn=workingIn;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(Date workingDate) {
        this.workingDate = workingDate;
    }

    public Time getWorkingIn() {
        return workingIn;
    }

    public void setWorkingIn(Time workingIn) {
        this.workingIn = workingIn;
    }

    public Time getWorkingOut() {
        return workingOut;
    }

    public void setWorkingOut(Time workingOut) {
        this.workingOut = workingOut;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }
}
