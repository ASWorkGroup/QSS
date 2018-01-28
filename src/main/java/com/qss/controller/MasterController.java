package com.qss.controller;

import com.qss.common.page.ListItemDefine;
import com.qss.common.page.PageAttributeDefine;
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

    @GetMapping("/{pageId}/autopage")
    public String index(ModelMap modelMap, @PathVariable("pageId") String pageId){
        modelMap.addAttribute("pageId", pageId);
        return "master.common.autopage";
    }

    @GetMapping("/{pageId}/autopage/define/pageattribute")
    @ResponseBody
    public List<PageAttributeDefine> getPageAttributeDefine(ModelMap modelMap, @PathVariable("pageId") String pageId){
        modelMap.addAttribute("pageId", pageId);
        List<PageAttributeDefine> pageAttributeDefines = new ArrayList<>();
        pageAttributeDefines = pageContainer.getDefine(pageId, "pageattribute", PageAttributeDefine.class);
        pageAttributeDefines.forEach((attr)->{
            attr.setTitle(getMessage(attr.getTitleResourceId()));
        });
        return pageAttributeDefines;
    }

    @GetMapping("/{pageId}/autopage/define/searchcondition")
    @ResponseBody
    public List<SearchConditionDefine> getSearchConditionDefine(ModelMap modelMap, @PathVariable("pageId") String pageId){
        modelMap.addAttribute("pageId", pageId);
        List<SearchConditionDefine> searchConditionDefines = new ArrayList<SearchConditionDefine>();
        searchConditionDefines = pageContainer.getDefine(pageId, "searchcondition", SearchConditionDefine.class);
        for (int i=0; i<searchConditionDefines.size(); i++){
            SearchConditionDefine searchConditionDefine = searchConditionDefines.get(i);
            String displayTextResourceId = searchConditionDefine.getDisplayTextResourceId();
            String localeMessage = getMessage(displayTextResourceId);
            searchConditionDefines.get(i).setDisplayText(localeMessage);
        }
        return searchConditionDefines;
    }

    @GetMapping("/{pageId}/autopage/define/listitem")
    @ResponseBody
    public List<ListItemDefine> getListItemDefine(ModelMap modelMap, @PathVariable("pageId") String pageId){
        modelMap.addAttribute("pageId", pageId);
        List<ListItemDefine> listItemDefines = new ArrayList<ListItemDefine>();
        listItemDefines = pageContainer.getDefine(pageId, "listitem", ListItemDefine.class);
        return listItemDefines;
    }

    @PostMapping("/{pageId}/autopage/list/query")
    @ResponseBody
    public Map<String, String> querylist(ModelMap modelMap, @PathVariable("pageId") String pageId){
        modelMap.addAttribute("pageId", pageId);
        return new HashMap<String, String>();
    }

    @GetMapping("/{pageId}/autopage/item/{id}")
    @ResponseBody
    public Map<String, String> getItem(ModelMap modelMap, @PathVariable("pageId") String pageId, @PathVariable("id") String id){
        modelMap.addAttribute("pageId", pageId);
        return new HashMap<String, String>();
    }

    @PostMapping("/{pageId}/autopage/item/save/{id}")
    @ResponseBody
    public Map<String, String> save(ModelMap modelMap, @PathVariable("pageId") String pageId, @PathVariable("id") String id){
        modelMap.addAttribute("pageId", pageId);
        return new HashMap<String, String>();
    }

}
