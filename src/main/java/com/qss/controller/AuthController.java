package com.qss.controller;

import com.qss.consts.AuthConsts;
import com.qss.model.LoginFormInfo;
import com.qss.model.SysUserInfo;
import com.qss.service.IAuth;
import com.qss.service.IAuthToken;
import com.qss.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IAuth auth;

    @Autowired
    private IAuthToken authToken;

    @RequestMapping("/login")
    public String login(ModelMap model){
        return "auth/login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(LoginFormInfo loginFormInfo, HttpServletResponse response, HttpSession httpSession){
        SysUserInfo sysUserInfo = auth.validateUser(loginFormInfo);

        String tokeKey = authToken.getTokenKey();

        Cookie cookie1 = new Cookie(AuthConsts.AuthTokenKey, tokeKey);
        Cookie cookie2 = new Cookie(AuthConsts.AuthUserInfoKey, GsonUtil.gson.toJson(sysUserInfo));
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        httpSession.setAttribute(AuthConsts.AuthTokenKey, tokeKey);
        httpSession.setAttribute(AuthConsts.AuthUserInfoKey, sysUserInfo);
        return "auth/login";
    }
}
