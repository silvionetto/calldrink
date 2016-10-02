package com.calldrink.bean;

import com.calldrink.entity.User;
import com.calldrink.facade.AppFacade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by silvionetto on 8/28/16.
 */
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {

    private final AppFacade facade;

    private String name;
    private String email;
    private String password;
    private String confirmPassword;

    public UserBean() {
        this.facade = AppFacade.getSessionFacade();
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
        FacesContext context = FacesContext.getCurrentInstance();

        String page = "user";
        if (!getPassword().equals(getConfirmPassword())) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please confirm the password!", ""));
        } else {
            User user = new User();
            user.setName(getName());
            user.setEmail(getEmail());
            user.setPassword(getPassword());
            facade.saveUser(user);

            page = "userSel";
        }
        return page;
    }

    public String save() {
        return "user";
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();

        User user = new User();
        user.setEmail(getEmail());
        user.setPassword(getPassword());

        if (facade.login(user)) {
            return "home";
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong user or password!", ""));
        }

        return "login";
    }
}
