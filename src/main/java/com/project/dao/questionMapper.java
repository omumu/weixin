package com.project.dao;

import com.project.model.question;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface questionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(question record);

    int insertSelective(question record);

    question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(question record);

    int updateByPrimaryKey(question record);
    List<HashMap> getQuestion();
    List<HashMap> getQuestionM(int page,int size);
    int getQuestionCountM();
    int deletequestion(int id);
    List<HashMap> getQuestionById(int id);
}