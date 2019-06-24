package com.graduate.Service;

import java.util.List;

import com.graduate.Entity.Login;
import com.graduate.Entity.LoginExample;

public interface LoginService {
	Login selectByPrimaryKey(String account);

	List<Login> listAll();

	int insert(Login record);

	int countByExample(LoginExample example);
}
