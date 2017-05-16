package com.project.dao;

import com.project.model.doctor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface doctorMapper {
    int deleteByPrimaryKey(Integer doctorId);



    int insertSelective(doctor record);

    doctor selectByPrimaryKey(Integer doctorId);

    int updateByPrimaryKeySelective(doctor record);

    List<HashMap> getDocList(int regisId,String time);
    List<HashMap>getDoctorList(int page,int size);
    int getCount();
    int deleteDoc(int dId);
    List<HashMap> getdocById(int id);
   int updateByPrimaryKey(doctor doctor);
    int insert(doctor doctor);
}