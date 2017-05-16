package com.project.serviceimpl;

import com.project.dao.schoolMapper;
import com.project.service.schoolServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/17.
 */
@Service
public class schoolServiceImpl implements schoolServiceInterface {
    @Autowired
    private schoolMapper schoolMapper;
    public List<HashMap> getSchool() {
        return schoolMapper.getSchool();
    }

    public void insertschool(int sid, String uid) {
        schoolMapper.insertschool(sid, uid);
    }

    public String getSchoolName(int SchoolId) {
        return schoolMapper.getSchoolName(SchoolId);
    }
}
