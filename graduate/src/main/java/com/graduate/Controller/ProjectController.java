package com.graduate.Controller;
/**
 * @author 潘广
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.ServerCreate;
import org.openstack4j.model.image.Image;
import org.openstack4j.model.network.Network;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduate.Entity.OPO.FlavorPo;
import com.graduate.Entity.OPO.GlancePo;
import com.graduate.Entity.OPO.NetworkPo;
import com.graduate.Entity.OPO.ServerPo;
import com.graduate.OpenStack.CreateInstance;
import com.graduate.OpenStack.Keystone;
import com.graduate.Utils.InterceptString;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@Api(value = "v1/api", tags = "project/项目界面接口")
@RequestMapping("/project")
public class ProjectController {
	private Log log = LogFactory.getLog(ProjectController.class);

	@RequestMapping(value = "/instance", method = { RequestMethod.GET })
	@ApiIgnore
	public String project_Instance(HttpServletRequest request, Model model) {
		// HashMap<String, String>dataMap=new HashMap<String,String>();
		List<ServerPo> datalist = new ArrayList<ServerPo>();
		OSClientV3 os = Keystone.OS();
		List<? extends Server> servers = os.compute().servers().list();
		log.info("开始查询所有实例的信息...........");
		ServerPo serverPo;
		if (servers.size() != 0) {
			for (int i = 0; i < servers.size(); i++) {
				serverPo = new ServerPo();
				serverPo.setID(servers.get(i).getId());
				serverPo.setName(servers.get(i).getName());
				serverPo.setImage_name(os.compute().images().get(servers.get(i).getImageId()).getName());
				serverPo.setFlavor(servers.get(i).getFlavor().getName());
				serverPo.setStatus(servers.get(i).getStatus());
				serverPo.setVmState(servers.get(i).getVmState());
				if (servers.get(i).getAddresses().getAddresses().values().toString().equals("[]")) {
					serverPo.setIp("0.0.0.0");
				} else {
					serverPo.setIp(
							InterceptString.Content(servers.get(i).getAddresses().getAddresses().values().toString()));
				}
				datalist.add(serverPo);
			}
		}
		model.addAttribute("datalist", datalist);

		return "instance";
	}

	@RequestMapping(value = { "/instance_delete" }, method = { RequestMethod.POST })
	@ResponseBody
	public HashMap<String, String> deleteInstance(HttpServletRequest request, ServerPo po) {
		log.warn("正在删除实例。。。。。。。。。。。。");
		String id = po.getID();
		OSClientV3 os = Keystone.OS();
		HashMap<String, String> datamap = new HashMap<String, String>();
		int status = os.compute().servers().delete(id).getCode();
		if (status == 400) {
			datamap.put("sucess", "成功");
		} else {
			datamap.put("error", "失败");
		}
		return datamap;

	}

	@RequestMapping(value = { "/instance_add" }, method = { RequestMethod.GET })
	@ApiIgnore
	public String project_InstanceAdd(HttpServletRequest request, Model model) {
		log.info("开始调用创建映射地址.........");
		CreateInstance crea = new CreateInstance();
		List<FlavorPo> flavors = crea.getflavor();
		List<? extends Image> images = crea.getImage();
		model.addAttribute("flavors", flavors);
		model.addAttribute("images", images);
		return "instance-add";
	}

	@RequestMapping(value = { "/instance_addRel" }, method = { RequestMethod.POST })
	@ResponseBody
	// 这里创建没有状态码判断
	public HashMap<String, String> Instance_addRel(HttpServletRequest request) {
		log.warn("开始创建实例。。。。。。。。。");
		OSClientV3 os = Keystone.OS();
		String name = request.getParameter("name");
		String flavor = request.getParameter("flavor");
		String image = request.getParameter("image");
		ServerCreate sc = Builders.server().name(name).flavor(flavor).image(image).build();
		Server server = os.compute().servers().boot(sc);
		HashMap<String, String> nh = new HashMap<String, String>();
		nh.put("success", "成功");
		return nh;
	}

	@RequestMapping(value = { "/neutron" }, method = { RequestMethod.GET })
	public String project_newtron(HttpServletRequest request, Model model) {
		log.info("开始查询所有网络...............");
		OSClientV3 os = Keystone.OS();
		List<? extends Network> networks = os.networking().network().list();
		List<NetworkPo> newlist = new ArrayList<NetworkPo>();
		for (int i = 0; i < networks.size(); i++) {
			NetworkPo networkPo = new NetworkPo();
			networkPo.setName(networks.get(i).getName());
			networkPo.setAdminState(networks.get(i).isAdminStateUp());
			networkPo.setRouter(networks.get(i).isRouterExternal());
			networkPo.setShared(networks.get(i).isShared());
			networkPo.setStatus(networks.get(i).getStatus());
			networkPo.setSubnets(os.networking().subnet()
					.get(InterceptString.Content1(networks.get(0).getSubnets().toString())).getCidr());
			networkPo.setDelID(InterceptString.Content1(networks.get(0).getSubnets().toString()));
			newlist.add(networkPo);
		}

		model.addAttribute("newnetwork", newlist);
		return "neutron";
	}

	@RequestMapping(value = { "/neutrondel" }, method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, String> networkdel(HttpServletRequest request, NetworkPo networkPo) {
		OSClientV3 os = Keystone.OS();
		String id = networkPo.getDelID();
		Map<String, String> map = new HashMap<String, String>();
		ActionResponse object = os.networking().network().delete(id);

		if (object.getCode() == 400) {
			map.put("success", "删除成功");
		} else {
			map.put("error", "删除失败");
		}

		return map;

	}

	@RequestMapping(value = { "/glance" }, method = { RequestMethod.GET })
	public String project_glance(HttpServletRequest request, Model model) {
		log.info("开始列出所有镜像信息。。。。。。。。");
		OSClientV3 os = Keystone.OS();
		GlancePo po = null;
		List<GlancePo> glance = new ArrayList<GlancePo>();
		List<? extends Image> images = os.images().list();
		for (int i = 0; i < images.size(); i++) {
			po = new GlancePo();
			po.setName(images.get(i).getName());
			po.setDiskFormat(images.get(i).getDiskFormat());
			po.setIsProtected(images.get(i).isProtected());
			po.setIsPublic(images.get(i).isPublic());
			po.setSize(images.get(i).getSize());
			po.setStatus(images.get(i).getStatus());
			po.setDelID(images.get(i).getId());
			glance.add(po);
		}
		model.addAttribute("glance", glance);
		return "glance";
	}

	@RequestMapping(value = { "/glancedel" }, method = { RequestMethod.POST })
	@ResponseBody
	public HashMap<String, String> delglance(HttpServletRequest request, GlancePo po) {
		OSClientV3 os = Keystone.OS();
		String id = po.getDelID();
		HashMap<String, String> hMap = new HashMap<String, String>();
		ActionResponse actionResponse = os.images().delete(id);

		if (actionResponse.getCode() == 400) {
			hMap.put("success", "成功");
		} else {
			hMap.put("error", "失败");
		}

		return hMap;
	}

}
