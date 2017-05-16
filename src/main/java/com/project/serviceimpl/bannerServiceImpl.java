package com.project.serviceimpl;

import com.project.service.bannerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dao.bannerMapper;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 木木高 on 2017/4/2.
 */
@Service
public class bannerServiceImpl implements bannerServiceInterface {
    @Autowired
    private bannerMapper bannerMapper;

    public String getbannerurl(int schooleId) {
        return bannerMapper.getbannerurl(schooleId);
    }

    public List<HashMap> getBanner(int page, int size) {
        return bannerMapper.getBanner(page, size);
    }

    public int getBannerCount() {
        return bannerMapper.getBannerCount();
    }

    public int deleteByPrimaryKey(Integer bannerId) {
        return bannerMapper.deleteByPrimaryKey(bannerId);
    }

    public List<HashMap> getbannerById(int id) {
        return bannerMapper.getbannerById(id);
    }

    public int updateBanner(String name,String url, int id) {
        return bannerMapper.updateBanner(name, url, id);
    }

    public int addschool(String schoolName, String schoolUrl) {
        return bannerMapper.addschool(schoolName, schoolUrl);
    }


}
