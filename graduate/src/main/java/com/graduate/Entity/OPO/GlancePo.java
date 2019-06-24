package com.graduate.Entity.OPO;

import org.openstack4j.model.image.DiskFormat;
import org.openstack4j.model.image.Image.Status;

/**
 *
 * @author Administrator
 * @封装镜像的所有信息
 */

public class GlancePo {

	private String name;
	private Status status;
	private boolean isPublic;
	private boolean isProtected;
	private DiskFormat diskFormat;
	private long size;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public boolean getIsProtected() {
		return isProtected;
	}

	public void setIsProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

	public DiskFormat getDiskFormat() {
		return diskFormat;
	}

	public void setDiskFormat(DiskFormat diskFormat) {
		this.diskFormat = diskFormat;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
