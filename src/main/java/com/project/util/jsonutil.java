package com.project.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by 木木高 on 2017/3/27.
 */
@Service
public class jsonutil implements Serializable{

    public static JSONObject JSONRESPONSE(int code, String message, Object data){
        JSONObject jo=new JSONObject();
        jo.put("code",code);
        jo.put("message",message);
        jo.put("data",data);
        return jo;

    }
    public static JSONObject JSONRESPONSE(int code){
        JSONObject jo=new JSONObject();
        jo.put("code",code);
        return jo;

    }
    public static JSONObject JSONRESPONSE(int code, String message, Object data,int size){
        JSONObject jo=new JSONObject();
        jo.put("code",code);
        jo.put("message",message);
        jo.put("data",data);
        jo.put("size",size);
        return jo;

    }

}
