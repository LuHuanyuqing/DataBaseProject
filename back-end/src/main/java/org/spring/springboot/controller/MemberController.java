package org.spring.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.domain.Member;
import org.spring.springboot.service.MemberServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class MemberController {

	private static final Log logger = LogFactory.getLog(MemberController.class);

	@Autowired
	private MemberServiceImp memberservice;

	// 定义方法addmember,响应页面addmember请求

	@RequestMapping(value = "addmember")

	public String addmember(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 输出日志，当前执行方法为addmember

		logger.debug("MemberController.addmember ......");

		memberservice.addmember(request, session);

		return "addmember";

	}

	// 定义familyaddmember方法

	@RequestMapping(value = "familyaddmember")

	public String familyaddmember(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// 输出日志，表示当前正在执行MemberController.familyaddmember方法

		logger.debug("MemberController.familyaddmember ......");

		memberservice.familyaddmember(request, session);

		// 返回添加家庭成员页面

		return "familyaddmember";

	}

	// 定义familyupdatemember方法

	@RequestMapping(value = "familyupdatemember")

	public String familyupdatemember(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {

		// 输出日志MemberController.familyupdatemember

		logger.debug("MemberController.familyupdatemember ......");

		memberservice.familyupdatemember(request, session, id);

		// 返回family修改家庭成员页面

		return "familyupdatemember";

	}

	// 定义familymembermanage方法

	@RequestMapping(value = "familymembermanage")

	public String familymembermanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

		// 输出日志 ，表示当前正在执行方法为MemberController.familymembermanage

		logger.debug("MemberController.familymembermanage ......");

		memberservice.familymembermanage(request, session); // 返回family家庭成员管理页面

		return "familymembermanage";

	}

	// 定义familyaddmemberact，响应页面添加家庭成员请求

	@RequestMapping(value = "familyaddmemberact")

	public String familyaddmemberact(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Member member, MultipartFile avatarfile) throws IOException {

		// 输出日志，表示当前正在执行方法为MemberController.familyaddmemberact

		logger.debug("MemberController.familyaddmemberact ......");

		memberservice.familyaddmemberact(request, session, member, avatarfile); // 返回到family添加家庭成员方法

		return "forward:/familymembermanage.action";

	}

	// 定义addmemberact方法,将家庭成员信息插入到数据库的t_member表中

	@RequestMapping(value = "addmemberact")

	public String addmemberact(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Member member, MultipartFile avatarfile) throws IOException {

		// 输出当前方法日志，表示正在执行MemberController.addmemberact方法

		logger.debug("MemberController.addmemberact ......");

		memberservice.addmemberact(request, session, member, avatarfile); // 返回家庭成员管理方法，执行家庭成员信息的查询

		return "forward:/membermanage.action";

	}

	@ResponseBody
	// 定义addmemberactjson方法

	@RequestMapping(value = "addmemberactjson")

	public String addmemberactjson(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			@RequestBody Member member) throws IOException {

		// 输出当前方法日志，表示正在执行MemberController.addmemberactjson方法

		logger.debug("MemberController.addmemberactjson ......");

		// 调用服务层addmemberact方法

		memberservice.addmemberactjson(member);

		// 返回addmember方法

		return "success";

	}

	// 定义membermanage方法响应页面请求

	@RequestMapping(value = "membermanage")

	public String membermanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

		// 输出日志，表示当前正在执行MemberController.membermanage

		logger.debug("MemberController.membermanage ......");

		memberservice.membermanage(request, session); // 返回到家庭成员管理页面

		return "membermanage";

	}

	// 定义 memberview方法

	@RequestMapping(value = "memberview")

	public String memberview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

		// 输出日志，表示当前正在执行MemberController.memberview方法

		logger.debug("MemberController.memberview ......");

		memberservice.memberview(request, session);

		// 返回家庭成员查看页面

		return "memberview";

	}

	// 定义 updatemember方法

	@RequestMapping(value = "updatemember")

	public String updatemember(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

		// 输出日志MemberController.updatemember，表示正在执行该方法

		logger.debug("MemberController.updatemember ......");

		memberservice.updatemember(request, session, id); // 返回修改家庭成员页面

		return "updatemember";

	}

	// 定义updatememberact处理家庭成员修改

	@RequestMapping(value = "updatememberact")

	public String updatememberact(HttpServletRequest request, HttpServletResponse response, Member member,
			HttpSession session, MultipartFile avatarfile) throws IOException {

		// 输出日志，表示正在执行当前方法MemberController.updatememberact

		logger.debug("MemberController.updatememberact ......");

		memberservice.updatememberact(request, member, session, avatarfile);

		// 返回家庭成员管理方法

		return "forward:/membermanage.action";

	}

	@ResponseBody
	// 定义updatememberactjson处理家庭成员修改

	@RequestMapping(value = "updatememberactjson")

	public String updatememberactjson(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Member member, HttpSession session) throws IOException {

		// 输出日志，表示正在执行当前方法MemberController.updatememberactjson

		logger.debug("MemberController.updatememberactjson ......");

		memberservice.updatememberactjson(member);

		return "success";

	}

	// 定义familyupdatememberact方法

	@RequestMapping(value = "familyupdatememberact")

	public String familyupdatememberact(HttpServletRequest request, HttpServletResponse response, Member member,
			HttpSession session, MultipartFile avatarfile) throws IOException {

		// 当执行此方法时，输出此日志

		logger.debug("MemberController.familyupdatememberact ......");

		memberservice.familyupdatememberact(request, member, session, avatarfile);

		// 返回family家庭成员管理方法

		return "forward:/familymembermanage.action";

	}

	// 定义deletemember,处理删除家庭成员

	@RequestMapping(value = "deletemember")

	public String deletemember(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

		// 输出日志，表示当前正在执行MemberController.deletemember方法

		logger.debug("MemberController.deletemember ......");

		memberservice.deletemember(request, session, id);

		// 返回家庭成员管理方法

		return "forward:/membermanage.action";

	}

	@ResponseBody
	// 定义deletememberjson,处理删除家庭成员

	@RequestMapping(value = "deletememberjson")

	public String deletememberjson(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {

		// 输出日志，表示当前正在执行MemberController.deletemember方法

		logger.debug("MemberController.deletemember ......");

		memberservice.deletemember(request, session, id);

		return "success";

	}

	// 定义familydeletemember方法

	@RequestMapping(value = "familydeletemember")

	public String familydeletemember(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {

		// 输出日志，表示当前正在执行MemberController.familydeletemember方法

		logger.debug("MemberController.familydeletemember ......");

		memberservice.familydeletemember(request, session, id); // 返回family家庭成员管理方法

		return "forward:/familymembermanage.action";

	}

	// 定义searchmember方法，处理搜索操作

	@RequestMapping(value = "searchmember")

	public String searchmember(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String search) {

		// 输出日志，表示当前正在执行MemberController.searchmember

		logger.debug("MemberController.searchmember ......");

		memberservice.searchmember(request, session, search); // 返回查询家庭成员页面

		return "searchmember";

	}

	@ResponseBody
	// 定义searchmemberjson方法，处理搜索操作
	@RequestMapping(value = "searchmemberjson")

	public Map searchmemberjson(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String search) {

		// 输出日志，表示当前正在执行MemberController.searchmemberjson

		logger.debug("MemberController.searchmemberjson ......");

		// 定义返回结果

		Map result = new HashMap();

		// 获取返回结果

		result = memberservice.searchmemberjson(search); // 将结果以json返回

		return result;

	}

	// 定义MemberpinglunMapper

	@RequestMapping(value = "memberdetails")

	public String memberdetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

		// 输入日志信息，表名当前执行方法为MemberController.memberdetails

		logger.debug("MemberController.memberdetails ......");

		memberservice.memberdetails(request, session, id); // 返回家庭成员详情页面

		return "memberdetails";

	}

	@ResponseBody
	// 定义Member详情方法

	@RequestMapping(value = "memberdetailsjson")

	public Map memberdetailsjson(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			int id) {

		// 输入日志信息，表名当前执行方法为MemberController.memberdetailsjson

		logger.debug("MemberController.memberdetailsjson ......");

		Map result = new HashMap();

		result = memberservice.memberdetailsjson(id);

		// 将结果以json返回

		return result;

	}

}
