package com.qss.controller;

import com.qss.dao.SampleDao;
import com.qss.model.SampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
//    @Autowired
//    private SampleDao sampleDao;

    @RequestMapping("/login")
    public String Index(ModelMap model){
        return "auth/login";
    }
}
