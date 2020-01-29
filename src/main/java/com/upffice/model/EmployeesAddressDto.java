package com.upffice.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employees")
public class EmployeesAddressDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;

    @Column(name = "emp_pw")
    private String emp_pw;

    @Column(name = "emp_name")
    private String name ;

    @Column(name = "emp_email")
    private String emp_email;

    @Column(name = "position")
    private String position;

    @Column(name = "hire_date")
    private Date hire_date ;

    @Column(name = "extension_number")
    private String extension_number ;

    @Column(name = "phone_number")
    private String phone_number ;

    @Column(name = "dep_id")
    private int dep_id ;


    public EmployeesAddressDto() {
    }

    public EmployeesAddressDto(int emp_id, String emp_pw, String emp_name, String emp_email, String position, Date hire_date, String extension_number, String phone_number, int dep_id) {
        this.emp_id = emp_id;
        this.emp_pw = emp_pw;
        this.name = emp_name;
        this.emp_email = emp_email;
        this.position = position;
        this.hire_date = hire_date;
        this.extension_number = extension_number;
        this.phone_number = phone_number;
        this.dep_id = dep_id;
    }


    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_pw() {
        return emp_pw;
    }

    public void setEmp_pw(String emp_pw) {
        this.emp_pw = emp_pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String emp_name) {
        this.name = emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getExtension_number() {
        return extension_number;
    }

    public void setExtension_number(String extension_number) {
        this.extension_number = extension_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "emp_id=" + emp_id +
                ", emp_pw='" + emp_pw + '\'' +
                ", emp_name='" + name + '\'' +
                ", emp_email='" + emp_email + '\'' +
                ", position='" + position + '\'' +
                ", hire_date=" + hire_date +
                ", extension_number='" + extension_number + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", dep_id='" + dep_id + '\'' +
                '}';
    }

}
