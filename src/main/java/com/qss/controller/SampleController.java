package com.qss.controller;

import com.qss.dao.SampleDao;
import com.qss.model.SampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuanaiqing on 2/12/17.
 */
@Controller
@RequestMapping("sample")
public class SampleController {

    @Autowired
    private SampleDao sampleDao;

    @RequestMapping("/index")
    public String Index(ModelMap model){
        SampleModel sampleModel = sampleDao.getRecord();
        model.addAttribute("sample", sampleModel);
        return "sample/index";
    }
}
