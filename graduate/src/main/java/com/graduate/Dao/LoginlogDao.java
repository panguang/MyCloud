package com.graduate.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.graduate.Entity.Loginlog;
import com.graduate.Entity.LoginlogExample;
@Repository
public interface LoginlogDao {
	int countByname(String account);

	List<Loginlog> listByparam(String date);

	int deleteByPrimaryKey(String account);

	int insert(Loginlog record);

	int insertSelective(Loginlog record);

	Loginlog selectByPrimaryKey(String account);

	int updateByPrimaryKeySelective(Loginlog record);

	int updateByPrimaryKey(Loginlog record);

	int countByExample(LoginlogExample example);

	int deleteByExample(LoginlogExample example);

	List<Loginlog> selectByExample(LoginlogExample example);

	int updateByExampleSelective(@Param("record") Loginlog record, @Param("example") LoginlogExample example);

	int updateByExample(@Param("record") Loginlog record, @Param("example") LoginlogExample example);

}