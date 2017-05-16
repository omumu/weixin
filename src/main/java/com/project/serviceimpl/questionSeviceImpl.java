package com.project.serviceimpl;

import com.project.dao.questionMapper;
import com.project.model.question;
import com.project.service.questionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/17.
 */
@Service
public class questionSeviceImpl implements questionServiceInterface {
    @Autowired
    private questionMapper questionMapper;

    public List<HashMap> getQuestion() {
        return questionMapper.getQuestion();
    }

    public List<HashMap> getQuestionM(int page, int size) {
        return questionMapper.getQuestionM(page, size);
    }

    public int getQuestionCountM() {
        return questionMapper.getQuestionCountM();
    }

    public int deletequestion(int id) {
        return questionMapper.deletequestion(id);
    }

    public List<HashMap> getQuestionById(int id) {
        return questionMapper.getQuestionById(id);
    }

    public int insert(question record) {
        return questionMapper.insert(record);
    }

    public int updateByPrimaryKey(question record) {
        return questionMapper.updateByPrimaryKey(record);
    }


}
