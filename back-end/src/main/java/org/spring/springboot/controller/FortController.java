package org.spring.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.domain.Fort;
import org.spring.springboot.service.FortServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping(value = "/")

public class FortController {


    private static final Log logger = LogFactory.getLog(FortController.class);

    @Autowired
    private FortServiceImp fortservice;





    @ResponseBody
    //定义addfortactjson方法

    @RequestMapping(value = "addfortactjson")

    public String addfortactjson(HttpServletRequest request, HttpSession session, HttpServletResponse response, @RequestBody Fort fort) throws IOException {

        //输出当前方法日志，表示正在执行FortController.addfortactjson方法

        logger.debug("FortController.addfortactjson ......");


        //调用服务层addfortact方法

        fortservice.addfortactjson(fort);

        //返回addfort方法

        return "success";

    }




    @ResponseBody
    // 定义updatefortactjson处理家族修改

    @RequestMapping(value = "updatefortactjson")

    public String updatefortactjson(HttpServletRequest request, HttpServletResponse response, @RequestBody Fort fort, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法FortController.updatefortactjson

        logger.debug("FortController.updatefortactjson ......");

        fortservice.updatefortactjson(fort);

        return "success";

    }


    // 定义deletefort,处理删除家族

    @RequestMapping(value = "deletefort")

    public String deletefort(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行FortController.deletefort方法

        logger.debug("FortController.deletefort ......");

        fortservice.deletefort(request, session, id);

        // 返回家族管理方法

        return "forward:/fortmanage.action";

    }


    @ResponseBody
    // 定义deletefortjson,处理删除家族

    @RequestMapping(value = "deletefortjson")

    public String deletefortjson(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行FortController.deletefort方法

        logger.debug("FortController.deletefort ......");

        fortservice.deletefort(request, session, id);

        return "success";

    }





    @ResponseBody
    // 定义searchfortjson方法，处理搜索操作
    @RequestMapping(value = "searchfortjson")

    public Map searchfortjson(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行FortController.searchfortjson

        logger.debug("FortController.searchfortjson ......");


        // 定义返回结果

        Map result = new HashMap();

        // 获取返回结果

        result = fortservice.searchfortjson(search); // 将结果以json返回

        return result;

    }





    @ResponseBody
    // 定义Fort详情方法

    @RequestMapping(value = "fortdetailsjson")

    public Map fortdetailsjson(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为FortController.fortdetailsjson

        logger.debug("FortController.fortdetailsjson ......");


        Map result = new HashMap();

        result = fortservice.fortdetailsjson(id);

        // 将结果以json返回

        return result;

    }


}

