package com.xworkz.queriesinjpa.entities;

import lombok.*;

import javax.persistence.*;



@Entity
@Table(name = "institute_table")
@NamedQuery(name = "salAndEmailByOfficeNO",query = "select ei.salary,ei.email from InstituteEntity ei where ei.name=: Name")
@NamedQuery(name = "displayAllInfo",query = "Select ie from InstituteEntity ie")
@NamedQuery(name = "findByProfId", query = "select ie from InstituteEntity ie where ie.professorId = :prof_id")
@NamedQuery(name="findEmailByName", query = "select ie.email from InstituteEntity ie where ie.name= :getName")
@NamedQuery(name = "findSalById",query = "Select ei.salary from InstituteEntity ei where ei.id= :id")
@NamedQuery(name = "officeAndDepart", query = "SELECT ei.department, ei.officeNo FROM InstituteEntity ei WHERE ei.name = :sirName")
public class InstituteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "prof_id")
    private int professorId;

    private String name;

    private String email;

    private String department;

    @Column(name = "office_no")
    private double officeNo;

    @Setter
    private double salary;

    public InstituteEntity()
    {

    }

    public InstituteEntity(int professorId, String name, String email, String department, double officeNo, double salary) {
        this.professorId = professorId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.officeNo = officeNo;
        this.salary = salary;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(double officeNo) {
        this.officeNo = officeNo;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "InstituteEntity{" +
                "id=" + id +
                ", professorId=" + professorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", officeNo=" + officeNo +
                ", salary=" + salary +
                '}';
    }
}
