package com.graduate.Service;

import java.util.List;

import com.graduate.Entity.Loginlog;

public interface LoginLogService {
	int countByname(String account);

	int insert(Loginlog record);

	List<Loginlog> listByparam(String account);

}
