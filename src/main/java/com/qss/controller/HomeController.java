package com.qss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuanaiqing on 2/12/17.
 */
@Controller
@RequestMapping("home")
public class HomeController extends AbstractController{

    @RequestMapping("/index")
    public String Index(){
        return "home/default";
    }
}
