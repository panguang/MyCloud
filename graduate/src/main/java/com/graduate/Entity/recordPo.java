package com.graduate.Entity;

/**
 *
 * @author 潘广
 * @time 2019-3-1
 * @功能 将welcom界面的信息进行封装成pojo，然后放进模型中传进去 在运用ajax实现两个页面的数据交互
 *
 */
public class recordPo {
	// 账号
	String adminname;
	// 次数
	int count;
	// 上次登陆的ip
	String ip;
	// 上次登陆的时间
	String lasttime;
	// 管理员总数
	int sum;
	// 服务器计算机名字
	String hostname;
	// 服务器IP
	String hostIp;
	// 服务器端口
	int port;
	// 服务器当前时间
	String currenttime;

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(String currenttime) {
		this.currenttime = currenttime;
	}

}
