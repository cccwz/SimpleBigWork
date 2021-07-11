package com.chen.bigwork.entities;

import java.util.Date;

public class Project {
    private Integer id;
    private String name;
    private String type;
    private String stage;
    private String organizationLight;
    private String organizationPressure;
    private Date date;

    public Project() {
    }

    public String getOrganizationLight() {
        return organizationLight;
    }

    public void setOrganizationLight(String organizationLight) {
        this.organizationLight = organizationLight;
    }

    public String getOrganizationPressure() {
        return organizationPressure;
    }

    public void setOrganizationPressure(String organizationPressure) {
        this.organizationPressure = organizationPressure;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
