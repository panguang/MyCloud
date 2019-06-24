package com.graduate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraduateApplicationTests {

//	@Test
//	@Ignore
//	public void test() {
//
//		OSClientV3 os = OSFactory.builderV3().endpoint("http://192.168.46.110:5000/v3")
//				.credentials("admin", "1234", Identifier.byName("default"))
//				.scopeToProject(Identifier.byId("19de86af8b5e4b32848e3a06cf1d109f")).authenticate();
//
//		List<? extends Flavor> flavors = os.compute().flavors().list();
//		for (Flavor flavor : flavors) {
//			System.out.println(flavor);
//		}
//	}

	// 列出实例
	@Test
	public void listserver() {

		// List<ServerPo> datalist = new ArrayList<ServerPo>();
		/* OSClientV3 os = Keystone.OS(); */
		// Role role = os.identity().roles().create(Builders.role().name("瑞特").build());

		/*
		 * System.out.println("saf"); System.out.println("saf");
		 */
		/*
		 * List<? extends Role> user = os.identity().roles().list();;
		 *
		 * for (Role i : user) { System.out.println(i); }
		 */
		/*
		 * List<? extends Project> projectList = os.identity().projects().list(); for
		 * (Project project : projectList) { System.out.println(project);
		 *
		 * }
		 */

		/* List<? extends Network> networks = os.networking().network().list(); */
		/*
		 * System.out.println(networks.get(0).getNetworkType());
		 * System.out.println(networks.get(0).getStatus());
		 * System.out.println(networks.get(0).getSubnets());
		 * System.out.println(networks.get(0).getName());
		 * System.out.println(networks.get(0).getProviderPhyNet());
		 */
		/*
		 * String subnet =
		 * InterceptString.Content1(networks.get(1).getSubnets().toString());
		 * System.out.println(subnet); ActionResponse object =
		 * os.networking().network().delete(subnet); System.out.println("删完了" +
		 * object.getCode());
		 */

		/*
		 * List<? extends Image> images = os.images().list(); for (Image i : images) {
		 * System.out.println(i); }
		 */
		/*
		 * System.out.println("列出所有实例的详细信息"); List<? extends Server> servers =
		 * os.compute().servers().list(); if
		 * (servers.get(0).getAddresses().getAddresses().values().toString().equals("[]"
		 * )) { System.out.println("ipnull"); }
		 */
		// System.out.println(servers.get(0).getAddresses().getAddresses().values());
		// System.out.println(servers.get(1).getAddresses().getAddresses().values());
		// List<? extends Network> networks = os.networking().network().list();
		// os.compute().servers().delete("serverId");
		// Object
		// b=os.compute().servers().delete("fb34ad00-e99b-4ffe-8b84-851dd6ab6bfc");
		// ServerCreate sc = Builders.server()
		/*
		 * .name("test").flavor("0").image("7667450b-cfef-4c61-a90e-edf265937a7c")
		 * .build();
		 */
		// Server server = os.compute().servers().boot(sc);
		// List<? extends Server> servers = os.compute().servers().list();

		/*
		 * System.out.println("列出所有image的信息"); List<? extends
		 * org.openstack4j.model.image.Image> images = os.images().list(); for
		 * (org.openstack4j.model.image.Image image : images) {
		 * System.out.println(image); }
		 *
		 * CreateInstance crea = new CreateInstance(); List<FlavorPo> flavors =
		 * crea.getflavor();
		 *
		 * for (FlavorPo i : flavors) { System.out.println(); }
		 */

		/*
		 * System.out.println("列出所有flavor的信息"); List<? extends Flavor> flavors =
		 * os.compute().flavors().list(); for(Flavor flavor:flavors) {
		 * System.out.println(flavor); } System.out.println("列出所有image的信息"); List<?
		 * extends org.openstack4j.model.image.Image> images = os.images().list();
		 * for(org.openstack4j.model.image.Image image:images) {
		 * System.out.println(image); }
		 */
		// ServerCreate sc =
		// Builders.server().name("Ubuntu2").flavor("0").image("7667450b-cfef-4c61-a90e-edf265937a7c")
		// .build();
		// Server server = os.compute().servers().boot(sc);
		// System.out.println("调试断点");
	}
	/*
	 * ServerPo serverPo; for (int i = 0; i < servers.size(); i++) { serverPo=new
	 * ServerPo(); serverPo.setName(servers.get(i).getName());
	 * serverPo.setImage_name(os.compute().images().get(servers.get(i).getImageId())
	 * .getName());
	 * serverPo.setIp(InterceptString.Content(servers.get(i).getAddresses().
	 * getAddresses().values().toString()));
	 * serverPo.setFlavor(servers.get(i).getFlavor().getName());
	 * serverPo.setStatus(servers.get(i).getStatus());
	 * serverPo.setVmState(servers.get(i).getVmState()); datalist.add(serverPo); }
	 * for(ServerPo i:datalist) { System.out.println(i); }
	 */

	/*
	 * OSClientV3 os = Keystone.OS(); List<? extends Server> servers =
	 * os.compute().servers().list(); System.out.println("测试API。。。。。。。。");
	 * System.out.println(servers.get(0).getName());
	 * System.out.println(servers.get(0).getInstanceName());
	 * System.out.println(os.compute().images().get(servers.get(0).getImageId()).
	 * getName());
	 *
	 * System.out.println(servers.get(0).getAddresses().getAddresses().values().
	 * toString()); String content =
	 * servers.get(0).getAddresses().getAddresses().values().toString(); String newc
	 * = content.substring(content.indexOf("=") + 1, content.indexOf(","));
	 * System.out.println(servers.get(0).getFlavor().getName());
	 * servers.get(0).getStatus(); servers.get(0).getVmState();
	 */

	/*
	 * for(Server server:servers) { System.out.println(server); }
	 */
	/*
	 * Image img = os.compute().images().get(servers.get(0).getImageId());
	 * System.out.println("这是通过镜像ID查询====" + img); System.out.println("这是列出虽有规格类型");
	 * List<? extends Flavor> flavors = os.compute().flavors().list(); for (Flavor
	 * flavor : flavors) { System.out.println(flavor); }
	 * System.out.println("这是列出所有镜像文件"); List<? extends Image> images =
	 * os.compute().images().list(); for (Image image : images) {
	 * System.out.println(image); }
	 */

	/*
	 * @Autowired LoginServiceImp loginService;
	 *
	 * @Autowired LoginLogServiceImp loginLogServiceimp;
	 *
	 * @Test
	 *
	 * @Ignore public void test() { Date date = new Date(); String week =
	 * DateCovert.getWeek(date); System.out.println(week);
	 *
	 * }
	 *
	 * @Test
	 *
	 * @Ignore public void testchar() { Map<String, String> dataMap = new
	 * HashMap<String, String>(); List<Login> loginlist = loginService.listAll();
	 * int i = loginlist.size(); for (int j = 0; j < i; j++) {
	 * dataMap.put(loginlist.get(j).getAccount(),
	 * Integer.toString(loginLogServiceimp.countByname(loginlist.get(j).getAccount()
	 * ))); } System.out.println(dataMap.size() + " " + loginlist.size()); }
	 */
	/*
	 * @Test
	 *
	 * @ApiIgnore public void keystone() { OSClientV3 os =
	 * OSFactory.builderV3().endpoint("http://192.168.46.110:5000/v3")
	 * .credentials("admin", "1234", Identifier.byName("default"))
	 * .scopeToProject(Identifier.byId("19de86af8b5e4b32848e3a06cf1d109f")).
	 * authenticate(); System.out.println(os);
	 */

	/*
	 * OSClientV3 os =
	 * OSFactory.builderV3().endpoint("http://192.168.46.110:5000/v3")
	 * .credentials("admin", "1234", Identifier.byName("default"))
	 * .scopeToProject(Identifier.byName("admin"),
	 * Identifier.byName("default")).authenticate(); // OSClientV3 os =
	 * OSFactory.builderV3().endpoint("http://10.10.10.110:5000/v3")
	 * System.out.println(os);
	 */
	// }

	/*
	 * @Autowired LoginLogServiceImp LoginLogServiceImp;
	 *
	 * @Autowired LoginServiceImp loginServiceImp;
	 *
	 * @Test
	 *
	 * @Ignore public void test() { int port = 8080; String p =
	 * Integer.toString(port); System.out.println(p); }
	 *
	 * @Test
	 *
	 * @Ignore public void count() { int count =
	 * LoginLogServiceImp.countByname("admin"); System.out.println(count);
	 *
	 * }
	 *
	 * @Test
	 *
	 * @Ignore public void testlog() { List<Loginlog> log =
	 * LoginLogServiceImp.listByparam("1"); for (Loginlog i : log) {
	 * System.out.println(i); } System.out.println(log.get(0).getTime()); }
	 *
	 * @Test
	 *
	 * @Ignore public void time() { System.out.println(new Date()); }
	 *
	 * @Test public void testInfo(HttpServletRequest request) { String adminname =
	 * (String) request.getSession().getAttribute("1"); // 登陆次数 int count =
	 * LoginLogServiceImp.countByname(adminname); // 上次登陆的ip String ip =
	 * LoginLogServiceImp.listByparam(adminname).get(0).getIp(); // 上次登陆的时间 Date
	 * lasttime = LoginLogServiceImp.listByparam(adminname).get(0).getTime(); //
	 * 管理员总数 //int sum = LoginLogServiceImp.countByExample(null); // 服务器计算机名字 String
	 * hostname = request.getLocalName(); // 服务器IP String hostIp =
	 * request.getLocalAddr(); // 服务器端口 String port =
	 * Integer.toString(request.getLocalPort()); // 服务器当前时间 Date currenttime = new
	 * Date();
	 *
	 * System.out.println(count); }
	 */

}
