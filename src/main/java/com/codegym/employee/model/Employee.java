package com.codegym.employee.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
@Component
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String fullName;
    private String group_employee;

    @Email(message = "Email not valid")
    @NotBlank(message = "Email not blank")
    private String email;

    @NotEmpty
    @Size(min = 9, max = 10)
    private String phone_number;
    private int identity_employee;
    private String sex;

    public Employee() {
    }

    public Employee(String fullName, String group_employee, String email,@Size(min = 9, max = 10) String phone_number, int identity_employee, String sex) {
        this.fullName = fullName;
        this.group_employee = group_employee;
        this.email = email;
        this.phone_number = phone_number;
        this.identity_employee = identity_employee;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
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
