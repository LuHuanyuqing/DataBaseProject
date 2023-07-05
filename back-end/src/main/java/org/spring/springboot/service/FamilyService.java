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
import org.spring.springboot.domain.Family;
import org.spring.springboot.domain.FamilyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service

public class FamilyService implements FamilyServiceImp {

	private static final Log logger = LogFactory.getLog(FamilyService.class);

	@Autowired
	private FamilyMapper familydao;

	// 定义方法addfamily,响应控制层addfamily请求

	public void addfamily(HttpServletRequest request, HttpSession session) {

		// 输出日志，当前执行方法为addfamily

		logger.debug("FamilyService.addfamily ......");

	}

	// 定义addfamilyact方法

	public void addfamilyact(HttpServletRequest request, HttpSession session, Family family) throws IOException {

		// 输出当前方法日志，表示正在执行FamilyService.addfamilyact方法

		logger.debug("FamilyService.addfamilyact ......");

		// 使用familydao的insert方法将家族添加到数据库中

		familydao.insert(family);

		// 将添加家族信息添加到request中用message参数进行保存

		request.setAttribute("message", "添加家族成功");

	} // 定义addfamilyactjson方法

	public void addfamilyactjson(Family family) throws IOException {

		// 输出当前方法日志，表示正在执行FamilyService.addfamilyactjson方法

		logger.debug("FamilyService.addfamilyactjson ......");

		// 使用familydao的insert方法将家族添加到数据库中

		familydao.insert(family);

	}

	// 定义familymanage方法响应页面请求

	public void familymanage(HttpServletRequest request, HttpSession session) {

		// 输出日志，表示当前正在执行FamilyService.familymanage

		logger.debug("FamilyService.familymanage ......");

		// 实例化FamilyExample类为example

		FamilyExample example = new FamilyExample();

		// 使用 familydao.selectByExample(example)方法获取所有的家族数据

		List familyall = familydao.selectByExample(example);

		// 将所有的家族数据保存到request中的familyall参数里

		request.setAttribute("familyall", familyall);

	}

	// 定义 familyview方法

	public void familyview(HttpServletRequest request, HttpSession session) {

		// 输出日志，表示当前正在执行FamilyService.familyview方法

		logger.debug("FamilyService.familyview ......");

		// 实例化FamilyExample类

		FamilyExample example = new FamilyExample();

		// 使用familydao的selectByExample方法查询家族信息

		List familyall = familydao.selectByExample(example);

		// 将查询的familyall保存到request中，记录为参数familyall

		request.setAttribute("familyall", familyall);

	}

	// 定义 updatefamily方法

	public void updatefamily(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志FamilyController.updatefamily，表示正在执行该方法

		logger.debug("FamilyController.updatefamily ......");

		// 定义家族为biaoming，使用 familydao的selectByPrimaryKey方法通过id查询数据

		Family family = familydao.selectByPrimaryKey(id);

		// 将查询的家族保存到request中

		request.setAttribute("family", family);

	}

	// 定义updatefamilyact处理家族修改

	public void updatefamilyact(HttpServletRequest request, Family family, HttpSession session) throws IOException {

		// 输出日志，表示正在执行当前方法FamilyController.updatefamilyact

		logger.debug("FamilyController.updatefamilyact ......");

		// 执行familydao的updateByPrimaryKeySelective方法，将传入的家族数据同步到数据库中

		familydao.updateByPrimaryKeySelective(family);

		// 将修改成功信息保存到request中

		request.setAttribute("message", "修改家族信息成功");

	} // 定义updatefamilyactjson处理家族修改

	public void updatefamilyactjson(Family family) throws IOException {

		// 输出日志，表示正在执行当前方法FamilyController.updatefamilyactjson

		logger.debug("FamilyController.updatefamilyactjson ......");

		// 执行familydao的updateByPrimaryKeySelective方法，将传入的家族数据同步到数据库中

		familydao.updateByPrimaryKeySelective(family);

	}

	// 定义deletefamily,处理删除家族

	public void deletefamily(HttpServletRequest request, HttpSession session, int id) {

		// 输出日志，表示当前正在执行FamilyService.deletefamily方法

		logger.debug("FamilyService.deletefamily ......");

		// 如果传入的id为-1，表示进行批量删除
		if (id == -1) {
			// 实例化家族example
			FamilyExample example = new FamilyExample();
			// 获取到传递过来的ids数据信息
			String ids = request.getParameter("ids");
			// 为id信息添加-1数据，添加此数据可以防止数据为空时的报错
			ids += "-1,";
			// 截取掉多余的逗号
			ids.substring(0, ids.length() - 1);
			// 设置where语句进行删除id数据的传入
			// example.setWhere("id in ("+ ids +")");
			// 实例化家族criteria
			FamilyExample.Criteria criteria = example.createCriteria();
			// 设置integer类型的数组，保存需要删除的家族id信息
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
			// 调用家族的dao类，执行批量删除操作
			familydao.deleteByExample(example);
		} else {
			// 根据id调用familydao的deleteByPrimaryKey方法，删除家族

			familydao.deleteByPrimaryKey(id);

		}

		request.setAttribute("message", "删除家族成功");

	}

	// 定义searchfamily方法，处理搜索操作

	public void searchfamily(HttpServletRequest request, HttpSession session, String search) {

		// 输出日志，表示当前正在执行FamilyService.searchfamily

		logger.debug("FamilyService.searchfamily ......");

		// 实例化 FamilyExample

		FamilyExample example = new FamilyExample();

		// 实例化 FamilyExample的Criteria内部类

		FamilyExample.Criteria criteria = example.createCriteria();

		// 如果搜索内容不等于空

		if (search != null) {

			// 将搜索内容通过like关键字传到数据库中进行搜索

			criteria.andNameLike("%" + search + "%");

		}

		// 查询家族结果

		List familyall = familydao.selectByExample(example);

		// 将查询到的家族 保存到request中进行保存

		request.setAttribute("familyall", familyall);

	}

	// 定义searchfamilyjson方法，处理搜索操作

	public Map searchfamilyjson(String search) {

		// 输出日志，表示当前正在执行FamilyService.searchfamilyjson

		logger.debug("FamilyService.searchfamilyjson ......");

		// 定义返回结果

		Map result = new HashMap();

		// 实例化 FamilyExample

		FamilyExample example = new FamilyExample();

		// 实例化 FamilyExample的Criteria内部类

		FamilyExample.Criteria criteria = example.createCriteria();

		// 如果搜索内容不等于空

		if (search != null) {

			// 将搜索内容通过like关键字传到数据库中进行搜索

			criteria.andNameLike("%" + search + "%");

		}

		// 查询家族结果

		List familyall = familydao.selectByExample(example);

		// 将查询到的家族 保存到request中进行保存

		result.put("familyall", familyall);

		// 返回查询结果resultmap

		return result;

	}

	// 定义FamilypinglunMapper

	public void familydetails(HttpServletRequest request, HttpSession session, int id) {

		// 输入日志信息，表名当前执行方法为FamilyController.familydetails

		logger.debug("FamilyController.familydetails ......");

		// 传入页面所传入的家族id使用familydao的selectByPrimaryKey方法进行查询

		Family family = familydao.selectByPrimaryKey(id);

		// 将查询到的家族保存到request中

		request.setAttribute("family", family);

	}

	// 定义Family详情方法

	public Map familydetailsjson(int id) {

		// 输入日志信息，表名当前执行方法为FamilyController.familydetailsjson

		logger.debug("FamilyController.familydetailsjson ......");

		// 定义返回结果

		Map result = new HashMap();

		// 传入页面所传入的家族id使用familydao的selectByPrimaryKey方法进行查询

		Family family = familydao.selectByPrimaryKey(id);

		// 将查询到的家族保存到result中

		result.put("family", family);

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
