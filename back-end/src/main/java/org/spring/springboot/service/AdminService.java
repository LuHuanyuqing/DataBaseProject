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
import org.spring.springboot.dao.AdminMapper;
import org.spring.springboot.domain.Admin;
import org.spring.springboot.domain.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service

public class AdminService implements AdminServiceImp {


    private static final Log logger = LogFactory.getLog(AdminService.class);

    @Autowired
    private AdminMapper admindao;


     //定义addadminactjson方法

    public void addadminactjson(Admin admin) throws IOException {

        //输出当前方法日志，表示正在执行AdminService.addadminactjson方法

        logger.debug("AdminService.addadminactjson ......");

        admin.setState(1);

        //使用admindao的insert方法将管理员添加到数据库中

        admindao.insert(admin);

    }


     // 定义updateadminactjson处理管理员修改

    public void updateadminactjson(Admin admin) throws IOException {

        // 输出日志，表示正在执行当前方法AdminController.updateadminactjson

        logger.debug("AdminController.updateadminactjson ......");

        // 执行admindao的updateByPrimaryKeySelective方法，将传入的管理员数据同步到数据库中

        admindao.updateByPrimaryKeySelective(admin);

    }


    // 定义deleteadmin,处理删除管理员

    public void deleteadmin(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行AdminService.deleteadmin方法

        logger.debug("AdminService.deleteadmin ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化管理员example
            AdminExample example = new AdminExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化管理员criteria
            AdminExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的管理员id信息
            List<Integer> idlist = new ArrayList();
            //根据id分离出需要删除的数据id信息
            String[] idarr = ids.split(",");
            //将对应的id数据信息保存到数组中
            for (int i = 0; i < idarr.length; i++) {
                //取出对应的id信息，并转换成int类型
                idlist.add(Integer.parseInt(idarr[i]));
            }
            //传入需要删除的id数组信息
            criteria.andIdIn(idlist);
            //调用管理员的dao类，执行批量删除操作
            admindao.deleteByExample(example);
        } else {
            Admin admin = admindao.selectByPrimaryKey(id);
            admin.setState(0);
            admindao.updateByPrimaryKeySelective(admin);
        }


        request.setAttribute("message", "删除管理员成功");


    }





    // 定义searchadminjson方法，处理搜索操作

    public Map searchadminjson(String search) {

        // 输出日志，表示当前正在执行AdminService.searchadminjson

        logger.debug("AdminService.searchadminjson ......");

        // 定义返回结果

        Map result = new HashMap();

        // 实例化 AdminExample

        AdminExample example = new AdminExample();

        // 实例化 AdminExample的Criteria内部类

        AdminExample.Criteria criteria = example.createCriteria();

        criteria.andStateEqualTo(1);

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andUsernameLike("%" + search + "%");

        }

        // 查询管理员结果

        List adminall = admindao.selectByExample(example);

        // 将查询到的管理员 保存到request中进行保存

        result.put("adminall", adminall);

        // 返回查询结果resultmap

        return result;

    }





    // 定义Admin详情方法

    public Map admindetailsjson(int id) {

        // 输入日志信息，表名当前执行方法为AdminController.admindetailsjson

        logger.debug("AdminController.admindetailsjson ......");


        // 定义返回结果

        Map result = new HashMap();

        // 传入页面所传入的管理员id使用admindao的selectByPrimaryKey方法进行查询

        Admin admin = admindao.selectByPrimaryKey(id);

        // 将查询到的管理员保存到result中

        result.put("admin", admin);


        // 返回查询结果resultmap

        return result;

    }


//	上传文件图片等

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

