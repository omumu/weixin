package com.project.model;

public class school {
    private Integer schoolId;

    private String schooleName;

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchooleName() {
        return schooleName;
    }

    public void setSchooleName(String schooleName) {
        this.schooleName = schooleName == null ? null : schooleName.trim();
    }
}