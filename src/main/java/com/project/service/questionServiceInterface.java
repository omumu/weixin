package com.project.service;

import com.project.model.question;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/17.
 */
public interface questionServiceInterface {
    List<HashMap> getQuestion();
    List<HashMap> getQuestionM(int page,int size);
    int getQuestionCountM();
    int deletequestion(int id);
    List<HashMap> getQuestionById(int id);
    int insert(question record);
    int updateByPrimaryKey(question record);
}
