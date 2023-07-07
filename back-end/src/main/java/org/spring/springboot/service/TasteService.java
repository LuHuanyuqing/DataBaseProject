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
import org.spring.springboot.dao.FortMapper;
import org.spring.springboot.dao.TasteMapper;
import org.spring.springboot.dao.WaterdropMapper;
import org.spring.springboot.domain.Fort;
import org.spring.springboot.domain.FortExample;
import org.spring.springboot.domain.Taste;
import org.spring.springboot.domain.TasteExample;
import org.spring.springboot.domain.Waterdrop;
import org.spring.springboot.domain.WaterdropExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service

public class TasteService implements TasteServiceImp {


    private static final Log logger = LogFactory.getLog(TasteService.class);

    @Autowired
    private TasteMapper tastedao;
// 定义waterdropdao参数  


    @Autowired
    private WaterdropMapper waterdropdao;
// 定义fortdao参数  


    @Autowired
    private FortMapper fortdao;


     //定义addtasteactjson方法

    public void addtasteactjson(Taste taste) throws IOException {

        //输出当前方法日志，表示正在执行TasteService.addtasteactjson方法

        logger.debug("TasteService.addtasteactjson ......");

        Waterdrop waterdrop = waterdropdao.selectByPrimaryKey(taste.getWaterdropid());
        taste.setFort(waterdrop.getFort());
        taste.setFortid(waterdrop.getFortid());

        taste.setState(1);

        //使用tastedao的insert方法将成员事件添加到数据库中

        tastedao.insert(taste);

    }


     // 定义updatetasteactjson处理成员事件修改

    public void updatetasteactjson(Taste taste) throws IOException {

        // 输出日志，表示正在执行当前方法TasteController.updatetasteactjson

        logger.debug("TasteController.updatetasteactjson ......");

        Waterdrop waterdrop = waterdropdao.selectByPrimaryKey(taste.getWaterdropid());
        taste.setFort(waterdrop.getFort());
        taste.setFortid(waterdrop.getFortid());

        // 执行tastedao的updateByPrimaryKeySelective方法，将传入的成员事件数据同步到数据库中

        tastedao.updateByPrimaryKeySelective(taste);

    }





    // 定义deletetaste,处理删除成员事件

    public void deletetaste(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行TasteService.deletetaste方法

        logger.debug("TasteService.deletetaste ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化成员事件example
            TasteExample example = new TasteExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化成员事件criteria
            TasteExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的成员事件id信息
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
            //调用成员事件的dao类，执行批量删除操作
            tastedao.deleteByExample(example);
        } else {
            Taste taste = tastedao.selectByPrimaryKey(id);
            taste.setState(0);
            tastedao.updateByPrimaryKeySelective(taste);
        }


        request.setAttribute("message", "删除成员事件成功");


    }








    // 定义searchtastejson方法，处理搜索操作

    public Map searchtastejson(String search) {

        // 输出日志，表示当前正在执行TasteService.searchtastejson

        logger.debug("TasteService.searchtastejson ......");

        // 定义返回结果

        Map result = new HashMap();

        // 实例化 TasteExample

        TasteExample example = new TasteExample();

        // 实例化 TasteExample的Criteria内部类

        TasteExample.Criteria criteria = example.createCriteria();

        criteria.andStateEqualTo(1);

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andWaterdropLike("%" + search + "%");

        }

        // 查询成员事件结果

        List tasteall = tastedao.selectByExample(example);

        // 将查询到的成员事件 保存到request中进行保存

        result.put("tasteall", tasteall);

        // 返回查询结果resultmap

        return result;

    }





    // 定义Taste详情方法

    public Map tastedetailsjson(int id) {

        // 输入日志信息，表名当前执行方法为TasteController.tastedetailsjson

        logger.debug("TasteController.tastedetailsjson ......");


        // 定义返回结果

        Map result = new HashMap();

        // 传入页面所传入的成员事件id使用tastedao的selectByPrimaryKey方法进行查询

        Taste taste = tastedao.selectByPrimaryKey(id);

        // 将查询到的成员事件保存到result中

        result.put("taste", taste);


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

