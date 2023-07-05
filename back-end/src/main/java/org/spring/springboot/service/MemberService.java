package org.spring.springboot.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.dao.FamilyMapper;
import org.spring.springboot.dao.MemberMapper;
import org.spring.springboot.domain.Family;
import org.spring.springboot.domain.FamilyExample;
import org.spring.springboot.domain.Member;
import org.spring.springboot.domain.MemberExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service

public class MemberService implements MemberServiceImp {

	private static final Log logger = LogFactory.getLog(MemberService.class);

	@Autowired
	private MemberMapper memberdao;
	// 定义familydao参数

	@Autowired
	private FamilyMapper familydao;

	// 定义方法addmember,响应控制层addmember请求

	public void addmember(HttpServletRequest request, HttpSession session) {

		// 输出日志，当前执行方法为addmember

		logger.debug("MemberService.addmember ......");

		// 定义 example1为 FamilyExample的实例

		FamilyExample example1 = new FamilyExample();

		// 定义familyall的List使用 familydao的selectByExample方法查询所有家庭成员数据

		List familyall = familydao.selectByExample(example1);

		// 将上面查询到的家庭成员数据保存到request中，返回页面

		request.setAttribute("familyall", familyall);

		// 定义 example2为 MemberExample的实例

		MemberExample example2 = new MemberExample();

		// 定义memberall的List使用 memberdao的selectByExample方法查询所有家庭成员数据

		List memberall = memberdao.selectByExample(example2);

		// 将上面查询到的家庭成员数据保存到request中，返回页面

		request.setAttribute("memberall", memberall);

	}

	// 定义familyaddmember方法，在家庭成员控制层中调用

	public void familyaddmember(HttpServletRequest request, HttpSession session) {

		// 输出日志，表示当前正在执行MemberService.familyaddmember方法

		logger.debug("MemberService.familyaddmember ......");

		// 定义 example1为 FamilyExample的实例

		FamilyExample example1 = new FamilyExample();

		// 定义familyall的List使用 familydao的selectByExample方法查询所有家庭成员数据

		List familyall = familydao.selectByExample(example1);

		// 将上面查询到的家庭成员数据保存到request中，返回页面

		request.setAttribute("familyall", familyall);

		// 定义 example2为 MemberExample的实例

		MemberExample example2 = new MemberExample();

		// 定义memberall的List使用 memberdao的selectByExample方法查询所有家庭成员数据

		List memberall = memberdao.selectByExample(example2);

		// 将上面查询到的家庭成员数据保存到request中，返回页面

		request.setAttribute("memberall", memberall);

	}

	// 定义familyupdatemember方法

	public void familyupdatemember(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志MemberService.familyupdatemember

		logger.debug("MemberService.familyupdatemember ......");

		// 实例化家庭成员,使用memberdao的selectByPrimaryKey方法通过id查询家庭成员

		Member member = memberdao.selectByPrimaryKey(id);

		// 定义 example1为 FamilyExample的实例

		FamilyExample example1 = new FamilyExample();

		// 定义familyall的List使用 familydao的selectByExample方法查询所有家庭成员数据

		List familyall = familydao.selectByExample(example1);

		// 将上面查询到的家庭成员数据保存到request中，返回页面

		request.setAttribute("familyall", familyall);

		// 定义 example2为 MemberExample的实例

		MemberExample example2 = new MemberExample();

		// 定义memberall的List使用 memberdao的selectByExample方法查询所有家庭成员数据

		List memberall = memberdao.selectByExample(example2);

		// 将上面查询到的家庭成员数据保存到request中，返回页面

		request.setAttribute("memberall", memberall);

		// 将查询出的家庭成员信息保存到request中

		request.setAttribute("member", member);

	}

	// 定义familymembermanage方法

	public void familymembermanage(HttpServletRequest request, HttpSession session) {

		// 输出日志 ，表示当前正在执行方法为MemberService.familymembermanage

		logger.debug("MemberService.familymembermanage ......");

		// 定义实体，从session中获取当前用户，赋值给

		Family family = (Family) session.getAttribute("userinfo");

		// 实例化家庭成员类为example

		MemberExample example = new MemberExample();

		// 实例化家庭成员Example类的criteria

		MemberExample.Criteria criteria = example.createCriteria();

		// 通过 criteria设置查询条件Familyid为当前用户id

		criteria.andFamilyidEqualTo(family.getId());

		// 使用 memberdao.selectByExample(example)方法查询所有familyid为当前用户id的家庭成员

		List memberall = memberdao.selectByExample(example);

		// 将查询的家庭成员数据保存到request中的 memberall参数中

		request.setAttribute("memberall", memberall);
	}

	// 定义familyaddmemberact，响应页面添加请求

	public void familyaddmemberact(HttpServletRequest request, HttpSession session, Member member,
			MultipartFile avatarfile) throws IOException {

		// 输出日志，表示当前正在执行方法为MemberService.familyaddmemberact

		logger.debug("MemberService.familyaddmemberact ......");

		// 判断头像文件是否为空

		if (!avatarfile.isEmpty()) {

			// 调用uploadUtile方法将页面传入的头像文件上传到服务器，将返回的文件名保存到avatar参数中

			String avatar = uploadUtile(avatarfile, request);

			// 将member的头像设置为avatar的值

			member.setAvatar(avatar);

		}

		// 使用mybatis逆向工程所提供的insert方法添加家庭成员数据到数据库中

		memberdao.insert(member);

		// 将添加家庭成员成功的信息保存到request中，在页面中进行初始化

		request.setAttribute("message", "添加家庭成员成功");

	}

	// 定义addmemberact方法

	public void addmemberact(HttpServletRequest request, HttpSession session, Member member, MultipartFile avatarfile)
			throws IOException {

		// 输出当前方法日志，表示正在执行MemberService.addmemberact方法

		logger.debug("MemberService.addmemberact ......");

		// 判断头像文件是否为空

		if (!avatarfile.isEmpty()) {

			// 调用uploadUtile方法将页面传入的头像文件上传到服务器，将返回的文件名保存到avatar参数中

			String avatar = uploadUtile(avatarfile, request);

			// 将member的头像设置为avatar的值

			member.setAvatar(avatar);

		}

		// 使用memberdao的insert方法将家庭成员添加到数据库中

		memberdao.insert(member);

		// 将添加家庭成员信息添加到request中用message参数进行保存

		request.setAttribute("message", "添加家庭成员成功");

	} // 定义addmemberactjson方法

	public void addmemberactjson(Member member) throws IOException {

		// 输出当前方法日志，表示正在执行MemberService.addmemberactjson方法

		logger.debug("MemberService.addmemberactjson ......");

		// 使用memberdao的insert方法将家庭成员添加到数据库中

		memberdao.insert(member);

	}

	// 定义membermanage方法响应页面请求

	public void membermanage(HttpServletRequest request, HttpSession session) {

		// 输出日志，表示当前正在执行MemberService.membermanage

		logger.debug("MemberService.membermanage ......");

		// 实例化MemberExample类为example

		MemberExample example = new MemberExample();

		// 使用 memberdao.selectByExample(example)方法获取所有的家庭成员数据

		List memberall = memberdao.selectByExample(example);

		// 将所有的家庭成员数据保存到request中的memberall参数里

		request.setAttribute("memberall", memberall);

	}

	// 定义 memberview方法

	public void memberview(HttpServletRequest request, HttpSession session) {

		// 输出日志，表示当前正在执行MemberService.memberview方法

		logger.debug("MemberService.memberview ......");

		// 实例化MemberExample类

		MemberExample example = new MemberExample();

		// 使用memberdao的selectByExample方法查询家庭成员信息

		List memberall = memberdao.selectByExample(example);

		// 将查询的memberall保存到request中，记录为参数memberall

		request.setAttribute("memberall", memberall);

	}

	// 定义 updatemember方法

	public void updatemember(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志MemberController.updatemember，表示正在执行该方法

		logger.debug("MemberController.updatemember ......");

		// 定义家庭成员为biaoming，使用 memberdao的selectByPrimaryKey方法通过id查询数据

		Member member = memberdao.selectByPrimaryKey(id);

		// 定义 example1为 FamilyExample的实例

		FamilyExample example1 = new FamilyExample();

		// 定义familyall的List使用 familydao的selectByExample方法查询所有家庭成员数据

		List familyall = familydao.selectByExample(example1);

		// 将上面查询到的家庭成员数据保存到request中，返回页面

		request.setAttribute("familyall", familyall);

		// 定义 example2为 MemberExample的实例

		MemberExample example2 = new MemberExample();

		// 定义memberall的List使用 memberdao的selectByExample方法查询所有家庭成员数据

		List memberall = memberdao.selectByExample(example2);

		// 将上面查询到的家庭成员数据保存到request中，返回页面

		request.setAttribute("memberall", memberall);

		// 将查询的家庭成员保存到request中

		request.setAttribute("member", member);

	}

	// 定义updatememberact处理家庭成员修改

	public void updatememberact(HttpServletRequest request, Member member, HttpSession session,
			MultipartFile avatarfile) throws IOException {

		// 输出日志，表示正在执行当前方法MemberController.updatememberact

		logger.debug("MemberController.updatememberact ......");

		// 判断头像文件是否为空

		if (!avatarfile.isEmpty()) {

			// 调用uploadUtile方法将页面传入的头像文件上传到服务器，将返回的文件名保存到avatar参数中

			String avatar = uploadUtile(avatarfile, request);

			// 将member的头像设置为avatar的值

			member.setAvatar(avatar);

		}

		// 执行memberdao的updateByPrimaryKeySelective方法，将传入的家庭成员数据同步到数据库中

		memberdao.updateByPrimaryKeySelective(member);

		// 将修改成功信息保存到request中

		request.setAttribute("message", "修改家庭成员信息成功");

	} // 定义updatememberactjson处理家庭成员修改

	public void updatememberactjson(Member member) throws IOException {

		// 输出日志，表示正在执行当前方法MemberController.updatememberactjson

		logger.debug("MemberController.updatememberactjson ......");

		// 执行memberdao的updateByPrimaryKeySelective方法，将传入的家庭成员数据同步到数据库中

		memberdao.updateByPrimaryKeySelective(member);

	}

	// 定义familyupdatememberact方法

	public void familyupdatememberact(HttpServletRequest request, Member member, HttpSession session,
			MultipartFile avatarfile) throws IOException {

		// 当执行此方法时，输出此日志

		logger.debug("MemberService.familyupdatememberact ......");

		// 判断头像文件是否为空

		if (!avatarfile.isEmpty()) {

			// 调用uploadUtile方法将页面传入的头像文件上传到服务器，将返回的文件名保存到avatar参数中

			String avatar = uploadUtile(avatarfile, request);

			// 将member的头像设置为avatar的值

			member.setAvatar(avatar);

		}

		// 调用memberdao的updateByPrimaryKeySelective方法修改传入的member

		memberdao.updateByPrimaryKeySelective(member);

		request.setAttribute("message", "修改家庭成员信息成功");

	}

	// 定义deletemember,处理删除家庭成员

	public void deletemember(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志，表示当前正在执行MemberService.deletemember方法

		logger.debug("MemberService.deletemember ......");

		// 如果传入的id为-1，表示进行批量删除
		if (id == -1) {
			// 实例化家庭成员example
			MemberExample example = new MemberExample();
			// 获取到传递过来的ids数据信息
			String ids = request.getParameter("ids");
			// 为id信息添加-1数据，添加此数据可以防止数据为空时的报错
			ids += "-1,";
			// 截取掉多余的逗号
			ids.substring(0, ids.length() - 1);
			// 设置where语句进行删除id数据的传入
			// example.setWhere("id in ("+ ids +")");
			// 实例化家庭成员criteria
			MemberExample.Criteria criteria = example.createCriteria();
			// 设置integer类型的数组，保存需要删除的家庭成员id信息
			List<Integer> idlist = new ArrayList();
			// 根据id分离出需要删除的数据id信息
			String[] idarr = ids.split(",");
			// 将对应的id数据信息保存到数组中
			for (int i = 0; i < idarr.length; i++) {
				// 取出对应的id信息，并转换成int类型
				idlist.add(Integer.parseInt(idarr[i]));
			}
			// 传入需要删除的id数组信息
			criteria.andIdIn(idlist);
			// 调用家庭成员的dao类，执行批量删除操作
			memberdao.deleteByExample(example);
		} else {
			// 根据id调用memberdao的deleteByPrimaryKey方法，删除家庭成员

			memberdao.deleteByPrimaryKey(id);

		}

		request.setAttribute("message", "删除家庭成员成功");

	}

	// 定义familydeletemember方法

	public void familydeletemember(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志，表示当前正在执行MemberController.familydeletemember方法

		logger.debug("MemberController.familydeletemember ......");

		// 调用memberdao的deleteByPrimaryKey方法，传入id。删除id所对应的家庭成员

		memberdao.deleteByPrimaryKey(id);

		// 将删除家庭成员成功信息保存到request中

		request.setAttribute("message", "删除家庭成员成功");

	}

	// 定义searchmember方法，处理搜索操作

	public void searchmember(HttpServletRequest request, HttpSession session, String search) {

		// 输出日志，表示当前正在执行MemberService.searchmember

		logger.debug("MemberService.searchmember ......");

		// 实例化 MemberExample

		MemberExample example = new MemberExample();

		// 实例化 MemberExample的Criteria内部类

		MemberExample.Criteria criteria = example.createCriteria();

		// 如果搜索内容不等于空

		if (search != null) {

			// 将搜索内容通过like关键字传到数据库中进行搜索

			criteria.andAvatarLike("%" + search + "%");

		}

		// 查询家庭成员结果

		List memberall = memberdao.selectByExample(example);

		// 将查询到的家庭成员 保存到request中进行保存

		request.setAttribute("memberall", memberall);

	}

	// 定义searchmemberjson方法，处理搜索操作

	public Map searchmemberjson(String search) {

		// 输出日志，表示当前正在执行MemberService.searchmemberjson

		logger.debug("MemberService.searchmemberjson ......");

		// 定义返回结果

		Map result = new HashMap();

		// 实例化 MemberExample

		MemberExample example = new MemberExample();

		// 实例化 MemberExample的Criteria内部类

		MemberExample.Criteria criteria = example.createCriteria();

		// 如果搜索内容不等于空

		if (search != null) {

			// 将搜索内容通过like关键字传到数据库中进行搜索

			criteria.andAvatarLike("%" + search + "%");

		}

		// 查询家庭成员结果

		List memberall = memberdao.selectByExample(example);

		// 将查询到的家庭成员 保存到request中进行保存

		result.put("memberall", memberall);

		// 返回查询结果resultmap

		return result;

	}

	// 定义MemberpinglunMapper

	public void memberdetails(HttpServletRequest request, HttpSession session, int id) {

		// 输入日志信息，表名当前执行方法为MemberController.memberdetails

		logger.debug("MemberController.memberdetails ......");

		// 传入页面所传入的家庭成员id使用memberdao的selectByPrimaryKey方法进行查询

		Member member = memberdao.selectByPrimaryKey(id);

		// 将查询到的家庭成员保存到request中

		request.setAttribute("member", member);

	}

	// 定义Member详情方法

	public Map memberdetailsjson(int id) {

		// 输入日志信息，表名当前执行方法为MemberController.memberdetailsjson

		logger.debug("MemberController.memberdetailsjson ......");

		// 定义返回结果

		Map result = new HashMap();

		// 传入页面所传入的家庭成员id使用memberdao的selectByPrimaryKey方法进行查询

		Member member = memberdao.selectByPrimaryKey(id);

		// 将查询到的家庭成员保存到result中

		result.put("member", member);

		// 返回查询结果resultmap

		return result;

	}

	// 上传文件图片等

	public String uploadUtile(MultipartFile file, HttpServletRequest request) throws IOException {

		// 根据当前时间生成时间字符串

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");

		String res = sdf.format(new Date());

		// uploads文件夹位置

		String rootPath = request.getSession().getServletContext().getRealPath("resource/uploads/");

		// 原始名称

		String originalFileName = file.getOriginalFilename();

		// 新文件名

		String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));

		// 创建年月文件夹

		Calendar date = Calendar.getInstance();

		File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH) + 1));

		// 新文件

		File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);

		// 判断目标文件所在目录是否存在

		if (!newFile.getParentFile().exists()) {

			// 如果目标文件所在的目录不存在，则创建父目录

			newFile.getParentFile().mkdirs();

		}

		System.out.println(newFile);

		// 将内存中的数据写入磁盘

		file.transferTo(newFile);

		// 完整的url

		String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + newFileName;

		return fileUrl;

	}
}
