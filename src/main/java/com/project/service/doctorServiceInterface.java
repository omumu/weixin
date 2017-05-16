package com.project.service;

import com.project.model.doctor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/16.
 */
public interface doctorServiceInterface {
    List<HashMap> getDocList(int regisId, String time);
    List<HashMap>getDoctorList(int page,int size);
    int getCount();
    int deleteDoc(int dId);
    List<HashMap> getdocById(int id);
    int updateByPrimaryKey(doctor doctor);
    int insert(doctor doctor);
}
