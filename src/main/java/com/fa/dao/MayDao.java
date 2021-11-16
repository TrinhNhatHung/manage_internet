package com.fa.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.fa.persistence.May;

@Repository
public class MayDao extends EntityDao {

	public void insert(May may) {
		Session session = getCurrentSession();
		String sql = "INSERT INTO May(vi_tri, trang_thai)\n" + "VALUES (:position,:status)";
		NativeQuery<May> query = session.createNativeQuery(sql, May.class);
		query.setParameter("position", may.getViTri());
		query.setParameter("status", may.getTrangThai());
		query.executeUpdate();
	}
}
