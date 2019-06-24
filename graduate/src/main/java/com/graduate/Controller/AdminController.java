package com.graduate.Controller;

/**
 * @author 潘广
 */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.graduate.Entity.Login;
import com.graduate.Entity.SystemLog;
import com.graduate.Service.imp.LoginLogServiceImp;
import com.graduate.Service.imp.LoginServiceImp;
import com.graduate.Service.imp.SystemLogImp;
import com.graduate.Utils.DateCovert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/main")
@Api(value = "v1/api", tags = "main/管理界面接口")
public class AdminController {
	@Autowired
	LoginLogServiceImp loginLogServiceimp;
	@Autowired
	LoginServiceImp loginService;
	@Autowired
	SystemLogImp systemLogImp;

	private Log log = LogFactory.getLog(AdminController.class);

	@ApiOperation(value = "后台管理界面的后台Desktop的数据初始化", notes = "@RequestMapping:/main/manage")
	@RequestMapping(value = { "/manage" }, method = RequestMethod.GET)
	@ApiIgnore
	public ModelAndView mainui(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("index");
		String ip = null;
		Date lasttime = null;

		String adminname = (String) request.getSession().getAttribute("account");
		// 登陆次数
		int count = loginLogServiceimp.countByname(adminname) - 1;
		// 上次登陆的ip
		if (count != 0) {
			// 上次登陆的IP
			ip = loginLogServiceimp.listByparam(adminname).get(1).getIp();
			// 上次登陆的时间
			lasttime = loginLogServiceimp.listByparam(adminname).get(1).getTime();
		} else {
			ip = "0.0.0.0";
			lasttime = new Date();
		}

		// 管理员总数
		int sum = loginService.countByExample(null);
		// 服务器计算机名字
		String hostname = request.getLocalName();
		// 服务器IP
		String hostIp = request.getLocalAddr();
		// 服务器端口
		int port = request.getLocalPort();
		// 服务器当前时间
		Date currenttime = new Date();
		String newDate = DateCovert.timeC(currenttime);
		String newlasttime = DateCovert.timeC(lasttime);
		// 1.放进po，2.放进session，3.单独每个属性放进session
		/*
		 * po.setAdminname(adminname); po.setCount(count);
		 * po.setCurrenttime(currenttime); po.setHostIp(hostIp);
		 * po.setHostname(hostname); po.setLasttime(lasttime); po.setPort(port);
		 * po.setSum(sum); po.setIp(hostIp);
		 */
		// recordPo welcomeIn = new recordPo();
		// welcomeIn.setCount(count);
		request.getSession().setAttribute("count", count);
		// welcomeIn.setIp(ip);
		request.getSession().setAttribute("ip", ip);
		// welcomeIn.setLasttime(newlasttime);
		request.getSession().setAttribute("lasttime", newlasttime);
		// welcomeIn.setSum(sum);
		request.getSession().setAttribute("sum", sum);
		// welcomeIn.setHostname(hostname);
		request.getSession().setAttribute("hostname", hostname);
		// welcomeIn.setPort(port);
		request.getSession().setAttribute("port", port);
		// welcomeIn.setCurrenttime(newDate);
		request.getSession().setAttribute("currenttime", newDate);
		// welcomeIn.setHostIp(hostIp);
		request.getSession().setAttribute("hostIp", hostIp);

		return model;

	}

	@ApiIgnore
	@RequestMapping("/welcomepage")
	public String welcomepage(HttpServletRequest request) {
		log.info("welcomepage映射地址........");
		/*
		 * HttpSession httpSession = request.getSession(); Object ob =
		 * httpSession.getAttribute("po"); modelAndView.addObject("new_po", ob);
		 */
		return "welcome";
	}

	@RequestMapping(value = { "/chart" }, method = RequestMethod.GET)
	@ApiOperation(value = "后台管理界面的后台统计图", notes = "@RequestMapping:/main/chart")
	public ModelAndView charcount(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("charts");
		Map<String, String> dataMap = new HashMap<String, String>();
		List<Login> loginlist = loginService.listAll();
		int i = loginlist.size();

		for (int j = 0; j < i; j++) {
			dataMap.put(loginlist.get(j).getAccount(),
					Integer.toString(loginLogServiceimp.countByname(loginlist.get(j).getAccount())));
		}

		modelAndView.addObject("dataMap", dataMap);

		return modelAndView;
	}

	@RequestMapping(value = { "/Systemlogin" }, method = { RequestMethod.GET })
	@ApiOperation(value = "后台管理界面的后台日志管理", notes = "@RequestMapping:/main/Systemlogin")
	public ModelAndView SystemLogin(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("system-log");
		List<SystemLog> slList = systemLogImp.listAll();
		int number = slList.size();
		modelAndView.addObject("number", number);
		modelAndView.addObject("slList", slList);

		return modelAndView;

	}

	@RequestMapping(value = { "/deleteSystem" }, method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "后台管理界面的登陆信息删除", notes = "@RequestMapping:/main/deleteSystem")
	public HashMap<String, String> deleteSystemlog(HttpServletRequest request) {
		int netpotrt = Integer.parseInt(request.getParameter("id"));
		HashMap<String, String> data = new HashMap<String, String>();
		int id = systemLogImp.deleteByPrimaryKey(netpotrt);
		if (id == 1) {
			data.put("success", "成功");
			return data;

		} else {
			data.put("error", "失败");
			return data;
		}

	}
}
