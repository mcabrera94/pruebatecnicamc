package com.demo.pruebatecnicamc.be.repositories.mysql.entities;

import javax.persistence.*;

@Entity
@Table(name = "pt_users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PT_Id")
    private Integer id;

    @Column(name = "PT_Name")
    private String name;

    @Column(name = "PT_Username")
    private String userName;

    @Column(name = "PT_Email")
    private String email;

    @Column(name = "PT_Phone")
    private String phone;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
