package com.testtask.kb2fty7.testprojectpsyh.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

/**
 * Created by Yurii on 2/3/2016.
 */
@Table
public class Person{
    private long id;
    private String location;
    private String photo;
    private String status;
    private Integer userStatus;

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoto() {
        return photo;
    }

    public String getStatus() {
        return status;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
}
