package com.upffice.model;


import javax.persistence.*;

@Entity
@Table(name = "outaddress")
public class OutAddressDto {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int out_id;

    @Column(name = "out_name")
    private String outName;

    @Column(name = "out_mobile")
    private String out_mobile ;

    @Column(name = "out_email")
    private String out_email;

    @Column(name = "out_company")
    private String outCompany;

    @Column(name = "out_dep_phone")
    private String out_dep_phone ;


    public OutAddressDto() {
    }

    public OutAddressDto(int out_id, String out_name, String out_mobile, String out_email, String out_company, String out_dep_phone) {
        this.out_id = out_id;
        this.outName = out_name;
        this.out_mobile = out_mobile;
        this.out_email = out_email;
        this.outCompany = out_company;
        this.out_dep_phone = out_dep_phone;
    }


    public int getOut_id() {
        return out_id;
    }

    public void setOut_id(int out_id) {
        this.out_id = out_id;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String out_name) {
        this.outName = out_name;
    }

    public String getOut_mobile() {
        return out_mobile;
    }

    public void setOut_mobile(String out_mobile) {
        this.out_mobile = out_mobile;
    }

    public String getOut_email() {
        return out_email;
    }

    public void setOut_email(String out_email) {
        this.out_email = out_email;
    }

    public String getOutCompany() {
        return outCompany;
    }

    public void setOutCompany(String out_company) {
        this.outCompany = out_company;
    }

    public String getOut_dep_phone() {
        return out_dep_phone;
    }

    public void setOut_dep_phone(String out_dep_phone) {
        this.out_dep_phone = out_dep_phone;
    }

    @Override
    public String toString() {
        return "outaddress{" +
                "out_id=" + out_id +
                ", out_name='" + outName + '\'' +
                ", out_mobile='" + out_mobile + '\'' +
                ", out_email='" + out_email + '\'' +
                ", out_company='" + outCompany + '\'' +
                ", out_dep_phone='" + out_dep_phone + '\'' +
                '}';

    }
}
