package com.graduate.Service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.Dao.LoginDao;
import com.graduate.Entity.Login;
import com.graduate.Entity.LoginExample;
import com.graduate.Service.LoginService;
import com.graduate.Utils.Convert;
@Transactional
@Service
public class LoginServiceImp implements LoginService {
	@Autowired
	LoginDao loginMapper;
	private Log log = LogFactory.getLog(LoginServiceImp.class);

	@Override
	public Login selectByPrimaryKey(String account) {
		if (account != null) {
			log.info("account值=" + " " + account);
			return loginMapper.selectByPrimaryKey(account);
		}
		log.info("account值=" + " " + null);
		return loginMapper.selectByPrimaryKey(account);
	}

	@Override
	public int insert(Login record) {

		log.info("注册得账号信息" + " " + Convert.object(record));
		return loginMapper.insert(record);

	}

	@Override
	public int countByExample(LoginExample example) {
		int count = loginMapper.countByExample(example);
		log.info("管理员总数=" + " " + count);
		return count;
	}

	@Override
	public List<Login> listAll() {
		log.info("login集合的数据返回值");
		return loginMapper.listAll();
	}

}
