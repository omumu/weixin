package com.project.model;

import java.util.Date;

public class doctor {
    private Integer doctorId;

    private String doctorName;

    private Integer doctorLevel;

    private Integer doctorSex;

    private Long doctorPrice;

    private Date dacotorData;

    private String doctorPhoto;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public Integer getDoctorLevel() {
        return doctorLevel;
    }

    public void setDoctorLevel(Integer doctorLevel) {
        this.doctorLevel = doctorLevel;
    }

    public Integer getDoctorSex() {
        return doctorSex;
    }

    public void setDoctorSex(Integer doctorSex) {
        this.doctorSex = doctorSex;
    }

    public Long getDoctorPrice() {
        return doctorPrice;
    }

    public void setDoctorPrice(Long doctorPrice) {
        this.doctorPrice = doctorPrice;
    }

    public Date getDacotorData() {
        return dacotorData;
    }

    public void setDacotorData(Date dacotorData) {
        this.dacotorData = dacotorData;
    }

    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto == null ? null : doctorPhoto.trim();
    }
}