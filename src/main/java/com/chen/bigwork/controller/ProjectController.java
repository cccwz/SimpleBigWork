package com.chen.bigwork.controller;

import com.chen.bigwork.dao.ProjectMapper;
import com.chen.bigwork.entities.Project;
import com.chen.bigwork.service.ProjectService;
import com.chen.bigwork.util.String2DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import sun.util.calendar.LocalGregorianCalendar;

import javax.jws.WebParam;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/getProjectInfo/{name}")
    public String getProjectInfo(@PathVariable("name")String name, Model model){
        Project project = projectService.findProjectByName(name);
        if (project==null){
            model.addAttribute("project",null);
        }
        model.addAttribute("project",project);
        return "/projectInfo";
    }

    @GetMapping(value = "/addProject")
    public String getAddProjectPage(){
        return "/addProject";
    }

    @PostMapping(value = "/addProject")
    public String addProject(Model model,@RequestParam("name")String name,@RequestParam("type")String type,
                             @RequestParam("stage")String stage,@RequestParam("organizationLight")String organizationLight,
                             @RequestParam("organizationPressure")String organizationPressure,@RequestParam("date")String date
                             )  {
        Date date1;
        try {
            date1 = String2DateUtil.string2Date(date);
        } catch (ParseException e) {
            model.addAttribute("msg","请输入时间");
            return "/addProject";
        }
        if (StringUtils.isBlank(name)){
            model.addAttribute("msg","项目名不能为空");
            return "/addProject";
        }
        if(projectService.findProjectByName(name)!=null){
            model.addAttribute("msg","此项目以经存在");
            return "/addProject";
        }
        Project project=new Project();
        project.setName(name);
        project.setType(type);
        project.setStage(stage);
        project.setOrganizationLight(organizationLight);
        project.setOrganizationPressure(organizationPressure);
        project.setDate(date1);
        int row = projectService.insertProject(project);

        model.addAttribute("msg","插入成功");
        return "/addProject";

    }

    @GetMapping(value = "/updateProject/{projectId}")
    public String updateProject(Model model,@PathVariable("projectId")int projectId){
        Project project = projectService.findProjectById(projectId);
        model.addAttribute("project",project);
        return "/updateProject";
    }

    @PostMapping(value = "/updateProject")
    public String updateProject(RedirectAttributesModelMap model,@RequestParam("id")Integer oldId,
                                @RequestParam("name")String name,
                                @RequestParam("type")String type, @RequestParam("stage")String stage,
                                @RequestParam("organizationLight")String organizationLight,
                                @RequestParam("organizationPressure")String organizationPressure,@RequestParam("date")String date){
        //得到原来的project对象
        Project oldProject=projectService.findProjectById(oldId);

        if(name!=null&&(!StringUtils.isBlank(name))){
            //对name进行完整性约束的处理  保证没有重名  将location表中projectname的也改了
            Project project = projectService.findProjectByNameExceptId(name, oldId);
            if (project!=null){
                model.addFlashAttribute("msg","修改的项目名已经存在");
                return "redirect:/updateProject/"+oldId;
            }else {
                oldProject.setName(name);
            }
        }
        if(type!=null&&!type.equals("待定")){
            oldProject.setType(type);
        }
        if (stage!=null&&!stage.equals("待定")){
            oldProject.setStage(stage);
        }
        if (organizationLight!=null&&!StringUtils.isBlank(organizationLight)){
            oldProject.setOrganizationLight(organizationLight);
        }
        if (organizationPressure!=null&&!StringUtils.isBlank(organizationPressure)){
            oldProject.setOrganizationPressure(organizationPressure);
        }
        Date date1=new Date();
        try {
            if (date!=null&&!StringUtils.isBlank(date)){
                date1 = String2DateUtil.string2Date(date);
                oldProject.setDate(date1);
            }

        } catch (ParseException e) {
            model.addFlashAttribute("msg","请输入正确的时间格式");
            return "redirect:/updateProject/"+oldId;
        }
        int row = projectService.updateProject(oldProject);
        model.addFlashAttribute("msg","修改成功");
        return "redirect:/updateProject/"+oldId;
    }


    @GetMapping(value = "/deleteProject/{projectId}")
    public String deleteProject(Model model,@PathVariable("projectId")int projectId){
        int row = projectService.deleteProjectById(projectId);
        model.addAttribute("msg","删除成功");
        return "/projectInfo";
    }
}
