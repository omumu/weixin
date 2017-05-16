package com.project.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSONObject;
import com.project.model.question;
import com.project.service.questionServiceInterface;
import com.project.service.schoolServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/17.
 */
@Controller
@RequestMapping("/question")
public class questionCotroller {
    private static final int pagesize=10;
    private final static Log logger = LogFactory.getLog(regisController.class);
    @Autowired
    private questionServiceInterface questionServiceInterface;
    @Autowired
    private com.project.util.jsonutil jsonutil;

    @RequestMapping("getQuestionList")
    @ResponseBody
    public JSONObject getSchoolList() {
        logger.info("project--------执行了/question/getQuestionList");
        List list=new ArrayList();
        try {
            list=questionServiceInterface.getQuestion();
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/question/getQuestionList----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("getQuestionListM")
    @ResponseBody
    public JSONObject getQuestionListM(int page) {
        logger.info("project--------执行了/question/getQuestionListM");
        List list=new ArrayList();
        try {
            list=questionServiceInterface.getQuestionM((page-1)*pagesize,pagesize);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/question/getQuestionListM----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("getQuestionCount")
    @ResponseBody
    public JSONObject getQuestionCount() {
        logger.info("project--------执行了/question/getQuestionCount");
       int count=0;
        try {
           count=questionServiceInterface.getQuestionCountM();
            return jsonutil.JSONRESPONSE(1,"获取成功",count);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/question/getQuestionCount----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }


    @RequestMapping("deletequestion")
    @ResponseBody
    public JSONObject deletequestion(int id) {
        logger.info("project--------执行了/question/deletequestion");

        try {
           questionServiceInterface.deletequestion(id);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/question/deletequestion----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("getquestionById")
    @ResponseBody
    public JSONObject getquestionById(int id) {
        logger.info("project--------执行了/question/getquestionById");
List list=new ArrayList();
        try {
            list=questionServiceInterface.getQuestionById(id);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/question/getquestionById----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }


    @RequestMapping("addquestion")
    @ResponseBody
    public JSONObject addquestion(String title,String answer,int status) {
        logger.info("project--------执行了/question/addquestion");
        question q=new question();
        q.setAnswer(answer);
        q.setQuestion(title);
        q.setStatusint(status);
        try {
           questionServiceInterface.insert(q);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/question/addquestion----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }


    @RequestMapping("updatequestion")
    @ResponseBody
    public JSONObject updatequestion(String title,String answer,int status,int id) {
        logger.info("project--------执行了/question/updatequestion");
        question q=new question();
        q.setAnswer(answer);
        q.setQuestion(title);
        q.setStatusint(status);
        q.setId(id);
        try {
            questionServiceInterface.updateByPrimaryKey(q);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/question/updatequestion----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }
}
