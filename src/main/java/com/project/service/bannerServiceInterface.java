package com.project.service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/2.
 */
public interface bannerServiceInterface {
    String getbannerurl(int schooleId);
    List<HashMap> getBanner(int page,int size);
    int getBannerCount();
    int deleteByPrimaryKey(Integer bannerId);
    List<HashMap> getbannerById(int id);
    int updateBanner(String name,String url,int id);
    int addschool(String schoolName,String schoolUrl);

}
