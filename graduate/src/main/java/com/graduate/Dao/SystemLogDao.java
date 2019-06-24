package com.graduate.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.graduate.Entity.SystemLog;
import com.graduate.Entity.SystemLogExample;
@Repository
public interface SystemLogDao {
	int countByExample(SystemLogExample example);

	int deleteByExample(SystemLogExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SystemLog record);

	int insertSelective(SystemLog record);

	List<SystemLog> selectByExample(SystemLogExample example);

	List<SystemLog> listAll();

	SystemLog selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

	int updateByExample(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

	int updateByPrimaryKeySelective(SystemLog record);

	int updateByPrimaryKey(SystemLog record);
}