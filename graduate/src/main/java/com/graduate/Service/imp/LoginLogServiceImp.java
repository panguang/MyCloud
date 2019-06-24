package com.graduate.Service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.Dao.LoginlogDao;
import com.graduate.Entity.Loginlog;
import com.graduate.Service.LoginLogService;
import com.graduate.Utils.Convert;
@Transactional
@Service
public class LoginLogServiceImp implements LoginLogService {
	@Autowired
	LoginlogDao loginlogDao;
	private Log log = LogFactory.getLog(LoginLogServiceImp.class);

	@Override
	public int insert(Loginlog record) {

		log.info("插入登陆日志对象=" + " " + Convert.object(record));
		return loginlogDao.insert(record);
	}

	@Override
	public int countByname(String account) {
		log.info("查询得账号" + " " + account);
		return loginlogDao.countByname(account);
	}

	@Override
	public List<Loginlog> listByparam(String account) {
		log.info("查询该账号登陆得相关信息(相关得登陆次数、IP等))"+" "+account);
		return loginlogDao.listByparam(account);

	}

}
