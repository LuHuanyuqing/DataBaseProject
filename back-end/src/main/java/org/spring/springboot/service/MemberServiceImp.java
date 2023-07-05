package org.spring.springboot.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.spring.springboot.domain.Member;
import org.springframework.web.multipart.MultipartFile;

public interface MemberServiceImp {

	// 定义方法addmember接口,响应控制层添加家庭成员请求

	public void addmember(HttpServletRequest request, HttpSession session);

	// 定义familyaddmember接口，在家庭成员控制层中调用

	public void familyaddmember(HttpServletRequest request, HttpSession session);

	// 定义familyupdatemember方法

	public void familyupdatemember(HttpServletRequest request, HttpSession session, int id);

	// 定义familymembermanage方法

	public void familymembermanage(HttpServletRequest request, HttpSession session);

	// 定义familyaddmemberact接口，响应控制层添加请求

	public void familyaddmemberact(HttpServletRequest request, HttpSession session, Member member,
			MultipartFile avatarfile) throws IOException;

	// 定义addmemberact接口

	public void addmemberact(HttpServletRequest request, HttpSession session, Member member, MultipartFile avatarfile)
			throws IOException; // 定义addmemberactjson接口

	public void addmemberactjson(Member member) throws IOException;

	// 定义membermanage方法响应页面请求

	public void membermanage(HttpServletRequest request, HttpSession session);

	// 定义 memberview方法

	public void memberview(HttpServletRequest request, HttpSession session);

	// 定义 updatemember方法

	public void updatemember(HttpServletRequest request, HttpSession session, int id);

	// 定义updatememberact处理家庭成员修改

	public void updatememberact(HttpServletRequest request, Member member, HttpSession session,
			MultipartFile avatarfile) throws IOException; // 定义updatememberactjson处理家庭成员修改

	public void updatememberactjson(Member member) throws IOException;

	// 定义familyupdatememberact方法

	public void familyupdatememberact(HttpServletRequest request, Member member, HttpSession session,
			MultipartFile avatarfile) throws IOException;

	// 定义deletemember,处理删除家庭成员

	public void deletemember(HttpServletRequest request, HttpSession session, int id);

	// 定义familydeletemember方法

	public void familydeletemember(HttpServletRequest request, HttpSession session, int id);

	// 定义searchmember方法，处理搜索操作

	public void searchmember(HttpServletRequest request, HttpSession session, String search);

	// 定义searchmemberjson方法，处理搜索操作

	public Map searchmemberjson(String search);

	// 定义MemberpinglunMapper

	public void memberdetails(HttpServletRequest request, HttpSession session, int id);

	// 定义Member详情方法

	public Map memberdetailsjson(int id);

}
