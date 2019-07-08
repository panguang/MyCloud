package com.fuse.entity;

public class TestEntity {
	private Integer deptId;
	private String deptName;

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = (deptName == null) ? null : deptName.trim();
	}
}
