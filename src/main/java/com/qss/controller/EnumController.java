package com.qss.controller;

import com.qss.common.utils.QSSEnum;
import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by yuanaiqing on 17/12/17.
 */
@Controller
@RequestMapping("/enum")
public class EnumController {
    @Autowired
    private QSSEnum qssEnum;

    @GetMapping("/get")
    @ResponseBody
    public Map<String, String> list(@RequestParam(name="key", required = true) String key, HttpServletRequest request){
        Locale locale = RequestContextUtils.getLocale(request);
        Map<String, String> entry = qssEnum.getEnum(key, locale);
        return entry;
    }
}
