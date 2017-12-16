package com.qss.controller;

import com.qss.common.consts.AuthConsts;
import com.qss.common.utils.GsonUtil;
import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;
import com.qss.service.c00_login.AuthService;
import com.qss.service.c00_login.AuthTokenService;
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
@RequestMapping("/portal")
public class PortalController extends AbstractController {
    @Autowired
    private AuthService auth;

    @Autowired
    private AuthTokenService authToken;

    @GetMapping("/index")
    public String index(){
        return "home.default.portal";
    }

}
