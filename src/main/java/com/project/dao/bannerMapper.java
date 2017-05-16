package com.project.dao;

import com.project.model.banner;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface bannerMapper {
    int deleteByPrimaryKey(Integer bannerId);

    int insert(banner record);

    int insertSelective(banner record);

    banner selectByPrimaryKey(Integer bannerId);

    int updateByPrimaryKeySelective(banner record);

    int updateByPrimaryKey(banner record);
    String getbannerurl(int schooleId);
    List<HashMap> getBanner(int page,int size);
    int getBannerCount();
    List<HashMap> getbannerById(int id);
    int updateBanner(String name,String url,int id);
    int addschool(String schoolName,String schoolUrl);
}