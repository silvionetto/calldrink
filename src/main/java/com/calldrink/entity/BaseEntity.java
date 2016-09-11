package com.calldrink.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by silvionetto on 9/11/16.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar entered_date;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updated_date;

    @Version
    private Integer version;

    public BaseEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getEntered_date() {
        return entered_date;
    }

    public void setEntered_date(Calendar entered_date) {
        this.entered_date = entered_date;
    }

    public Calendar getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Calendar updated_date) {
        this.updated_date = updated_date;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
