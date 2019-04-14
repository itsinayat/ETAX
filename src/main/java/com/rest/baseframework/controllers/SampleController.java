package com.rest.baseframework.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.rest.baseframework.dao.hibernate.BaseDao;
import com.rest.baseframework.entity.Users;

@Component
@Path("/")
public class SampleController {
	
	@Path("hello")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloWorld() {
		Users e=new Users();
		e.setName_of_farm("cccccccccc");
		      
		  BaseDao dao =new BaseDao();
		 Session session=dao.openNewSession();
		 session.save(e);
		 e.setName_of_farm("ppppppppppppppppppp");
     	 session.saveOrUpdate(e);
     	 dao.getCurrentSession();
     	 dao.closeNewSession();
     	 dao.getCurrentSession();
		 
		      
		/*      
		Session session= factory.openSession();
	                    	session.beginTransaction();
	                    	session.save(e);
	                    	session.getTransaction().commit();
	                    	session.close();
	                    	factory.close();*/
		      
		      
		
		return Response.status(200).entity(e).build();
		
	}

	

}
