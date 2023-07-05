package org.spring.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.domain.Family;
import org.spring.springboot.service.FamilyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping(value = "/")

public class FamilyController {

	private static final Log logger = LogFactory.getLog(FamilyController.class);

	@Autowired
	private FamilyServiceImp familyservice;



	@RequestMapping(value = "addfamily")

	public String addfamily(HttpServletRequest request, HttpServletResponse response, HttpSession session) {



		logger.debug("FamilyController.addfamily ......");

		familyservice.addfamily(request, session);

		return "addfamily";

	}



	@RequestMapping(value = "addfamilyact")

	public String addfamilyact(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			Family family) throws IOException {



		logger.debug("FamilyController.addfamilyact ......");

		familyservice.addfamilyact(request, session, family);

		return "forward:/familymanage.action";

	}

	@ResponseBody


	@RequestMapping(value = "addfamilyactjson")

	public String addfamilyactjson(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			@RequestBody Family family) throws IOException {



		logger.debug("FamilyController.addfamilyactjson ......");



		familyservice.addfamilyactjson(family);



		return "success";

	}



	@RequestMapping(value = "familymanage")

	public String familymanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {



		logger.debug("FamilyController.familymanage ......");

		familyservice.familymanage(request, session);
		return "familymanage";

	}



	@RequestMapping(value = "familyview")

	public String familyview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {



		logger.debug("FamilyController.familyview ......");

		familyservice.familyview(request, session);



		return "familyview";

	}



	@RequestMapping(value = "updatefamily")

	public String updatefamily(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {



		logger.debug("FamilyController.updatefamily ......");

		familyservice.updatefamily(request, session, id);

		return "updatefamily";

	}



	@RequestMapping(value = "updatefamilyact")

	public String updatefamilyact(HttpServletRequest request, HttpServletResponse response, Family family,
			HttpSession session) throws IOException {



		logger.debug("FamilyController.updatefamilyact ......");

		familyservice.updatefamilyact(request, family, session);



		return "forward:/familymanage.action";

	}

	@ResponseBody


	@RequestMapping(value = "updatefamilyactjson")

	public String updatefamilyactjson(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Family family, HttpSession session) throws IOException {



		logger.debug("FamilyController.updatefamilyactjson ......");

		familyservice.updatefamilyactjson(family);

		return "success";

	}



	@RequestMapping(value = "deletefamily")

	public String deletefamily(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {



		logger.debug("FamilyController.deletefamily ......");

		familyservice.deletefamily(request, session, id);



		return "forward:/familymanage.action";

	}

	@ResponseBody


	@RequestMapping(value = "deletefamilyjson")

	public String deletefamilyjson(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			int id) {



		logger.debug("FamilyController.deletefamily ......");

		familyservice.deletefamily(request, session, id);

		return "success";

	}



	@RequestMapping(value = "searchfamily")

	public String searchfamily(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String search) {



		logger.debug("FamilyController.searchfamily ......");

		familyservice.searchfamily(request, session, search);

		return "searchfamily";

	}

	@ResponseBody

	@RequestMapping(value = "searchfamilyjson")

	public Map searchfamilyjson(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String search) {


		logger.debug("FamilyController.searchfamilyjson ......");



		Map result = new HashMap();



		result = familyservice.searchfamilyjson(search);

		return result;

	}



	@RequestMapping(value = "familydetails")

	public String familydetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {


		logger.debug("FamilyController.familydetails ......");

		familyservice.familydetails(request, session, id);

		return "familydetails";

	}

	@ResponseBody


	@RequestMapping(value = "familydetailsjson")

	public Map familydetailsjson(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			int id) {



		logger.debug("FamilyController.familydetailsjson ......");

		Map result = new HashMap();

		result = familyservice.familydetailsjson(id);

		// 将结果以json返回

		return result;

	}

}
