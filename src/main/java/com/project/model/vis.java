package com.project.model;

import java.util.Date;

public class vis {
    private Integer visId;

    private String visName;

    private Date visData;

    private String visPhone;

    private String regisName;

    private Integer visStatus;

    public Integer getVisId() {
        return visId;
    }

    public void setVisId(Integer visId) {
        this.visId = visId;
    }

    public String getVisName() {
        return visName;
    }

    public void setVisName(String visName) {
        this.visName = visName == null ? null : visName.trim();
    }

    public Date getVisData() {
        return visData;
    }

    public void setVisData(Date visData) {
        this.visData = visData;
    }

    public String getVisPhone() {
        return visPhone;
    }

    public void setVisPhone(String visPhone) {
        this.visPhone = visPhone == null ? null : visPhone.trim();
    }

    public String getRegisName() {
        return regisName;
    }

    public void setRegisName(String regisName) {
        this.regisName = regisName == null ? null : regisName.trim();
    }

    public Integer getVisStatus() {
        return visStatus;
    }

    public void setVisStatus(Integer visStatus) {
        this.visStatus = visStatus;
    }
}