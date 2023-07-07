package org.spring.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.domain.Taste;
import org.spring.springboot.service.TasteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping(value = "/")

public class TasteController {


    private static final Log logger = LogFactory.getLog(TasteController.class);

    @Autowired
    private TasteServiceImp tasteservice;





    @ResponseBody
    //定义addtasteactjson方法

    @RequestMapping(value = "addtasteactjson")

    public String addtasteactjson(HttpServletRequest request, HttpSession session, HttpServletResponse response, @RequestBody Taste taste) throws IOException {

        //输出当前方法日志，表示正在执行TasteController.addtasteactjson方法

        logger.debug("TasteController.addtasteactjson ......");


        //调用服务层addtasteact方法

        tasteservice.addtasteactjson(taste);

        //返回addtaste方法

        return "success";

    }




    @ResponseBody
    // 定义updatetasteactjson处理成员事件修改

    @RequestMapping(value = "updatetasteactjson")

    public String updatetasteactjson(HttpServletRequest request, HttpServletResponse response, @RequestBody Taste taste, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法TasteController.updatetasteactjson

        logger.debug("TasteController.updatetasteactjson ......");

        tasteservice.updatetasteactjson(taste);

        return "success";

    }





    // 定义deletetaste,处理删除成员事件

    @RequestMapping(value = "deletetaste")

    public String deletetaste(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行TasteController.deletetaste方法

        logger.debug("TasteController.deletetaste ......");

        tasteservice.deletetaste(request, session, id);

        // 返回成员事件管理方法

        return "forward:/tastemanage.action";

    }


    @ResponseBody
    // 定义deletetastejson,处理删除成员事件

    @RequestMapping(value = "deletetastejson")

    public String deletetastejson(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行TasteController.deletetaste方法

        logger.debug("TasteController.deletetaste ......");

        tasteservice.deletetaste(request, session, id);

        return "success";

    }





    @ResponseBody
    // 定义searchtastejson方法，处理搜索操作
    @RequestMapping(value = "searchtastejson")

    public Map searchtastejson(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行TasteController.searchtastejson

        logger.debug("TasteController.searchtastejson ......");


        // 定义返回结果

        Map result = new HashMap();

        // 获取返回结果

        result = tasteservice.searchtastejson(search); // 将结果以json返回

        return result;

    }





    @ResponseBody
    // 定义Taste详情方法

    @RequestMapping(value = "tastedetailsjson")

    public Map tastedetailsjson(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为TasteController.tastedetailsjson

        logger.debug("TasteController.tastedetailsjson ......");


        Map result = new HashMap();

        result = tasteservice.tastedetailsjson(id);

        // 将结果以json返回

        return result;

    }


}

