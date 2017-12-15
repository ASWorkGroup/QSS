package com.qss.controller;

import com.qss.common.consts.AuthConsts;
import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;
import com.qss.service.c00_login.AuthService;
import com.qss.service.c00_login.AuthTokenService;
import com.qss.common.utils.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.Locale;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
@Controller
@RequestMapping("/c0001")
public class C0001Controller extends AbstractController {
    @Autowired
    private AuthService auth;

    @Autowired
    private AuthTokenService authToken;

    @GetMapping("/index")
    public String index(ModelMap model){
        return "common.c0001.login.auth";
    }

    @PostMapping("/login")
    public String doLogin(LoginFormInfo loginFormInfo, @RequestParam("url") String url, HttpServletResponse response, HttpServletRequest request, HttpSession httpSession){
        Locale locale = RequestContextUtils.getLocale(request);
        String message = messageUtil.getMessage("I001", locale, "");

        SysUserInfo sysUserInfo = auth.validateUser(loginFormInfo);

        if (sysUserInfo != null) {

            String tokeKey = authToken.getTokenKey();

            Cookie cookie1 = new Cookie(AuthConsts.AuthTokenKey, tokeKey);
            cookie1.setSecure(true);
            Cookie cookie2 = new Cookie(AuthConsts.AuthUserInfoKey, URLEncoder.encode(GsonUtil.gson.toJson(sysUserInfo)));
            cookie2.setSecure(true);
            response.addCookie(cookie1);
            response.addCookie(cookie2);

            httpSession.setAttribute(AuthConsts.AuthTokenKey, tokeKey);
            httpSession.setAttribute(AuthConsts.AuthUserInfoKey, sysUserInfo);

            if (url!=null && url.length()!=0) {
                return String.format("redirect:%s", url);
            }
            else {
                return "home.default.portal";
            }
        }
        else {
            return "common.c0001.login.auth";
        }
    }
}
