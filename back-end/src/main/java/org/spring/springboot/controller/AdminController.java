package org.spring.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.domain.Admin;
import org.spring.springboot.service.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping(value = "/")

public class AdminController {


    private static final Log logger = LogFactory.getLog(AdminController.class);

    @Autowired
    private AdminServiceImp adminservice;





    @ResponseBody
    //定义addadminactjson方法

    @RequestMapping(value = "addadminactjson")

    public String addadminactjson(HttpServletRequest request, HttpSession session, HttpServletResponse response, @RequestBody Admin admin) throws IOException {

        //输出当前方法日志，表示正在执行AdminController.addadminactjson方法

        logger.debug("AdminController.addadminactjson ......");


        //调用服务层addadminact方法

        adminservice.addadminactjson(admin);

        //返回addadmin方法

        return "success";

    }




    @ResponseBody
    // 定义updateadminactjson处理管理员修改

    @RequestMapping(value = "updateadminactjson")

    public String updateadminactjson(HttpServletRequest request, HttpServletResponse response, @RequestBody Admin admin, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法AdminController.updateadminactjson

        logger.debug("AdminController.updateadminactjson ......");

        adminservice.updateadminactjson(admin);

        return "success";

    }


    // 定义deleteadmin,处理删除管理员

    @RequestMapping(value = "deleteadmin")

    public String deleteadmin(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行AdminController.deleteadmin方法

        logger.debug("AdminController.deleteadmin ......");

        adminservice.deleteadmin(request, session, id);

        // 返回管理员管理方法

        return "forward:/adminmanage.action";

    }


    @ResponseBody
    // 定义deleteadminjson,处理删除管理员

    @RequestMapping(value = "deleteadminjson")

    public String deleteadminjson(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行AdminController.deleteadmin方法

        logger.debug("AdminController.deleteadmin ......");

        adminservice.deleteadmin(request, session, id);

        return "success";

    }





    @ResponseBody
    // 定义searchadminjson方法，处理搜索操作
    @RequestMapping(value = "searchadminjson")

    public Map searchadminjson(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行AdminController.searchadminjson

        logger.debug("AdminController.searchadminjson ......");


        // 定义返回结果

        Map result = new HashMap();

        // 获取返回结果

        result = adminservice.searchadminjson(search); // 将结果以json返回

        return result;

    }





    @ResponseBody
    // 定义Admin详情方法

    @RequestMapping(value = "admindetailsjson")

    public Map admindetailsjson(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为AdminController.admindetailsjson

        logger.debug("AdminController.admindetailsjson ......");


        Map result = new HashMap();

        result = adminservice.admindetailsjson(id);

        // 将结果以json返回

        return result;

    }


}

