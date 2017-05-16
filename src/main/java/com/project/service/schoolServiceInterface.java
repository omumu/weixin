package com.project.service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/17.
 */
public interface schoolServiceInterface {
    List<HashMap> getSchool();
    void insertschool(int sid,String uid);
    String getSchoolName(int SchoolId);
}
