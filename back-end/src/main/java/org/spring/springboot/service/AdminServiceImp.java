package org.spring.springboot.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.spring.springboot.domain.Admin;

public interface AdminServiceImp {




    public void addadminactjson(Admin admin) throws IOException;




    public void updateadminactjson(Admin admin) throws IOException;


    // 定义deleteadmin,处理删除管理员

    public void deleteadmin(HttpServletRequest request, HttpSession session, int id);





    // 定义searchadminjson方法，处理搜索操作

    public Map searchadminjson(String search);





    // 定义Admin详情方法

    public Map admindetailsjson(int id);


}

