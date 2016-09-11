package com.calldrink.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by silvionetto on 8/28/16.
 */
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String create() {
        return "user";
    }

    public String save() {
        return "user";
    }

    public String login() {
        if (getEmail().equals("silvio.netto@gmail.com")) {
            return "home";
        }
        return "login";
    }
}
