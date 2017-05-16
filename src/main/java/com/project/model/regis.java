package com.project.model;

public class regis {
    private Integer regisId;

    private String regisName;

    public Integer getRegisId() {
        return regisId;
    }

    public void setRegisId(Integer regisId) {
        this.regisId = regisId;
    }

    public String getRegisName() {
        return regisName;
    }

    public void setRegisName(String regisName) {
        this.regisName = regisName == null ? null : regisName.trim();
    }
}