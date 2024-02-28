package com.sgu.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.sgu.util.JpaUtil;


public class AbstractDao<T> {
	public static final EntityManager entityManager = JpaUtil.getEntityManager();

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	public T findById(Class<T> clazz, Integer id) {
		return entityManager.find(clazz, id);
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive)
	{
		String entityNameString = clazz.getSimpleName();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT o FROM ").append(entityNameString).append(" o");
		if(existIsActive == true)
		{
			sqlBuilder.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sqlBuilder.toString(), clazz);
		return query.getResultList();
	}
	public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize)
	{
		String entityNameString = clazz.getSimpleName();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT o FROM ").append(entityNameString).append(" o");
		if(existIsActive == true)
		{
			sqlBuilder.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sqlBuilder.toString(), clazz);
		query.setFirstResult((pageNumber - 1)*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	public List<T> findByXID(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize, String condition)
	{
		String entityNameString = clazz.getSimpleName();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT o FROM ").append(entityNameString).append(" o").append(" ").append(condition);
		if(existIsActive == true)
		{
			sqlBuilder.append(" AND o.isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sqlBuilder.toString(), clazz);
		query.setFirstResult((pageNumber - 1)*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	public List<T> findByCondition(Class<T> clazz, boolean existIsActive, String condition)
	{
		String entityNameString = clazz.getSimpleName();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT o FROM ").append(entityNameString).append(" o").append(" ").append(condition);
		if(existIsActive == true)
		{
			sqlBuilder.append(" AND o.isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sqlBuilder.toString(), clazz);
		return query.getResultList();
	}
	public T findOne(Class<T> clazz, String sql, Object ... params)
	{
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for(int i = 0; i<params.length; i++)
		{
			query.setParameter(i, params[i]);
		}
		List<T> resultList = query.getResultList();
		if(resultList.isEmpty())
		{
			return null;
		}
		return resultList.get(0);
	}
	public List<T> findMany(Class<T> clazz, String sql, Object ... params)
	{
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for(int i = 0; i<params.length; i++)
		{
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(String sql, Object ... params)
	{
		Query query = entityManager.createNativeQuery(sql);
		for(int i = 0; i<params.length; i++)
		{
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}
	public T create(T entity)
	{
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("Create success");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot insert entity "+entity.getClass().getSimpleName());
			throw new RuntimeException(e);
		}
	}
	public T update(T entity)
	{
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			System.out.println("Update success");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot update entity "+entity.getClass().getSimpleName());
			throw new RuntimeException(e);
		}
	}
	public T delete(T entity)
	{
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			System.out.println("Delete success");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot delete entity "+entity.getClass().getSimpleName());
			throw new RuntimeException(e);
		}
	}

	public List<T> callStore(Class<T> clazz, String namedStore, Map<String, Object> params)
	{
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(namedStore, clazz);
		
		params.forEach((key, value) -> {
		    query.registerStoredProcedureParameter(key, value.getClass(), ParameterMode.IN);
		    query.setParameter(key, value);
		});
		List<T> result = query.getResultList();
		return result;
		
	}
}
