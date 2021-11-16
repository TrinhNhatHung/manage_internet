package com.fa.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.utils.PagingUtils;

@Transactional
@Repository
public class EntityDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session openSession() {
		return sessionFactory.openSession();
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public <E> E getById (Class<E> clazz,Serializable id) {
		Session session = openSession();
		return session.get(clazz, id);
	}

	@SuppressWarnings("rawtypes")
	public <E> long getRowCount(Class<E> clazz) {
		Session session = openSession();
		String sql = "SELECT COUNT(*) FROM " + clazz.getSimpleName();
		NativeQuery query = session.createNativeQuery(sql);
		return ((Integer) query.uniqueResult()).longValue();
	}

	public <E> List<E> getPagingData(Class<E> clazz, int page, String fieldSearch, String searchInput) {
		Session session = openSession();
		String sql = "SELECT * FROM " + clazz.getSimpleName() + " WHERE " + fieldSearch + " LIKE :searchInput";
		NativeQuery<E> query = session.createNativeQuery(sql, clazz);
		query.setParameter("searchInput", "%" + searchInput + "%");
		query.setFirstResult((page - 1) * PagingUtils.rowPerPage);
		query.setMaxResults(PagingUtils.rowPerPage);
		return query.getResultList();
	}

	public <E> List<E> getAll(Class<E> clazz) {
		Session session = openSession();
		String sql = "SELECT * FROM " + clazz.getSimpleName();
		NativeQuery<E> query = session.createNativeQuery(sql, clazz);
		return query.getResultList();
	}

	public <E> void delete(E element) {
		Session session = getCurrentSession();
		session.delete(element);
	}

	public <E> void update(E element) {
		Session session = getCurrentSession();
		session.saveOrUpdate(element);
	}
}
