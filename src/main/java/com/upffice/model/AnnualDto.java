package com.upffice.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "annual")
@IdClass(AnnualDtoPK.class)
public class AnnualDto {
    /*
     * Annual 테이블에 해당하는 Dto
     */

    @Id
    @Column(name = "emp_id")
    private int empId;

    @Id
    @Column(name = "annual_date")
    private Date annualDate;

    public AnnualDto() {
    }

    public AnnualDto(int empId, Date annualDate) {
        this.empId=empId;
        this.annualDate=annualDate;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getAnnualDate() {
        return annualDate;
    }

    public void setAnnualDate(Date annualDate) {
        this.annualDate = annualDate;
    }
}
