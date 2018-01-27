package com.qss.controller;

import com.qss.common.page.ListItemDefine;
import com.qss.common.page.PageContainer;
import com.qss.common.page.SearchConditionDefine;
import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;
import com.qss.service.m00_user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
@Controller
@RequestMapping("/master")
public class MasterController extends AbstractController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private PageContainer pageContainer;

    @GetMapping("/{pageId}/portal")
    public String index(ModelMap modelMap, @PathVariable String pageId){
        modelMap.addAttribute("pageId", pageId);
        return "master.common.portal";
    }

    @GetMapping("/{pageId}/portal/define/searchcondition")
    @ResponseBody
    public List<SearchConditionDefine> getSearchConditionDefine(ModelMap modelMap, @PathVariable String pageId){
        modelMap.addAttribute("pageId", pageId);
        List<SearchConditionDefine> searchConditionDefines = new ArrayList<SearchConditionDefine>();
        searchConditionDefines = pageContainer.getDefine(pageId, "searchcondition", searchConditionDefines.getClass());
        return searchConditionDefines;
    }

    @GetMapping("/{pageId}/portal/define/listitem")
    @ResponseBody
    public List<ListItemDefine> getListItemDefine(ModelMap modelMap, @PathVariable String pageId){
        modelMap.addAttribute("pageId", pageId);
        List<ListItemDefine> listItemDefines = new ArrayList<ListItemDefine>();
        listItemDefines = pageContainer.getDefine(pageId, "listitem", listItemDefines.getClass());
        return listItemDefines;
    }

    @PostMapping("/{pageId}/portal/list")
    @ResponseBody
    public Map<String, String> list(ModelMap modelMap, @PathVariable String pageId){
        modelMap.addAttribute("pageId", pageId);
        return new HashMap<String, String>();
    }

    @GetMapping("/{pageId}/portal/item/{id}")
    @ResponseBody
    public Map<String, String> getItem(ModelMap modelMap, @PathVariable String pageId, @PathVariable String id){
        modelMap.addAttribute("pageId", pageId);
        return new HashMap<String, String>();
    }

    @PostMapping("/{pageId}/portal/item/save/{id}")
    @ResponseBody
    public Map<String, String> save(ModelMap modelMap, @PathVariable String pageId, @PathVariable String id){
        modelMap.addAttribute("pageId", pageId);
        return new HashMap<String, String>();
    }

}
