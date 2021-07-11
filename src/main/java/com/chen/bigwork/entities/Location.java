package com.chen.bigwork.entities;

import org.springframework.scheduling.support.SimpleTriggerContext;

public class Location {

    private Integer id; //场址id

    private String projectName;//项目名称

    private String province;//省份

    private String city;//市

    private String county;//县

    private String location;//具体位置

    private String feature;//特征

    private Double capcity;//安装容量

    private Double area;//用地面积

    private Integer height;//海拔高度

    private Double longitude;//经度

    private Double latitude;//纬度

    private Double radiation;//水平太阳辐射

    private Integer angle;//最佳辐射量倾角

    private Double avgT;//平均温度

    private Double maxT;//最高温度

    private Double minT;//最低温度

    private Double depth;//多年最大冻土深度

    private Double avgWindspeed;//多年平均风速

    private Double maxWindspeed;//多年极大风速

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", location='" + location + '\'' +
                ", feature='" + feature + '\'' +
                ", capcity=" + capcity +
                ", area=" + area +
                ", height=" + height +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", radiation=" + radiation +
                ", angle=" + angle +
                ", avgT=" + avgT +
                ", maxT=" + maxT +
                ", minT=" + minT +
                ", depth=" + depth +
                ", avgWindspeed=" + avgWindspeed +
                ", maxWindspeed=" + maxWindspeed +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Double getCapcity() {
        return capcity;
    }

    public void setCapcity(Double capcity) {
        this.capcity = capcity;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getRadiation() {
        return radiation;
    }

    public void setRadiation(Double radiation) {
        this.radiation = radiation;
    }

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public Double getAvgT() {
        return avgT;
    }

    public void setAvgT(Double avgT) {
        this.avgT = avgT;
    }

    public Double getMaxT() {
        return maxT;
    }

    public void setMaxT(Double maxT) {
        this.maxT = maxT;
    }

    public Double getMinT() {
        return minT;
    }

    public void setMinT(Double minT) {
        this.minT = minT;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getAvgWindspeed() {
        return avgWindspeed;
    }

    public void setAvgWindspeed(Double avgWindspeed) {
        this.avgWindspeed = avgWindspeed;
    }

    public Double getMaxWindspeed() {
        return maxWindspeed;
    }

    public void setMaxWindspeed(Double maxWindspeed) {
        this.maxWindspeed = maxWindspeed;
    }
}
