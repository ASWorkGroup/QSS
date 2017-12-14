package com.qss.controller;

import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;
import com.qss.service.m00_user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
@Controller
@RequestMapping("/m0001")
public class M0001Controller extends AbstractController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(ModelMap model){
        return "master/m0001_user_list";
    }

    @GetMapping("/list")
    public String list(LoginFormInfo loginFormInfo, ModelMap modelMap, HttpServletResponse response, HttpServletRequest request, HttpSession httpSession){
        List<SysUserInfo> users = userService.getUserList(null);
        modelMap.addAttribute("users", users);
        return "master/m0001_user_list";
    }
}
