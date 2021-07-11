package com.chen.bigwork.dao;

import com.chen.bigwork.entities.Project;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper {
    Project findProjectByName(String name);

    int insertProject(Project project);

    Project selectProjectById(int id);

    Project selectProjectByNameExceptId(String name,int id);

    int updateProject(Project project);

    int deleteProjectById(int id);
}
