package com.xworkz.employee.dto;

import javax.persistence.*;

@Entity
@Table(name = "emp_table")
public class EmpDto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name = "age")
    private int age;
    @Column(name="ph_no")
    private String ph_no;

    public EmpDto()
    {

    }

    public EmpDto(String name, String email, int age, String ph_no) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.ph_no = ph_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
}
