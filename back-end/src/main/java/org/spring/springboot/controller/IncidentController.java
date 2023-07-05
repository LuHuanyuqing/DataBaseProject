package org.spring.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.domain.Incident;
import org.spring.springboot.service.IncidentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping(value = "/")

public class IncidentController {

	private static final Log logger = LogFactory.getLog(IncidentController.class);

	@Autowired
	private IncidentServiceImp incidentservice;

	// 定义方法addincident,响应页面addincident请求

	@RequestMapping(value = "addincident")

	public String addincident(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 输出日志，当前执行方法为addincident

		logger.debug("IncidentController.addincident ......");

		incidentservice.addincident(request, session);

		return "addincident";

	}

	// 定义familyaddincident方法

	@RequestMapping(value = "familyaddincident")

	public String familyaddincident(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 输出日志，表示当前正在执行IncidentController.familyaddincident方法

		logger.debug("IncidentController.familyaddincident ......");

		incidentservice.familyaddincident(request, session);

		// 返回添加人员事件页面

		return "familyaddincident";

	}

	// 定义familyupdateincident方法

	@RequestMapping(value = "familyupdateincident")

	public String familyupdateincident(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {

		// 输出日志IncidentController.familyupdateincident

		logger.debug("IncidentController.familyupdateincident ......");

		incidentservice.familyupdateincident(request, session, id);

		// 返回family修改人员事件页面

		return "familyupdateincident";

	}

	// 定义familyincidentmanage方法

	@RequestMapping(value = "familyincidentmanage")

	public String familyincidentmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

		// 输出日志 ，表示当前正在执行方法为IncidentController.familyincidentmanage

		logger.debug("IncidentController.familyincidentmanage ......");

		incidentservice.familyincidentmanage(request, session); // 返回family人员事件管理页面

		return "familyincidentmanage";

	}

	// 定义familyaddincidentact，响应页面添加人员事件请求

	@RequestMapping(value = "familyaddincidentact")

	public String familyaddincidentact(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Incident incident) throws IOException {

		// 输出日志，表示当前正在执行方法为IncidentController.familyaddincidentact

		logger.debug("IncidentController.familyaddincidentact ......");

		incidentservice.familyaddincidentact(request, session, incident); // 返回到family添加人员事件方法

		return "forward:/familyincidentmanage.action";

	}

	// 定义addincidentact方法,将人员事件信息插入到数据库的t_incident表中

	@RequestMapping(value = "addincidentact")

	public String addincidentact(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Incident incident) throws IOException {

		// 输出当前方法日志，表示正在执行IncidentController.addincidentact方法

		logger.debug("IncidentController.addincidentact ......");

		incidentservice.addincidentact(request, session, incident); // 返回人员事件管理方法，执行人员事件信息的查询

		return "forward:/incidentmanage.action";

	}

	@ResponseBody
	// 定义addincidentactjson方法

	@RequestMapping(value = "addincidentactjson")

	public String addincidentactjson(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			@RequestBody Incident incident) throws IOException {

		// 输出当前方法日志，表示正在执行IncidentController.addincidentactjson方法

		logger.debug("IncidentController.addincidentactjson ......");

		// 调用服务层addincidentact方法

		incidentservice.addincidentactjson(incident);

		// 返回addincident方法

		return "success";

	}

	// 定义incidentmanage方法响应页面请求

	@RequestMapping(value = "incidentmanage")

	public String incidentmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

		// 输出日志，表示当前正在执行IncidentController.incidentmanage

		logger.debug("IncidentController.incidentmanage ......");

		incidentservice.incidentmanage(request, session); // 返回到人员事件管理页面

		return "incidentmanage";

	}

	// 定义 incidentview方法

	@RequestMapping(value = "incidentview")

	public String incidentview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

		// 输出日志，表示当前正在执行IncidentController.incidentview方法

		logger.debug("IncidentController.incidentview ......");

		incidentservice.incidentview(request, session);

		// 返回人员事件查看页面

		return "incidentview";

	}

	// 定义 updateincident方法

	@RequestMapping(value = "updateincident")

	public String updateincident(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {

		// 输出日志IncidentController.updateincident，表示正在执行该方法

		logger.debug("IncidentController.updateincident ......");

		incidentservice.updateincident(request, session, id); // 返回修改人员事件页面

		return "updateincident";

	}

	// 定义updateincidentact处理人员事件修改

	@RequestMapping(value = "updateincidentact")

	public String updateincidentact(HttpServletRequest request, HttpServletResponse response, Incident incident,
			HttpSession session) throws IOException {

		// 输出日志，表示正在执行当前方法IncidentController.updateincidentact

		logger.debug("IncidentController.updateincidentact ......");

		incidentservice.updateincidentact(request, incident, session);

		// 返回人员事件管理方法

		return "forward:/incidentmanage.action";

	}

	@ResponseBody
	// 定义updateincidentactjson处理人员事件修改

	@RequestMapping(value = "updateincidentactjson")

	public String updateincidentactjson(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Incident incident, HttpSession session) throws IOException {

		// 输出日志，表示正在执行当前方法IncidentController.updateincidentactjson

		logger.debug("IncidentController.updateincidentactjson ......");

		incidentservice.updateincidentactjson(incident);

		return "success";

	}

	// 定义familyupdateincidentact方法

	@RequestMapping(value = "familyupdateincidentact")

	public String familyupdateincidentact(HttpServletRequest request, HttpServletResponse response, Incident incident,
			HttpSession session) throws IOException {

		// 当执行此方法时，输出此日志

		logger.debug("IncidentController.familyupdateincidentact ......");

		incidentservice.familyupdateincidentact(request, incident, session);

		// 返回family人员事件管理方法

		return "forward:/familyincidentmanage.action";

	}

	// 定义deleteincident,处理删除人员事件

	@RequestMapping(value = "deleteincident")

	public String deleteincident(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {

		// 输出日志，表示当前正在执行IncidentController.deleteincident方法

		logger.debug("IncidentController.deleteincident ......");

		incidentservice.deleteincident(request, session, id);

		// 返回人员事件管理方法

		return "forward:/incidentmanage.action";

	}

	@ResponseBody
	// 定义deleteincidentjson,处理删除人员事件

	@RequestMapping(value = "deleteincidentjson")

	public String deleteincidentjson(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {

		// 输出日志，表示当前正在执行IncidentController.deleteincident方法

		logger.debug("IncidentController.deleteincident ......");

		incidentservice.deleteincident(request, session, id);

		return "success";

	}

	// 定义familydeleteincident方法

	@RequestMapping(value = "familydeleteincident")

	public String familydeleteincident(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {

		// 输出日志，表示当前正在执行IncidentController.familydeleteincident方法

		logger.debug("IncidentController.familydeleteincident ......");

		incidentservice.familydeleteincident(request, session, id); // 返回family人员事件管理方法

		return "forward:/familyincidentmanage.action";

	}

	// 定义searchincident方法，处理搜索操作

	@RequestMapping(value = "searchincident")

	public String searchincident(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String search) {

		// 输出日志，表示当前正在执行IncidentController.searchincident

		logger.debug("IncidentController.searchincident ......");

		incidentservice.searchincident(request, session, search); // 返回查询人员事件页面

		return "searchincident";

	}

	@ResponseBody
	// 定义searchincidentjson方法，处理搜索操作
	@RequestMapping(value = "searchincidentjson")

	public Map searchincidentjson(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String search) {

		// 输出日志，表示当前正在执行IncidentController.searchincidentjson

		logger.debug("IncidentController.searchincidentjson ......");

		// 定义返回结果

		Map result = new HashMap();

		// 获取返回结果

		result = incidentservice.searchincidentjson(search); // 将结果以json返回

		return result;

	}

	// 定义IncidentpinglunMapper

	@RequestMapping(value = "incidentdetails")

	public String incidentdetails(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			int id) {

		// 输入日志信息，表名当前执行方法为IncidentController.incidentdetails

		logger.debug("IncidentController.incidentdetails ......");

		incidentservice.incidentdetails(request, session, id); // 返回人员事件详情页面

		return "incidentdetails";

	}

	@ResponseBody
	// 定义Incident详情方法

	@RequestMapping(value = "incidentdetailsjson")

	public Map incidentdetailsjson(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			int id) {

		// 输入日志信息，表名当前执行方法为IncidentController.incidentdetailsjson

		logger.debug("IncidentController.incidentdetailsjson ......");

		Map result = new HashMap();

		result = incidentservice.incidentdetailsjson(id);

		// 将结果以json返回

		return result;

	}

}
