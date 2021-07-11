package com.chen.bigwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/projectSearch")
    public String getProjectSearchPage(){
        return "/projectSearch";
    }
}
