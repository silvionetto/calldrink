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

    @Column(nullable = false)
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getId();
        result = prime * result + getVersion();
        result = prime * result + ((getEntered_date() == null) ? 0 : getEntered_date().hashCode());
        result = prime * result + ((getUpdated_date() == null) ? 0 : getUpdated_date().hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        User other = (User) obj;

        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;

        if (getVersion() == null) {
            if (other.getVersion() != null)
                return false;
        } else if (!getVersion().equals(other.getVersion()))
            return false;

        if (getEntered_date() == null) {
            if (other.getEntered_date() != null)
                return false;
        } else if (!getEntered_date().equals(other.getEntered_date()))
            return false;

        if (getUpdated_date() == null) {
            if (other.getUpdated_date() != null)
                return false;
        } else if (!getUpdated_date().equals(other.getUpdated_date()))
            return false;

        if (name == null) {
            if (other.getName() != null)
                return false;
        } else if (!name.equals(other.getName()))
            return false;

        if (email == null) {
            if (other.getEmail() != null)
                return false;
        } else if (!email.equals(other.getEmail()))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
