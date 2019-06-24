package com.graduate.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.graduate.Entity.Login;
import com.graduate.Entity.LoginExample;
@Repository
public interface LoginDao {
	List<Login> listAll();

	int deleteByPrimaryKey(String account);

	int insert(Login record);

	int insertSelective(Login record);

	Login selectByPrimaryKey(String account);

	int updateByPrimaryKeySelective(Login record);

	int updateByPrimaryKey(Login record);

	int countByExample(LoginExample example);

	int deleteByExample(LoginExample example);

	List<Login> selectByExample(LoginExample example);

	int updateByExampleSelective(@Param("record") Login record, @Param("example") LoginExample example);

	int updateByExample(@Param("record") Login record, @Param("example") LoginExample example);

}