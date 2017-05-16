package com.project.serviceimpl;

import com.project.dao.doctorMapper;
import com.project.model.doctor;
import com.project.service.doctorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/16.
 */
@Service
public class doctorServiceImpl implements doctorServiceInterface {
    @Autowired
    private doctorMapper doctorMapper;
    public List<HashMap> getDocList(int regisId, String time) {
        return doctorMapper.getDocList(regisId,time);
    }

    public List<HashMap> getDoctorList(int page, int size) {
        return doctorMapper.getDoctorList(page, size);
    }


    public int getCount() {
        return doctorMapper.getCount();
    }

    public int deleteDoc(int dId) {
        return doctorMapper.deleteDoc(dId);
    }

    public List<HashMap> getdocById(int id) {
        return doctorMapper.getdocById(id);
    }

    public int updateByPrimaryKey(doctor doctor) {
        return doctorMapper.updateByPrimaryKey(doctor);
    }

    public int insert(doctor doctor) {
        return doctorMapper.insert(doctor);
    }
}
