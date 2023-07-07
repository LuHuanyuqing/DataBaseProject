package org.spring.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.domain.Waterdrop;
import org.spring.springboot.service.WaterdropServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class WaterdropController {


    private static final Log logger = LogFactory.getLog(WaterdropController.class);

    @Autowired
    private WaterdropServiceImp waterdropservice;





    @ResponseBody
    //定义addwaterdropactjson方法

    @RequestMapping(value = "addwaterdropactjson")

    public String addwaterdropactjson(HttpServletRequest request, HttpSession session, HttpServletResponse response, @RequestBody Waterdrop waterdrop) throws IOException {

        //输出当前方法日志，表示正在执行WaterdropController.addwaterdropactjson方法

        logger.debug("WaterdropController.addwaterdropactjson ......");


        //调用服务层addwaterdropact方法

        waterdropservice.addwaterdropactjson(waterdrop);

        //返回addwaterdrop方法

        return "success";

    }




    @ResponseBody
    // 定义updatewaterdropactjson处理家庭成员修改

    @RequestMapping(value = "updatewaterdropactjson")

    public String updatewaterdropactjson(HttpServletRequest request, HttpServletResponse response, @RequestBody Waterdrop waterdrop, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法WaterdropController.updatewaterdropactjson

        logger.debug("WaterdropController.updatewaterdropactjson ......");

        waterdropservice.updatewaterdropactjson(waterdrop);

        return "success";

    }





    // 定义deletewaterdrop,处理删除家庭成员

    @RequestMapping(value = "deletewaterdrop")

    public String deletewaterdrop(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行WaterdropController.deletewaterdrop方法

        logger.debug("WaterdropController.deletewaterdrop ......");

        waterdropservice.deletewaterdrop(request, session, id);

        // 返回家庭成员管理方法

        return "forward:/waterdropmanage.action";

    }


    @ResponseBody
    // 定义deletewaterdropjson,处理删除家庭成员

    @RequestMapping(value = "deletewaterdropjson")

    public String deletewaterdropjson(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行WaterdropController.deletewaterdrop方法

        logger.debug("WaterdropController.deletewaterdrop ......");

        waterdropservice.deletewaterdrop(request, session, id);

        return "success";

    }





    @ResponseBody
    // 定义searchwaterdropjson方法，处理搜索操作
    @RequestMapping(value = "searchwaterdropjson")

    public Map searchwaterdropjson(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行WaterdropController.searchwaterdropjson

        logger.debug("WaterdropController.searchwaterdropjson ......");


        // 定义返回结果

        Map result = new HashMap();

        // 获取返回结果

        result = waterdropservice.searchwaterdropjson(search); // 将结果以json返回

        return result;

    }





    @ResponseBody
    // 定义Waterdrop详情方法

    @RequestMapping(value = "waterdropdetailsjson")

    public Map waterdropdetailsjson(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为WaterdropController.waterdropdetailsjson

        logger.debug("WaterdropController.waterdropdetailsjson ......");


        Map result = new HashMap();

        result = waterdropservice.waterdropdetailsjson(id);

        // 将结果以json返回

        return result;

    }


}

