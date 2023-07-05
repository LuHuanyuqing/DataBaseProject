package org.spring.springboot.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.spring.springboot.domain.Family;

public interface FamilyServiceImp {

	// 定义方法addfamily接口,响应控制层添加家族请求

	public void addfamily(HttpServletRequest request, HttpSession session);

	// 定义addfamilyact接口

	public void addfamilyact(HttpServletRequest request, HttpSession session, Family family) throws IOException; // 定义addfamilyactjson接口

	public void addfamilyactjson(Family family) throws IOException;

	// 定义familymanage方法响应页面请求

	public void familymanage(HttpServletRequest request, HttpSession session);

	// 定义 familyview方法

	public void familyview(HttpServletRequest request, HttpSession session);

	// 定义 updatefamily方法

	public void updatefamily(HttpServletRequest request, HttpSession session, int id);

	// 定义updatefamilyact处理家族修改

	public void updatefamilyact(HttpServletRequest request, Family family, HttpSession session) throws IOException; // 定义updatefamilyactjson处理家族修改

	public void updatefamilyactjson(Family family) throws IOException;

	// 定义deletefamily,处理删除家族

	public void deletefamily(HttpServletRequest request, HttpSession session, int id);

	// 定义searchfamily方法，处理搜索操作

	public void searchfamily(HttpServletRequest request, HttpSession session, String search);

	// 定义searchfamilyjson方法，处理搜索操作

	public Map searchfamilyjson(String search);

	// 定义FamilypinglunMapper

	public void familydetails(HttpServletRequest request, HttpSession session, int id);

	// 定义Family详情方法

	public Map familydetailsjson(int id);

}
