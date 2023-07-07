package org.spring.springboot.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.spring.springboot.domain.Taste;

public interface TasteServiceImp {




    public void addtasteactjson(Taste taste) throws IOException;




    public void updatetasteactjson(Taste taste) throws IOException;





    // 定义deletetaste,处理删除成员事件

    public void deletetaste(HttpServletRequest request, HttpSession session, int id);





    // 定义searchtastejson方法，处理搜索操作

    public Map searchtastejson(String search);





    // 定义Taste详情方法

    public Map tastedetailsjson(int id);


}

