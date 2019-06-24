package com.graduate.Service;

import java.util.List;

import com.graduate.Entity.SystemLog;

public interface SystemLogService {
	int insert(SystemLog record);

	List<SystemLog> listAll();
	int deleteByPrimaryKey(Integer id);

}
