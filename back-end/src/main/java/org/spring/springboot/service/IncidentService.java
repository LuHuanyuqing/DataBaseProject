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
import org.spring.springboot.dao.IncidentMapper;
import org.spring.springboot.dao.MemberMapper;
import org.spring.springboot.domain.Family;
import org.spring.springboot.domain.FamilyExample;
import org.spring.springboot.domain.Incident;
import org.spring.springboot.domain.IncidentExample;
import org.spring.springboot.domain.Member;
import org.spring.springboot.domain.MemberExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service

public class IncidentService implements IncidentServiceImp {

	private static final Log logger = LogFactory.getLog(IncidentService.class);

	@Autowired
	private IncidentMapper incidentdao;
	// 定义memberdao参数

	@Autowired
	private MemberMapper memberdao;
	// 定义familydao参数

	@Autowired
	private FamilyMapper familydao;

	// 定义方法addincident,响应控制层addincident请求

	public void addincident(HttpServletRequest request, HttpSession session) {

		// 输出日志，当前执行方法为addincident

		logger.debug("IncidentService.addincident ......");

		// 定义 example1为 MemberExample的实例

		MemberExample example1 = new MemberExample();

		// 定义memberall的List使用 memberdao的selectByExample方法查询所有人员事件数据

		List memberall = memberdao.selectByExample(example1);

		// 将上面查询到的人员事件数据保存到request中，返回页面

		request.setAttribute("memberall", memberall);

		// 定义 example2为 FamilyExample的实例

		FamilyExample example2 = new FamilyExample();

		// 定义familyall的List使用 familydao的selectByExample方法查询所有人员事件数据

		List familyall = familydao.selectByExample(example2);

		// 将上面查询到的人员事件数据保存到request中，返回页面

		request.setAttribute("familyall", familyall);

	}

	// 定义familyaddincident方法，在人员事件控制层中调用

	public void familyaddincident(HttpServletRequest request, HttpSession session) {

		// 输出日志，表示当前正在执行IncidentService.familyaddincident方法

		logger.debug("IncidentService.familyaddincident ......");

		// 定义 example1为 MemberExample的实例

		MemberExample example1 = new MemberExample();

		// 定义memberall的List使用 memberdao的selectByExample方法查询所有人员事件数据

		List memberall = memberdao.selectByExample(example1);

		// 将上面查询到的人员事件数据保存到request中，返回页面

		request.setAttribute("memberall", memberall);

		// 定义 example2为 FamilyExample的实例

		FamilyExample example2 = new FamilyExample();

		// 定义familyall的List使用 familydao的selectByExample方法查询所有人员事件数据

		List familyall = familydao.selectByExample(example2);

		// 将上面查询到的人员事件数据保存到request中，返回页面

		request.setAttribute("familyall", familyall);

	}

	// 定义familyupdateincident方法

	public void familyupdateincident(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志IncidentService.familyupdateincident

		logger.debug("IncidentService.familyupdateincident ......");

		// 实例化人员事件,使用incidentdao的selectByPrimaryKey方法通过id查询人员事件

		Incident incident = incidentdao.selectByPrimaryKey(id);

		// 定义 example1为 MemberExample的实例

		MemberExample example1 = new MemberExample();

		// 定义memberall的List使用 memberdao的selectByExample方法查询所有人员事件数据

		List memberall = memberdao.selectByExample(example1);

		// 将上面查询到的人员事件数据保存到request中，返回页面

		request.setAttribute("memberall", memberall);

		// 定义 example2为 FamilyExample的实例

		FamilyExample example2 = new FamilyExample();

		// 定义familyall的List使用 familydao的selectByExample方法查询所有人员事件数据

		List familyall = familydao.selectByExample(example2);

		// 将上面查询到的人员事件数据保存到request中，返回页面

		request.setAttribute("familyall", familyall);

		// 将查询出的人员事件信息保存到request中

		request.setAttribute("incident", incident);

	}

	// 定义familyincidentmanage方法

	public void familyincidentmanage(HttpServletRequest request, HttpSession session) {

		// 输出日志 ，表示当前正在执行方法为IncidentService.familyincidentmanage

		logger.debug("IncidentService.familyincidentmanage ......");

		// 定义实体，从session中获取当前用户，赋值给

		Family family = (Family) session.getAttribute("userinfo");

		// 实例化人员事件类为example

		IncidentExample example = new IncidentExample();

		// 实例化人员事件Example类的criteria

		IncidentExample.Criteria criteria = example.createCriteria();

		// 通过 criteria设置查询条件Familyid为当前用户id

		criteria.andFamilyidEqualTo(family.getId());

		// 使用 incidentdao.selectByExample(example)方法查询所有familyid为当前用户id的人员事件

		List incidentall = incidentdao.selectByExample(example);

		// 将查询的人员事件数据保存到request中的 incidentall参数中

		request.setAttribute("incidentall", incidentall);
	}

	// 定义familyaddincidentact，响应页面添加请求

	public void familyaddincidentact(HttpServletRequest request, HttpSession session, Incident incident)
			throws IOException {

		// 输出日志，表示当前正在执行方法为IncidentService.familyaddincidentact

		logger.debug("IncidentService.familyaddincidentact ......");

		// 使用mybatis逆向工程所提供的insert方法添加人员事件数据到数据库中

		incidentdao.insert(incident);

		// 将添加人员事件成功的信息保存到request中，在页面中进行初始化

		request.setAttribute("message", "添加人员事件成功");

	}

	// 定义addincidentact方法

	public void addincidentact(HttpServletRequest request, HttpSession session, Incident incident) throws IOException {

		// 输出当前方法日志，表示正在执行IncidentService.addincidentact方法

		logger.debug("IncidentService.addincidentact ......");

		// 使用incidentdao的insert方法将人员事件添加到数据库中

		incidentdao.insert(incident);

		// 将添加人员事件信息添加到request中用message参数进行保存

		request.setAttribute("message", "添加人员事件成功");

	}

	// 定义addincidentactjson方法
	public void addincidentactjson(Incident incident) throws IOException {
		// 输出当前方法日志，表示正在执行IncidentService.addincidentactjson方法
		logger.debug("IncidentService.addincidentactjson ......");

		Member member = memberdao.selectByPrimaryKey(incident.getMemberrid());
		incident.setFamily(member.getFamily());
		incident.setFamilyid(member.getFamilyid());

		// 使用incidentdao的insert方法将人员事件添加到数据库中
		incidentdao.insert(incident);
	}

	// 定义incidentmanage方法响应页面请求

	public void incidentmanage(HttpServletRequest request, HttpSession session) {

		// 输出日志，表示当前正在执行IncidentService.incidentmanage

		logger.debug("IncidentService.incidentmanage ......");

		// 实例化IncidentExample类为example

		IncidentExample example = new IncidentExample();

		// 使用 incidentdao.selectByExample(example)方法获取所有的人员事件数据

		List incidentall = incidentdao.selectByExample(example);

		// 将所有的人员事件数据保存到request中的incidentall参数里

		request.setAttribute("incidentall", incidentall);

	}

	// 定义 incidentview方法

	public void incidentview(HttpServletRequest request, HttpSession session) {

		// 输出日志，表示当前正在执行IncidentService.incidentview方法

		logger.debug("IncidentService.incidentview ......");

		// 实例化IncidentExample类

		IncidentExample example = new IncidentExample();

		// 使用incidentdao的selectByExample方法查询人员事件信息

		List incidentall = incidentdao.selectByExample(example);

		// 将查询的incidentall保存到request中，记录为参数incidentall

		request.setAttribute("incidentall", incidentall);

	}

	// 定义 updateincident方法

	public void updateincident(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志IncidentController.updateincident，表示正在执行该方法

		logger.debug("IncidentController.updateincident ......");

		// 定义人员事件为biaoming，使用 incidentdao的selectByPrimaryKey方法通过id查询数据

		Incident incident = incidentdao.selectByPrimaryKey(id);

		// 定义 example1为 MemberExample的实例

		MemberExample example1 = new MemberExample();

		// 定义memberall的List使用 memberdao的selectByExample方法查询所有人员事件数据

		List memberall = memberdao.selectByExample(example1);

		// 将上面查询到的人员事件数据保存到request中，返回页面

		request.setAttribute("memberall", memberall);

		// 定义 example2为 FamilyExample的实例

		FamilyExample example2 = new FamilyExample();

		// 定义familyall的List使用 familydao的selectByExample方法查询所有人员事件数据

		List familyall = familydao.selectByExample(example2);

		// 将上面查询到的人员事件数据保存到request中，返回页面

		request.setAttribute("familyall", familyall);

		// 将查询的人员事件保存到request中

		request.setAttribute("incident", incident);

	}

	// 定义updateincidentact处理人员事件修改

	public void updateincidentact(HttpServletRequest request, Incident incident, HttpSession session)
			throws IOException {

		// 输出日志，表示正在执行当前方法IncidentController.updateincidentact

		logger.debug("IncidentController.updateincidentact ......");

		// 执行incidentdao的updateByPrimaryKeySelective方法，将传入的人员事件数据同步到数据库中

		incidentdao.updateByPrimaryKeySelective(incident);

		// 将修改成功信息保存到request中

		request.setAttribute("message", "修改人员事件信息成功");

	} // 定义updateincidentactjson处理人员事件修改

	public void updateincidentactjson(Incident incident) throws IOException {

		// 输出日志，表示正在执行当前方法IncidentController.updateincidentactjson

		logger.debug("IncidentController.updateincidentactjson ......");

		// 执行incidentdao的updateByPrimaryKeySelective方法，将传入的人员事件数据同步到数据库中

		incidentdao.updateByPrimaryKeySelective(incident);

	}

	// 定义familyupdateincidentact方法

	public void familyupdateincidentact(HttpServletRequest request, Incident incident, HttpSession session)
			throws IOException {

		// 当执行此方法时，输出此日志

		logger.debug("IncidentService.familyupdateincidentact ......");

		// 调用incidentdao的updateByPrimaryKeySelective方法修改传入的incident

		incidentdao.updateByPrimaryKeySelective(incident);

		request.setAttribute("message", "修改人员事件信息成功");

	}

	// 定义deleteincident,处理删除人员事件

	public void deleteincident(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志，表示当前正在执行IncidentService.deleteincident方法

		logger.debug("IncidentService.deleteincident ......");

		// 如果传入的id为-1，表示进行批量删除
		if (id == -1) {
			// 实例化人员事件example
			IncidentExample example = new IncidentExample();
			// 获取到传递过来的ids数据信息
			String ids = request.getParameter("ids");
			// 为id信息添加-1数据，添加此数据可以防止数据为空时的报错
			ids += "-1,";
			// 截取掉多余的逗号
			ids.substring(0, ids.length() - 1);
			// 设置where语句进行删除id数据的传入
			// example.setWhere("id in ("+ ids +")");
			// 实例化人员事件criteria
			IncidentExample.Criteria criteria = example.createCriteria();
			// 设置integer类型的数组，保存需要删除的人员事件id信息
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
			// 调用人员事件的dao类，执行批量删除操作
			incidentdao.deleteByExample(example);
		} else {
			// 根据id调用incidentdao的deleteByPrimaryKey方法，删除人员事件

			incidentdao.deleteByPrimaryKey(id);

		}

		request.setAttribute("message", "删除人员事件成功");

	}

	// 定义familydeleteincident方法

	public void familydeleteincident(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志，表示当前正在执行IncidentController.familydeleteincident方法

		logger.debug("IncidentController.familydeleteincident ......");

		// 调用incidentdao的deleteByPrimaryKey方法，传入id。删除id所对应的人员事件

		incidentdao.deleteByPrimaryKey(id);

		// 将删除人员事件成功信息保存到request中

		request.setAttribute("message", "删除人员事件成功");

	}

	// 定义searchincident方法，处理搜索操作

	public void searchincident(HttpServletRequest request, HttpSession session, String search) {

		// 输出日志，表示当前正在执行IncidentService.searchincident

		logger.debug("IncidentService.searchincident ......");

		// 实例化 IncidentExample

		IncidentExample example = new IncidentExample();

		// 实例化 IncidentExample的Criteria内部类

		IncidentExample.Criteria criteria = example.createCriteria();

		// 如果搜索内容不等于空

		if (search != null) {

			// 将搜索内容通过like关键字传到数据库中进行搜索

			criteria.andMemberrLike("%" + search + "%");

		}

		// 查询人员事件结果

		List incidentall = incidentdao.selectByExample(example);

		// 将查询到的人员事件 保存到request中进行保存

		request.setAttribute("incidentall", incidentall);

	}

	// 定义searchincidentjson方法，处理搜索操作

	public Map searchincidentjson(String search) {

		// 输出日志，表示当前正在执行IncidentService.searchincidentjson

		logger.debug("IncidentService.searchincidentjson ......");

		// 定义返回结果

		Map result = new HashMap();

		// 实例化 IncidentExample

		IncidentExample example = new IncidentExample();

		// 实例化 IncidentExample的Criteria内部类

		IncidentExample.Criteria criteria = example.createCriteria();

		// 如果搜索内容不等于空

		if (search != null) {

			// 将搜索内容通过like关键字传到数据库中进行搜索

			criteria.andMemberrLike("%" + search + "%");

		}

		// 查询人员事件结果

		List incidentall = incidentdao.selectByExample(example);

		// 将查询到的人员事件 保存到request中进行保存

		result.put("incidentall", incidentall);

		// 返回查询结果resultmap

		return result;

	}

	// 定义IncidentpinglunMapper

	public void incidentdetails(HttpServletRequest request, HttpSession session, int id) {

		// 输入日志信息，表名当前执行方法为IncidentController.incidentdetails

		logger.debug("IncidentController.incidentdetails ......");

		// 传入页面所传入的人员事件id使用incidentdao的selectByPrimaryKey方法进行查询

		Incident incident = incidentdao.selectByPrimaryKey(id);

		// 将查询到的人员事件保存到request中

		request.setAttribute("incident", incident);

	}

	// 定义Incident详情方法

	public Map incidentdetailsjson(int id) {

		// 输入日志信息，表名当前执行方法为IncidentController.incidentdetailsjson

		logger.debug("IncidentController.incidentdetailsjson ......");

		// 定义返回结果

		Map result = new HashMap();

		// 传入页面所传入的人员事件id使用incidentdao的selectByPrimaryKey方法进行查询

		Incident incident = incidentdao.selectByPrimaryKey(id);

		// 将查询到的人员事件保存到result中

		result.put("incident", incident);

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
