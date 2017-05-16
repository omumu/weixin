package com.project.dao;

import com.project.model.school;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface schoolMapper {
    int deleteByPrimaryKey(Integer schoolId);

    int insert(school record);

    int insertSelective(school record);

    school selectByPrimaryKey(Integer schoolId);

    int updateByPrimaryKeySelective(school record);

    int updateByPrimaryKey(school record);
    List<HashMap> getSchool();
    void insertschool(int sid,String uid);
    String getSchoolName(int SchoolId);
}