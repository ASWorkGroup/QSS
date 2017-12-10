package com.qss.controller;

import com.qss.consts.AuthConsts;
import com.qss.consts.LocaleConsts;
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
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletRequest;
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
    public String doLogin(LoginFormInfo loginFormInfo, @RequestParam("url") String url, HttpServletResponse response, HttpServletRequest request, HttpSession httpSession){
        Locale locale = RequestContextUtils.getLocale(request);

        SysUserInfo sysUserInfo = auth.validateUser(loginFormInfo);

        if (sysUserInfo != null) {

            String tokeKey = authToken.getTokenKey();

            Cookie cookie1 = new Cookie(AuthConsts.AuthTokenKey, tokeKey);
            Cookie cookie2 = new Cookie(AuthConsts.AuthUserInfoKey, URLEncoder.encode(GsonUtil.gson.toJson(sysUserInfo)));
//            Cookie cookie3 = new Cookie(LocaleConsts.ClientLanguageKey, "zh-cn");
            response.addCookie(cookie1);
            response.addCookie(cookie2);

            httpSession.setAttribute(AuthConsts.AuthTokenKey, tokeKey);
            httpSession.setAttribute(AuthConsts.AuthUserInfoKey, sysUserInfo);

            if (url!=null && url.length()!=0) {
                return String.format("redirect:%s", url);
            }
            else {
                return "redirect:/home/index.do";
            }
        }
        else {
            return "auth/login";
        }
    }
}
