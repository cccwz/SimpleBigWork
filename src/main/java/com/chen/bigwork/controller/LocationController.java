package com.chen.bigwork.controller;

import com.chen.bigwork.dao.LocationMapper;
import com.chen.bigwork.entities.Location;
import com.chen.bigwork.entities.Project;
import com.chen.bigwork.service.LocationService;
import com.chen.bigwork.service.ProjectService;
import jdk.internal.org.objectweb.asm.tree.LocalVariableAnnotationNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.function.LongToIntFunction;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/getLocationInfo")
    public String getLocationInfo(Model model, @RequestParam("province")String province,
                      @RequestParam("city") String city,@RequestParam("county")String county){
        if (province.equals("请选择省份")){
            province=null;
        }
        if (city.equals("请选择城市")){
            city=null;
        }
        if (county.equals("请选择区县")){
            county=null;
        }
        List<Location> locations = locationService.selectLocationByPlace(province, city, county);
        if (locations==null||locations.isEmpty()){
            model.addAttribute("locations",null);
        }else {
            model.addAttribute("locations",locations);
        }
        /*System.out.println("p"+province);
        System.out.println("c"+city);
        System.out.println("county"+county);*/


        return "/projectSearch";
    }

    @GetMapping(value = "/addLocation")
    public String getLocationPage(){
        return "/addLocation";
    }

    @PostMapping(value = "/addLocation")
    public String addLocation(Model model,Location location){
        //判断外键projectName属性的引用完整性
        String projectName = location.getProjectName();
        if (projectName!=null&&!StringUtils.isBlank(projectName)){
            Project project = projectService.findProjectByName(projectName);
            if(project==null){
                model.addAttribute("msg","该项目不存在");
                return "/addLocation";
            }
            if(locationService.selectLocationByProjectName(projectName)!=null){
                model.addAttribute("msg","该项目已在其他场址");
                return "/addLocation";
            }
        }


        Double longitude = location.getLongitude();
        if (longitude!=null){
            if(longitude <0|| longitude >180){
                model.addAttribute("msg","经度不符合标准");
                return "/addLocation";
            }
        }

        Double latitude = location.getLatitude();
        if (latitude!=null){
            if (latitude <0|| latitude >90){
                model.addAttribute("msg","纬度不符合标准");
                return "/addLocation";
            }
        }

        int row = locationService.insertLocation(location);
        model.addAttribute("msg","插入数据成功");
        return "/addLocation";
    }

    @GetMapping(value = "/updateLocation/{locationId}")
    public String updateLocation(Model model, @PathVariable("locationId")int locationId){
        Location location = locationService.selectLocationById(locationId);
        model.addAttribute("location",location);
        return "/updateLocation";
    }

    @PostMapping(value = "/updateLocation")
    public String updateLocation(RedirectAttributesModelMap model,Location location){
        Integer oldLocationId = location.getId();
        Location oldLocation = locationService.selectLocationById(oldLocationId);

        //先判断新的项目名的外键约束，并且除了odlocation不能再出现这个项目
        String projectName = location.getProjectName();

        if(projectName!=null&&(!StringUtils.isBlank(projectName))){
            Project project = projectService.findProjectByName(projectName);

            if (project==null){
                model.addFlashAttribute("msg","修改的项目名不存在");
                //Location l=locationService.selectLocationById(oldLocationId);
                return  "redirect:/updateLocation/"+oldLocationId;
            }
            if (locationService.selectLocationbyProjectNameExceptId(projectName,oldLocationId)!=null){
                model.addFlashAttribute("msg","修改的项目已经在其他场址");
               // Location l=locationService.selectLocationById(oldLocationId);
                return  "redirect:/updateLocation/"+oldLocationId;
            }
        }


        //对location的属性进行一个一个判断是否为空
        if(!StringUtils.isBlank(projectName)){
            oldLocation.setProjectName(projectName);
        }

        String county = location.getCounty();
        String city = location.getCity();
        String province = location.getProvince();
        if(!county.equals("请选择区县")){
            oldLocation.setCounty(county);
            if (!city.equals("请选择城市")){
                oldLocation.setCity(city);
                if(!province.equals("请选择省份")){
                    oldLocation.setProvince(province);
                }
            }
        }

        String location1 = location.getLocation();
        if (!StringUtils.isBlank(location1)){
            oldLocation.setLocation(location1);
        }
        String feature = location.getFeature();
        if(!StringUtils.isBlank(feature)){
            oldLocation.setFeature(feature);
        }
        Double capcity = location.getCapcity();
        if (capcity!=null&&capcity>0){
            oldLocation.setCapcity(capcity);
        }
        Double area = location.getArea();
        if (area!=null&&area>0){
            oldLocation.setArea(area);
        }
        Integer height = location.getHeight();
        if(height!=null){
            oldLocation.setHeight(height);
        }
        Double longitude = location.getLongitude();
        if (longitude!=null&&longitude>=0&&longitude<=180){
            oldLocation.setLongitude(longitude);
        }
        Double latitude = location.getLatitude();
        if (latitude!=null&&latitude>=0&&latitude<=90){
            oldLocation.setLatitude(latitude);
        }
        Integer angle = location.getAngle();
        if (angle!=null&&angle>=0&&angle<=90){
            oldLocation.setAngle(angle);
        }
        Double radiation = location.getRadiation();
        if (radiation!=null&&radiation>0){
            oldLocation.setRadiation(radiation);
        }
        Double avgT = location.getAvgT();
        if (avgT!=null){
            oldLocation.setAvgT(avgT);
        }
        Double maxT = location.getMaxT();
        if (maxT!=null){
            oldLocation.setMaxT(maxT);
        }
        Double minT = location.getMinT();
        if (minT!=null){
            oldLocation.setMinT(minT);
        }
        Double depth = location.getDepth();
        if (depth!=null){
            oldLocation.setDepth(depth);
        }
        Double avgWindspeed = location.getAvgWindspeed();
        if (avgWindspeed!=null){
            oldLocation.setAvgWindspeed(avgWindspeed);
        }
        Double maxWindspeed = location.getMaxWindspeed();
        if (maxWindspeed!=null){
            oldLocation.setMaxWindspeed(maxWindspeed);
        }

        locationService.updateLocation(oldLocation);
//        System.out.println(capcity);
       // Location l=locationService.selectLocationById(oldLocationId);
//        model.addAttribute("location",l);
        model.addFlashAttribute("msg","修改成功");
        return "redirect:/updateLocation/"+oldLocationId;
    }

    @GetMapping(value = "/deleteLocation/{locationId}")
    public String deleteLocation(Model model,@PathVariable("locationId")int locationId){
        int row = locationService.deleteLocationById(locationId);
        model.addAttribute("msg","删除成功");
        return "/projectSearch";
    }
}
