package com.rest.baseframework.dao.hibernate;

import java.util.List;

public interface IBaseDao {
	<T> T retrieveObject(Class<T> clazz, String[] conditionPropertyNames, Object[] conditionPropertyValues);

	<T> List<T> retrieveObjects(Class<T> clazz, String[] conditionPropertyNames, Object[] conditionPropertyValues);
	<T> T saveObject(T obj);

	<T> T updateObject(T obj);
}
