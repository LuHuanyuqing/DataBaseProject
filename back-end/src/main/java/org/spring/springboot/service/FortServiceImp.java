package org.spring.springboot.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.spring.springboot.domain.Fort;

public interface FortServiceImp {




    public void addfortactjson(Fort fort) throws IOException;




    public void updatefortactjson(Fort fort) throws IOException;


    // 定义deletefort,处理删除家族

    public void deletefort(HttpServletRequest request, HttpSession session, int id);





    // 定义searchfortjson方法，处理搜索操作

    public Map searchfortjson(String search);





    // 定义Fort详情方法

    public Map fortdetailsjson(int id);


}

