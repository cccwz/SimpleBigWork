package com.chen.bigwork.service;

import com.chen.bigwork.dao.LocationMapper;
import com.chen.bigwork.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private  LocationMapper locationMapper;

    public List<Location> selectLocationByPlace(String province, String city, String county){
        return locationMapper.findLocationByPlace(province,city,county);
    }

    public int insertLocation(Location location){
        return locationMapper.insertLocation(location);
    }

    public Location selectLocationByProjectName(String projectName){
        return locationMapper.selectLocationByProjectName(projectName);
    }

    public int updateLocation(Location location){
        return locationMapper.updateLocation(location);
    }

    public Location selectLocationById(int id){
        return locationMapper.selectLocationById(id);
    }

    public Location selectLocationbyProjectNameExceptId(String projectName,int id){
        return locationMapper.selectLocationbyProjectNameExceptId(projectName,id);
    }

    public int deleteLocationById(int id){
        return locationMapper.deleteLocationById(id);
    }
}
