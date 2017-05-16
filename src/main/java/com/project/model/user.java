package com.project.model;

import java.util.Date;

public class user {
    private Integer userId;

    private String userName;

    private String userSex;

    private String userOpenid;

    private String userHeadimgurl;

    private Date userRegistertime;

    private Integer userMoney;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid == null ? null : userOpenid.trim();
    }

    public String getUserHeadimgurl() {
        return userHeadimgurl;
    }

    public void setUserHeadimgurl(String userHeadimgurl) {
        this.userHeadimgurl = userHeadimgurl == null ? null : userHeadimgurl.trim();
    }

    public Date getUserRegistertime() {
        return userRegistertime;
    }

    public void setUserRegistertime(Date userRegistertime) {
        this.userRegistertime = userRegistertime;
    }

    public Integer getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Integer userMoney) {
        this.userMoney = userMoney;
    }
}