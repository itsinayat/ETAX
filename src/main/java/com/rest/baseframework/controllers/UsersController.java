package com.rest.baseframework.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.rest.baseframework.dao.hibernate.BaseDao;
import com.rest.baseframework.dao.impl.UserDao;
import com.rest.baseframework.entity.Users;
import com.rest.baseframework.model.UsersTO;
import com.rest.baseframework.service.impl.UserServiceImpl;

@Component
@Path("/user")
public class UsersController {
	@Autowired
	UserDao userDao;
	@Autowired
	BaseDao baseDao;
	@Autowired
	UserServiceImpl userService;

	@Path("/initial_register")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloWorld(@RequestBody UsersTO user) {
		UsersTO result = userService.registerUser(user);
		

		return Response.status(200).entity(result).build();

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
