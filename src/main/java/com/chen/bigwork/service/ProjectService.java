package com.chen.bigwork.service;

import com.chen.bigwork.dao.ProjectMapper;
import com.chen.bigwork.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    public Project findProjectByName(String name){
        return projectMapper.findProjectByName(name);
    }

    public int insertProject(Project project){
        return projectMapper.insertProject(project);
    }

    public Project findProjectById(int id){
        return projectMapper.selectProjectById(id);
    }

    public Project findProjectByNameExceptId(String name,int id){
        return projectMapper.selectProjectByNameExceptId(name,id);
    }

    public int updateProject(Project project){
        return projectMapper.updateProject(project);
    }

    public int deleteProjectById(int id){
        return projectMapper.deleteProjectById(id);
    }
}
