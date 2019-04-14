package com.rest.baseframework.service.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.rest.baseframework.dao.hibernate.BaseDao;
import com.rest.baseframework.entity.Users;
import com.rest.baseframework.model.UsersTO;

public class UserServiceImpl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3263326964590917910L;
	@Autowired
	BaseDao baseDao;

	public UsersTO registerUser(UsersTO user) {
		Users userEntity = UserTranslator.ModelToEntity(user);
		Session session = baseDao.openNewSession();
		session.save(userEntity);
	    UsersTO to=	UserTranslator.entitytoModel(userEntity);
		return to;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
