package com.chen.bigwork.dao;

import com.chen.bigwork.entities.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationMapper {
    List<Location> findLocationByPlace(String province, String city, String county);

    int insertLocation(Location location);

    Location selectLocationByProjectName(String projectName);

    int updateLocation(Location location);

    Location selectLocationById(int id);

    Location selectLocationbyProjectNameExceptId(String projectName,int id);

    int updateLocationProjectName(int id,String projectName);

    int deleteLocationById(int id);
}
