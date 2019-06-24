package com.graduate.Controller;

/**
 * @author 潘广
 * @time 2019-2-26
 * @功能  登陆
 */
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduate.Entity.Login;
import com.graduate.Entity.Loginlog;
import com.graduate.Entity.SystemLog;
import com.graduate.Service.imp.LoginLogServiceImp;
import com.graduate.Service.imp.LoginServiceImp;
import com.graduate.Service.imp.SystemLogImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@Api(value = "v1/api", tags = "Login/登陆界面接口")
public class LoginController {
	@Autowired
	LoginServiceImp loginServiceImp;
	@Autowired
	LoginLogServiceImp loginLogServiceImp;
	@Autowired
	SystemLogImp systemLogImp;

	private Log log = LogFactory.getLog(LoginController.class);

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	@ApiIgnore
	public String test() {
		log.info("进入登陆Controller......");
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = { "/validation" }, method = RequestMethod.POST)
	@ApiOperation(value = "登陆界面的后台效验接口", notes = "0-用户不存在/1-密码错误/2-登陆成功")
	// 参数绑定修改完成
	public Object logindata(HttpServletRequest request, HttpServletResponse httpServletResponse, Login login) {
		String account = login.getAccount();
		String password = login.getPassword();
		// String account = request.getParameter("account");
		// String password = request.getParameter("password");
		Map<String, String> data = new HashMap<String, String>();
		if (loginServiceImp.selectByPrimaryKey(account) == null) {
			data.put("stateCode", "0");
			return data;
		} else if (!loginServiceImp.selectByPrimaryKey(account).getPassword().equals(password)) {
			data.put("stateCode", "1");
			return data;
		} else {

			String ip = request.getRemoteAddr();
			String port = Integer.toString(request.getRemotePort());
			Loginlog loginlog = new Loginlog();

			loginlog.setIp(ip);
			loginlog.setPort(port);
			loginlog.setAccount(account);
			loginlog.setTime(new Date());

			loginLogServiceImp.insert(loginlog);

			request.getSession().setAttribute("account", account);
			data.put("stateCode", "2");

			SystemLog systemLog = new SystemLog();
			// 这里设置ID是根据端口号来，但是为了防止端口号相同插入数据库出现错误，加了个随机数。
			systemLog.setId(Integer.parseInt(loginLogServiceImp.listByparam(account).get(0).getPort())
					+ ((int) (Math.random() * 99 + 10)));
			systemLog.setContent("登陆成功");
			systemLog.setUsername(account);
			systemLog.setTime(loginLogServiceImp.listByparam(account).get(0).getTime());
			systemLog.setClientip(ip);
			systemLogImp.insert(systemLog);
			return data;
		}

	}

	@ApiIgnore
	@RequestMapping(value = { "/admin/loginout" }, method = RequestMethod.GET)
	public String loginout(HttpServletRequest request) {

		log.info("退出当前操作系统........移除服务器session里面所有key");

		request.getSession().removeAttribute("account");

		//

		request.getSession().removeAttribute("count");
		request.getSession().removeAttribute("ip");
		request.getSession().removeAttribute("lasttime");
		request.getSession().removeAttribute("sum");
		request.getSession().removeAttribute("hostname");
		request.getSession().removeAttribute("port");
		request.getSession().removeAttribute("currenttime");
		request.getSession().removeAttribute("hostIp");

		return "redirect:/login";
	}

	// 0表示注册成功,1表示已经注册
	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "登陆界面的注册接口", notes = "0表示注册成功,1表示已经注册")
	// 参数绑定完成
	public Map<String, String> signpage(HttpServletRequest request, Login login, HttpServletResponse response)
			throws IOException {
		String account = login.getAccount();
		String password = login.getPassword();
		// String account = request.getParameter("account");
		// String password = request.getParameter("password");
		Login record = null;
		Map<String, String> data = new HashMap<String, String>();

		if (loginServiceImp.selectByPrimaryKey(account) == null) {

			record = new Login();
			record.setAccount(account);
			record.setPassword(password);
			loginServiceImp.insert(record);
			data.put("stateCode", "0");
			return data;

		} else {
			data.put("stateCode", "1");

			return data;
		}

	}

}
