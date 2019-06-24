package com.graduate.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * @author 潘广
 */
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.identity.v3.Project;
import org.openstack4j.model.identity.v3.Role;
import org.openstack4j.model.identity.v3.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduate.Entity.OPO.ProjectPo;
import com.graduate.OpenStack.Keystone;

@Controller
@RequestMapping("/Super")
public class SuperController {
	private Log log = LogFactory.getLog(SuperController.class);

	@RequestMapping(value = { "/admin" }, method = { RequestMethod.GET })
	public String admin_project(HttpServletRequest request, Model model) {
		log.info("列出所有项目列表................");
		OSClientV3 os = Keystone.OS();
		List<? extends Project> projectList = os.identity().projects().list();
		model.addAttribute("projectList", projectList);
		return "admin-project";
	}

	@RequestMapping(value = { "/admin-projectDel" }, method = { RequestMethod.POST })
	@ResponseBody
	public HashMap<String, String> projectdel(HttpServletRequest request, Model model, ProjectPo po) {
		log.info("正在删除项目的信息.................");
		String id = po.getId();
		OSClientV3 os = Keystone.OS();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		ActionResponse actionResponse = os.identity().projects().delete(id);
		if (actionResponse.getCode() == 400) {
			hashMap.put("success", "成功");
		} else {
			hashMap.put("error", "失败");
		}
		return hashMap;
	}

	@RequestMapping(value = { "/role" }, method = { RequestMethod.GET })
	public String admin_role(HttpServletRequest request, Model model) {
		log.info("查询相关的role角色信息列表。。。。。。。");
		OSClientV3 os = Keystone.OS();
		List<? extends Role> user = os.identity().roles().list();
		model.addAttribute("user", user);
		return "admin-role";
	}

	@RequestMapping(value = { "/roledel" }, method = { RequestMethod.POST })
	@ResponseBody
	public HashMap<String, String> roledel(HttpServletRequest request, @RequestParam(value = "id") String id) {
		log.warn("开始删除指定role..........");
		String delid = id;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		OSClientV3 os = Keystone.OS();
		ActionResponse actionResponse = os.identity().roles().delete(delid);
		if (actionResponse.getCode() == 400) {
			hashMap.put("success", "成功");
		} else {
			hashMap.put("error", "失败");
		}
		return hashMap;
	}

	@RequestMapping(value = "/add")
	public String viewadd(HttpServletRequest request) {
		log.info("进入添加页面。。。。");
		return "/admin-role-add";
	}

	@RequestMapping(value = { "/addrel" }, method = { RequestMethod.POST })
	@ResponseBody
	public HashMap<String, String> admin_project_add(HttpServletRequest request,
			@RequestParam(value = "name") String name) {
		log.warn("开始插入新role.........");

		HashMap<String, String> hashMap = new HashMap<String, String>();
		String addname = name;
		OSClientV3 os = Keystone.OS();
		try {
			Role role = os.identity().roles().create(Builders.role().name(addname).build());
			if (role.getId() != null) {
				hashMap.put("success", "成功");
			}
		} catch (Exception e) {
			log.error("创建失败，出现异常。。。。。。。。。。");
			hashMap.put("error", "失败");
		}
		return hashMap;
	}

	@RequestMapping(value = { "/user" }, method = { RequestMethod.GET })
	public String admin_user(HttpServletRequest request, Model model) {
		log.info("开始列出所有users的列表..........");
		OSClientV3 os = Keystone.OS();
		List<? extends User> userlist = os.identity().users().list();
		model.addAttribute("userlist", userlist);
		return "admin-user";
	}

	@RequestMapping(value = { "/userDel" }, method = { RequestMethod.POST })
	@ResponseBody
	public HashMap<String, String> userDel(HttpServletRequest request, @RequestParam(value = "id") String id) {
		log.warn("开始删除指定user..........");
		HashMap<String, String> nHashMap = new HashMap<String, String>();
		OSClientV3 os = Keystone.OS();
		String delid = id;
		ActionResponse actionResponse = os.identity().users().delete(delid);
		if (actionResponse.getCode() == 400) {
			nHashMap.put("success", "成功");
		} else {
			nHashMap.put("error", "失败");
		}
		return nHashMap;
	}
}
