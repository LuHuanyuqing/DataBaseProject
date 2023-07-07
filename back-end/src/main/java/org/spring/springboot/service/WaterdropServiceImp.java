package org.spring.springboot.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.spring.springboot.domain.Waterdrop;
import org.springframework.web.multipart.MultipartFile;

public interface WaterdropServiceImp {




    public void addwaterdropactjson(Waterdrop waterdrop) throws IOException;




    public void updatewaterdropactjson(Waterdrop waterdrop) throws IOException;





    // 定义deletewaterdrop,处理删除家庭成员

    public void deletewaterdrop(HttpServletRequest request, HttpSession session, int id);





    // 定义searchwaterdropjson方法，处理搜索操作

    public Map searchwaterdropjson(String search);





    // 定义Waterdrop详情方法

    public Map waterdropdetailsjson(int id);


}

