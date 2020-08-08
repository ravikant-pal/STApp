package com.alok.entities;


import org.apache.tapestry5.beaneditor.NonVisual;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "emp_table")
@SequenceGenerator(name="emp_table_seq",sequenceName = "emp_table_seq",allocationSize = 1)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="emp_table_seq" )
//    @Column(name = "id")
    @NonVisual
    private Long id;

//    @Column(name = "first_name")
    private String firstName;

//    @Column(name = "last_name")
    private String lastName;

//    @Column(name = "email")
    private String email;

//    @Column(name = "password")
    private String password;

//    @Column(name = "image")
    private String image;

//    @Column(name = "age")
    private int age;

//    @Column(name = "address")
    private String address;

//    @Column(name = "dob")
    private Date dob;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String password, String image, int age, String address, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.image = image;
        this.age = age;
        this.address = address;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                '}';
    }
}
