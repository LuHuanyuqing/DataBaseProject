package org.spring.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.domain.Admin;
import org.spring.springboot.service.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping(value = "/")

public class AdminController {

	private static final Log logger = LogFactory.getLog(AdminController.class);

	@Autowired
	private AdminServiceImp adminservice;

	// 定义方法addadmin,响应页面addadmin请求

	@RequestMapping(value = "addadmin")

	public String addadmin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 输出日志，当前执行方法为addadmin

		logger.debug("AdminController.addadmin ......");

		adminservice.addadmin(request, session);

		return "addadmin";

	}

	// 定义addadminact方法,将管理员信息插入到数据库的t_admin表中

	@RequestMapping(value = "addadminact")

	public String addadminact(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Admin admin) throws IOException {

		// 输出当前方法日志，表示正在执行AdminController.addadminact方法

		logger.debug("AdminController.addadminact ......");

		adminservice.addadminact(request, session, admin); // 返回管理员管理方法，执行管理员信息的查询

		return "forward:/adminmanage.action";

	}

	@ResponseBody
	// 定义addadminactjson方法

	@RequestMapping(value = "addadminactjson")

	public String addadminactjson(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			@RequestBody Admin admin) throws IOException {

		// 输出当前方法日志，表示正在执行AdminController.addadminactjson方法

		logger.debug("AdminController.addadminactjson ......");

		// 调用服务层addadminact方法

		adminservice.addadminactjson(admin);

		// 返回addadmin方法

		return "success";

	}

	// 定义adminmanage方法响应页面请求

	@RequestMapping(value = "adminmanage")

	public String adminmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

		// 输出日志，表示当前正在执行AdminController.adminmanage

		logger.debug("AdminController.adminmanage ......");

		adminservice.adminmanage(request, session); // 返回到管理员管理页面

		return "adminmanage";

	}

	// 定义 adminview方法

	@RequestMapping(value = "adminview")

	public String adminview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

		// 输出日志，表示当前正在执行AdminController.adminview方法

		logger.debug("AdminController.adminview ......");

		adminservice.adminview(request, session);

		// 返回管理员查看页面

		return "adminview";

	}

	// 定义 updateadmin方法

	@RequestMapping(value = "updateadmin")

	public String updateadmin(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

		// 输出日志AdminController.updateadmin，表示正在执行该方法

		logger.debug("AdminController.updateadmin ......");

		adminservice.updateadmin(request, session, id); // 返回修改管理员页面

		return "updateadmin";

	}

	// 定义updateadminact处理管理员修改

	@RequestMapping(value = "updateadminact")

	public String updateadminact(HttpServletRequest request, HttpServletResponse response, Admin admin,
			HttpSession session) throws IOException {

		// 输出日志，表示正在执行当前方法AdminController.updateadminact

		logger.debug("AdminController.updateadminact ......");

		adminservice.updateadminact(request, admin, session);

		// 返回管理员管理方法

		return "forward:/adminmanage.action";

	}

	@ResponseBody
	// 定义updateadminactjson处理管理员修改

	@RequestMapping(value = "updateadminactjson")

	public String updateadminactjson(HttpServletRequest request, HttpServletResponse response, @RequestBody Admin admin,
			HttpSession session) throws IOException {

		// 输出日志，表示正在执行当前方法AdminController.updateadminactjson

		logger.debug("AdminController.updateadminactjson ......");

		adminservice.updateadminactjson(admin);

		return "success";

	}

	// 定义deleteadmin,处理删除管理员

	@RequestMapping(value = "deleteadmin")

	public String deleteadmin(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

		// 输出日志，表示当前正在执行AdminController.deleteadmin方法

		logger.debug("AdminController.deleteadmin ......");

		adminservice.deleteadmin(request, session, id);

		// 返回管理员管理方法

		return "forward:/adminmanage.action";

	}

	@ResponseBody
	// 定义deleteadminjson,处理删除管理员

	@RequestMapping(value = "deleteadminjson")

	public String deleteadminjson(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {

		// 输出日志，表示当前正在执行AdminController.deleteadmin方法

		logger.debug("AdminController.deleteadmin ......");

		adminservice.deleteadmin(request, session, id);

		return "success";

	}

	// 定义searchadmin方法，处理搜索操作

	@RequestMapping(value = "searchadmin")

	public String searchadmin(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String search) {

		// 输出日志，表示当前正在执行AdminController.searchadmin

		logger.debug("AdminController.searchadmin ......");

		adminservice.searchadmin(request, session, search); // 返回查询管理员页面

		return "searchadmin";

	}

	@ResponseBody
	// 定义searchadminjson方法，处理搜索操作
	@RequestMapping(value = "searchadminjson")

	public Map searchadminjson(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String search) {

		// 输出日志，表示当前正在执行AdminController.searchadminjson

		logger.debug("AdminController.searchadminjson ......");

		// 定义返回结果

		Map result = new HashMap();

		// 获取返回结果

		result = adminservice.searchadminjson(search); // 将结果以json返回

		return result;

	}

	// 定义AdminpinglunMapper

	@RequestMapping(value = "admindetails")

	public String admindetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

		// 输入日志信息，表名当前执行方法为AdminController.admindetails

		logger.debug("AdminController.admindetails ......");

		adminservice.admindetails(request, session, id); // 返回管理员详情页面

		return "admindetails";

	}

	@ResponseBody
	// 定义Admin详情方法

	@RequestMapping(value = "admindetailsjson")

	public Map admindetailsjson(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

		// 输入日志信息，表名当前执行方法为AdminController.admindetailsjson

		logger.debug("AdminController.admindetailsjson ......");

		Map result = new HashMap();

		result = adminservice.admindetailsjson(id);

		// 将结果以json返回

		return result;

	}

}
