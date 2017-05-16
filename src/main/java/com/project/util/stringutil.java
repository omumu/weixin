package com.project.util;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 木木高 on 2017/3/27.
 */
@Service
public class stringutil {


    public static boolean isEmpty(String str){
        boolean flag=false;
        if("".equals(str)||str==null){
            flag=true;
        }
        if(!"".equals(str)&&str!=null){
            flag=false;
        }

return flag;

    }
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Long time=new Long(s);
        res = simpleDateFormat.format(time);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(stringutil.stampToDate("2017-04-13"));
    }

}
