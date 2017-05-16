package com.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.project.model.user;
import com.project.service.bannerServiceInterface;
import com.project.service.userServiceInterface;
import com.project.util.jsonutil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/21.
 */
@Controller
@RequestMapping("/user")
public class userController {
    private static final int pagesize=10;
    private final static Log logger = LogFactory.getLog(bannerController.class);
    @Autowired
    private userServiceInterface userServiceInterface;
    @Autowired
    private com.project.util.jsonutil jsonutil;

    @RequestMapping("getUserMoney")
    @ResponseBody
    public JSONObject getUserMoney(HttpSession session){
        logger.info("project--------执行了/user/getUserMoney");
     user user=(user)session.getAttribute("user");
        try {
            String str =userServiceInterface.getMoney(user.getUserOpenid());
            return jsonutil.JSONRESPONSE(1,"获取成功",str);
        } catch (Exception e) {
            logger.error("/user/getUserMoney erro--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }


    }


    @RequestMapping("login")
    @ResponseBody
    public JSONObject login(HttpSession session,String name){
        logger.info("project--------执行了/user/login");
          session.setAttribute("loginsession",name);
        return jsonutil.JSONRESPONSE(1,"获取成功",null);
    }


    @RequestMapping("islogin")
    @ResponseBody
    public JSONObject islogin(HttpSession session){
        String name=(String)session.getAttribute("loginsession");
        if(name==null||"".equals(name)){
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        }else {

            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }

    }
    @RequestMapping("deleteNULL")
    @ResponseBody
    public JSONObject deleteNULL(){
      logger.info("user/deleteNULL");
        try {
            userServiceInterface.deletenull();
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            logger.error("/user/deleteNULL erro--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }

    }

    @RequestMapping("getUserList")
    @ResponseBody
    public JSONObject getUserList(int page){
        logger.info("user/getUserList");
        List list=new ArrayList();
        try {
            list=userServiceInterface.getUserList((page-1)*pagesize,pagesize);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            logger.error("/user/deleteNULL erro--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",1111);
        }

    }
    @RequestMapping("getUserCount")
    @ResponseBody
    public JSONObject getUserCount(){
        logger.info("user/getUserCount");
      int count=0;
        try {
           count= userServiceInterface.getUserCount();
            return jsonutil.JSONRESPONSE(1,"获取成功",count);
        } catch (Exception e) {
            logger.error("/user/getUserCount erro--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }

    }
    @RequestMapping("deleteUser")
    @ResponseBody
    public JSONObject deleteUser(int id){
        logger.info("user/deleteUser");
        try {
          userServiceInterface.deleteUser(id);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            logger.error("/user/deleteUser erro--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }

    }

    @RequestMapping("getUserById")
    @ResponseBody
    public JSONObject getUserById(int id){
        logger.info("user/getUserById");
        List list=new ArrayList();
        try {
           list= userServiceInterface.getUserById(id);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            logger.error("/user/getUserById erro--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }

    }


    @RequestMapping("updateUser")
    @ResponseBody
    public JSONObject updateUser(String money,int id){
        logger.info("user/updateUser");

        try {
            userServiceInterface.updateUser(money, id);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            logger.error("/user/getUserById erro--"+e);
            return jsonutil.JSONRESPONSE(0,"获取失败",null);
        }

    }

}
