package com.xworkz.student.dto;

import javax.persistence.*;

@Entity
@Table(name = "student_table")
public class StudentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "branch")
    private String branch;

    public StudentDto( String name, String branch) {
        this.name = name;
        this.branch = branch;
    }

    public StudentDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
