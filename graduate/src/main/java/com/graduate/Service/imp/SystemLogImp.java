package com.graduate.Service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.Dao.SystemLogDao;
import com.graduate.Entity.SystemLog;
import com.graduate.Service.SystemLogService;
@Transactional
@Service
public class SystemLogImp implements SystemLogService {
	@Autowired
	SystemLogDao systemLogDao;

	private Log log = LogFactory.getLog(SystemLogImp.class);

	@Override
	public int insert(SystemLog record) {
		log.warn("开始执行插入的系统登陆日志记录...........");
		return systemLogDao.insert(record);
	}

	@Override
	public List<SystemLog> listAll() {
		log.warn("开始列出系统所有登陆日志并按降序排序.......");
		return systemLogDao.listAll();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		log.warn("开始删除前端传回的值......");
		return systemLogDao.deleteByPrimaryKey(id);
	}

}
