package com.calldrink.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by silvionetto on 8/28/16.
 */
@Entity
@Table(name = "entity")
public class User extends BaseEntity {

    private String name;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 25, nullable = false)
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
