package com.graduate.OpenStack;

/**
 *@author 潘广
 *主要功能实现:获取身份认证令牌
 */
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.openstack.OSFactory;

public class Keystone {
	public static OSClientV3 OS() {
		OSClientV3 os = OSFactory.builderV3().endpoint("http://192.168.46.110:5000/v3")
				.credentials("admin", "1234", Identifier.byName("default"))
				.scopeToProject(Identifier.byId("19de86af8b5e4b32848e3a06cf1d109f")).authenticate();
		return os;
	}

}
