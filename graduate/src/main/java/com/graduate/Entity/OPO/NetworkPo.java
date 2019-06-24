package com.graduate.Entity.OPO;

/**
 *
 * @author 潘广
 * @封装网络的相信息
 */
public class NetworkPo {
	// 网络的名字
	private String name;
	// 网络的状态
	private org.openstack4j.model.network.State status;
	// 子网
	private String subnets;
	// 是否共享
	private Boolean shared;
	// 路由
	private Boolean router;
	// 管理状态
	private Boolean adminState;
	// 删除网络ID
	private String delID;

	public String getDelID() {
		return delID;
	}

	public void setDelID(String delID) {
		this.delID = delID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public org.openstack4j.model.network.State getStatus() {
		return status;
	}

	public void setStatus(org.openstack4j.model.network.State state) {
		this.status = state;
	}

	public String getSubnets() {
		return subnets;
	}

	public void setSubnets(String subnets) {
		this.subnets = subnets;
	}

	public Boolean getShared() {
		return shared;
	}

	public void setShared(Boolean shared) {
		this.shared = shared;
	}

	public Boolean getRouter() {
		return router;
	}

	public void setRouter(Boolean router) {
		this.router = router;
	}

	public Boolean getAdminState() {
		return adminState;
	}

	public void setAdminState(Boolean adminState) {
		this.adminState = adminState;
	}

}
