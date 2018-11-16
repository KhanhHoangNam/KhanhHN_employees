package com.codegym.employee.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String fullname;
    private String group_employee;
    private String email;
    private int phone_number;
    private int identity_employee;
    private String sex;

    public Employee() {
    }

    public Employee(String fullname, String group_employee, String email, int phone_number, int identity_employee, String sex) {
        this.fullname = fullname;
        this.group_employee = group_employee;
        this.email = email;
        this.phone_number = phone_number;
        this.identity_employee = identity_employee;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGroup_employee() {
        return group_employee;
    }

    public void setGroup_employee(String group_employee) {
        this.group_employee = group_employee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getIdentity_employee() {
        return identity_employee;
    }

    public void setIdentity_employee(int identity_employee) {
        this.identity_employee = identity_employee;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
