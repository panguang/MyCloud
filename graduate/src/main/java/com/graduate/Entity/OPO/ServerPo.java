package com.graduate.Entity.OPO;

import org.openstack4j.model.compute.Server.Status;

/**
 *
 * @author 潘广 功能:封装列举实例的所有的信息
 */
public class ServerPo {
	// 实例ID
	private String ID;
	// 实例名称
	private String name;
	// 镜像名称
	private String image_name;
	// 实例IP地址
	private String ip;
	// 实例的规格
	private String flavor;
	// 镜像的状态
	private Status status;

	// 实例的状态
	private String vmState;

	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String name) {
		this.image_name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getVmState() {
		return vmState;
	}

	public void setVmState(String vmState) {
		this.vmState = vmState;
	}

}
