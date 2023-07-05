package org.spring.springboot.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.spring.springboot.domain.Incident;

public interface IncidentServiceImp {

	// 定义方法addincident接口,响应控制层添加人员事件请求

	public void addincident(HttpServletRequest request, HttpSession session);

	// 定义familyaddincident接口，在人员事件控制层中调用

	public void familyaddincident(HttpServletRequest request, HttpSession session);

	// 定义familyupdateincident方法

	public void familyupdateincident(HttpServletRequest request, HttpSession session, int id);

	// 定义familyincidentmanage方法

	public void familyincidentmanage(HttpServletRequest request, HttpSession session);

	// 定义familyaddincidentact接口，响应控制层添加请求

	public void familyaddincidentact(HttpServletRequest request, HttpSession session, Incident incident)
			throws IOException;

	// 定义addincidentact接口

	public void addincidentact(HttpServletRequest request, HttpSession session, Incident incident) throws IOException; // 定义addincidentactjson接口

	public void addincidentactjson(Incident incident) throws IOException;

	// 定义incidentmanage方法响应页面请求

	public void incidentmanage(HttpServletRequest request, HttpSession session);

	// 定义 incidentview方法

	public void incidentview(HttpServletRequest request, HttpSession session);

	// 定义 updateincident方法

	public void updateincident(HttpServletRequest request, HttpSession session, int id);

	// 定义updateincidentact处理人员事件修改

	public void updateincidentact(HttpServletRequest request, Incident incident, HttpSession session)
			throws IOException; // 定义updateincidentactjson处理人员事件修改

	public void updateincidentactjson(Incident incident) throws IOException;

	// 定义familyupdateincidentact方法

	public void familyupdateincidentact(HttpServletRequest request, Incident incident, HttpSession session)
			throws IOException;

	// 定义deleteincident,处理删除人员事件

	public void deleteincident(HttpServletRequest request, HttpSession session, int id);

	// 定义familydeleteincident方法

	public void familydeleteincident(HttpServletRequest request, HttpSession session, int id);

	// 定义searchincident方法，处理搜索操作

	public void searchincident(HttpServletRequest request, HttpSession session, String search);

	// 定义searchincidentjson方法，处理搜索操作

	public Map searchincidentjson(String search);

	// 定义IncidentpinglunMapper

	public void incidentdetails(HttpServletRequest request, HttpSession session, int id);

	// 定义Incident详情方法

	public Map incidentdetailsjson(int id);

}
