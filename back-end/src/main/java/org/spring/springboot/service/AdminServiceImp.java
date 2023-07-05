package org.spring.springboot.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.spring.springboot.domain.Admin;

public interface AdminServiceImp {

	// 定义方法addadmin接口,响应控制层添加管理员请求

	public void addadmin(HttpServletRequest request, HttpSession session);

	// 定义addadminact接口

	public void addadminact(HttpServletRequest request, HttpSession session, Admin admin) throws IOException; // 定义addadminactjson接口

	public void addadminactjson(Admin admin) throws IOException;

	// 定义adminmanage方法响应页面请求

	public void adminmanage(HttpServletRequest request, HttpSession session);

	// 定义 adminview方法

	public void adminview(HttpServletRequest request, HttpSession session);

	// 定义 updateadmin方法

	public void updateadmin(HttpServletRequest request, HttpSession session, int id);

	// 定义updateadminact处理管理员修改

	public void updateadminact(HttpServletRequest request, Admin admin, HttpSession session) throws IOException; // 定义updateadminactjson处理管理员修改

	public void updateadminactjson(Admin admin) throws IOException;

	// 定义deleteadmin,处理删除管理员

	public void deleteadmin(HttpServletRequest request, HttpSession session, int id);

	// 定义searchadmin方法，处理搜索操作

	public void searchadmin(HttpServletRequest request, HttpSession session, String search);

	// 定义searchadminjson方法，处理搜索操作

	public Map searchadminjson(String search);

	// 定义AdminpinglunMapper

	public void admindetails(HttpServletRequest request, HttpSession session, int id);

	// 定义Admin详情方法

	public Map admindetailsjson(int id);

}
