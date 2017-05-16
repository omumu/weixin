package com.project.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSONObject;
import com.project.service.regisServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.util.jsonutil;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/13.
 */
@Controller
@RequestMapping("/regis")
public class regisController {
    private final static Log logger = LogFactory.getLog(regisController.class);
    @Autowired
    private regisServiceInterface regisServiceInterface;
    @Autowired
    private jsonutil jsonutil;

    @RequestMapping("getreGisList")
    @ResponseBody
    public JSONObject getreGisList() {
        logger.info("project--------执行了/regis/getreGisList");
        List list=new ArrayList();
        try {
            list=regisServiceInterface.getreGisList();
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/getreGisList----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

}




    @RequestMapping("serchRegis")
    @ResponseBody
    public JSONObject serchRegis(String regisname) {
        logger.info("project--------执行了/regis/serchRegis");
        List list=new ArrayList();
        try {
            list=regisServiceInterface.serchRegis(regisname);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/serchRegis----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("getRegisCount")
    @ResponseBody
    public JSONObject getRegisCount() {
        logger.info("project--------执行了/regis/getRegisCount");
        int count;
        try {
            count=regisServiceInterface.getRegisCount();
            return jsonutil.JSONRESPONSE(1,"获取成功",count);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/getRegisCount----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("getRegisdes")
    @ResponseBody
    public ModelAndView getRegisdes(int id,ModelAndView mv) {
        logger.info("project--------执行了/regis/getRegisdes");
        try {
            mv.addObject("ids",id);
            mv.setViewName("second");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/getRegisdes----" + e);
        }
         return null;

    }

    @RequestMapping("getCurrent")
    @ResponseBody
    public ModelAndView getCurrent(int id,int regisId,String time,ModelAndView mv) {
        logger.info("project--------执行了/regis/getCurrent");
        List<HashMap> list=new ArrayList();
 try {
            list=regisServiceInterface.getDocmessage(id);
            String regisName=regisServiceInterface.getRegisName(regisId);
            mv.addObject("regisName",regisName);
            mv.addObject("time",time);
           mv.addObject("doctor_name",list.get(0).get("doctor_name"));
            mv.addObject("doctor_price",list.get(0).get("doctor_price"));
     if(Integer.parseInt(list.get(0).get("doctor_level").toString())==0){
             mv.addObject("doctor_level","普通");}else{ mv.addObject("doctor_level","专家");}



            mv.setViewName("third");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/getCurrent----" + e);
        }
        return null;

    }

    @RequestMapping("getreGisListM")
    @ResponseBody
    public JSONObject getreGisListM(int page) {
        logger.info("project--------执行了/regis/getreGisListM");
        List list=new ArrayList();
        try {
            list=regisServiceInterface.getreGisListM((page-1)*10,10);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/getreGisListM----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }
    @RequestMapping("getRegisCountM")
    @ResponseBody
    public JSONObject getRegisCountM() {
        logger.info("project--------执行了/regis/getRegisCountM");
        int count;
        try {
            count=regisServiceInterface.getRegisCountM();
            return jsonutil.JSONRESPONSE(1,"获取成功",count);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/getRegisCountM----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }
    @RequestMapping("deleteRegis")
    @ResponseBody
    public JSONObject deleteRegis(int id) {
        logger.info("project--------执行了/regis/deleteRegis");

        try {
            regisServiceInterface.deleteById(id);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/deleteRegis----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }

    @RequestMapping("getRegisById")
    @ResponseBody
    public JSONObject getRegisById(Integer id) {
        logger.info("project--------执行了/regis/getRegisById");
       List list=new ArrayList();
        try {
            list= regisServiceInterface.getlistById(id);
            return jsonutil.JSONRESPONSE(1,"获取成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/getRegisById----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }


    @RequestMapping("updateRegisById")
    @ResponseBody
    public JSONObject updateRegisById(String name, int status, int id) {
        logger.info("project--------执行了/regis/updateRegisById");

        try {
           regisServiceInterface.updateById(name, status, id);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/updateRegisById----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }


    @RequestMapping("insertRegis")
    @ResponseBody
    public JSONObject insertRegis(String name, int status) {
        logger.info("project--------执行了/regis/insertRegis");

        try {
            regisServiceInterface.insert(name, status);
            return jsonutil.JSONRESPONSE(1,"获取成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("project---执行了/regis/insertRegis----"+e);
        }
        return jsonutil.JSONRESPONSE(0,"获取失败",null);

    }


}
