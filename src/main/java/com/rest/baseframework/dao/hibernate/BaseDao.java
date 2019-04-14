package com.rest.baseframework.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest.baseframework.entity.Users;

public class BaseDao implements IBaseDao {
	private SessionFactory sessionFactory;
	private  Session session;
	
	protected Logger log = LogManager.getLogger(getClass());

	public void setSession(Session session) {
		this.session = session;
	}

	public SessionFactory getSessionFactory() {
	SessionFactory fac=	new Configuration().configure().buildSessionFactory();
		setSessionFactory(fac);
		return  fac; 
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		log.traceEntry();
		return this.session;
	}

	public Session openNewSession() {
		Session session = getSessionFactory().openSession();
		 session.beginTransaction();
		 setSession(session);
		return session;
	}
	
	public Users getSingleUser(long id) {
	Query q = getCurrentSession().createQuery("select u from User u inner join u.company c where c.id = :id");
	q.setParameter("id", id);
	List<Users> list = q.list();
	return list.get(0);
}
	
	public void closeNewSession() {
		    this.session.getTransaction().commit();
	     	this.session.close();
	     	this.sessionFactory.close();
			
	}


	public Session getReadOnlySession() {
		log.traceEntry();
		Session session = this.getCurrentSession();
		session.setHibernateFlushMode(FlushMode.MANUAL);
		log.traceExit();
		return session;
	}


	private <T> CriteriaQuery<T> generateCriteria(Class<T> clazz, String[] conditionPropertyNames,
			Object[] conditionPropertyValues) {
		final CriteriaBuilder builder = getReadOnlySession().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(clazz);
		Root<T> root = criteria.from(clazz);
		criteria.select(root);

		List<Predicate> predicateList = new ArrayList<Predicate>();
		Predicate condition = null;
		int counter = 0;
		for (String conditionPropertyName : conditionPropertyNames) {
			condition = builder.equal(root.get(conditionPropertyName), conditionPropertyValues[counter]);
			predicateList.add(condition);
			counter++;
		}

		criteria.where(predicateList.toArray(new Predicate[predicateList.size()]));
		return criteria;
	}

	private <T> T retrieveObject(Session session, Class<T> clazz, String[] conditionPropertyNames,
			Object[] conditionPropertyValues) {
		CriteriaQuery<T> criteria = generateCriteria(clazz, conditionPropertyNames, conditionPropertyValues);
		try {
			T obj = session.createQuery(criteria).getSingleResult();
			return obj;
		} catch (NoResultException e) {
			return null;
		}
	}

	private <T> List<T> retrieveObjects(Session session, Class<T> clazz, String[] conditionPropertyNames,
			Object[] conditionPropertyValues) {
		CriteriaQuery<T> criteria = generateCriteria(clazz, conditionPropertyNames, conditionPropertyValues);
		return session.createQuery(criteria).getResultList();
	}


	public <T> T retrieveObject(Class<T> clazz, String[] conditionPropertyNames, Object[] conditionPropertyValues) {
		return retrieveObject(getCurrentSession(), clazz, conditionPropertyNames, conditionPropertyValues);
	}

	public <T> List<T> retrieveObjects(Class<T> clazz, String[] conditionPropertyNames, Object[] conditionPropertyValues) {
		return retrieveObjects(getCurrentSession(), clazz, conditionPropertyNames, conditionPropertyValues);
	}


	public <T> T updateObject(T obj) {
		getCurrentSession().update(obj);
		getCurrentSession().flush();
		return obj;
	}

	public <T> T saveObject(T obj) {
		getCurrentSession().save(obj);
		return obj;
	}

}
