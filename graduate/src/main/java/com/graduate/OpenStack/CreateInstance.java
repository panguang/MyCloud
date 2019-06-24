package com.graduate.OpenStack;
/**
 *
 * @author 潘广
 * @ 封装创建实例需要的所有信息
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.image.Image;

import com.graduate.Entity.OPO.FlavorPo;

public class CreateInstance {
	public List<FlavorPo> getflavor() {
		OSClientV3 os = Keystone.OS();
		List<? extends Flavor> flavors = os.compute().flavors().list();
		List<FlavorPo> newlist = new ArrayList<FlavorPo>();
		for (int i = 0; i < flavors.size(); i++) {
			FlavorPo po = new FlavorPo();
			po.setId(flavors.get(i).getId());
			po.setDisk(flavors.get(i).getDisk());
			po.setName(flavors.get(i).getName());
			po.setVcpus(flavors.get(i).getVcpus());
			po.setRam(flavors.get(i).getRam());
			newlist.add(po);
		}
		return newlist;
	}
	public List<? extends Image> getImage()
	{
		OSClientV3 os = Keystone.OS();
		List<? extends Image> images = os.images().list();
		return images;
	}



}
