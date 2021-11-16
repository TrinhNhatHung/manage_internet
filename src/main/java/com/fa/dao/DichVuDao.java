package com.fa.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.fa.persistence.DichVu;

@Repository
public class DichVuDao extends EntityDao {
	
	public void insert(DichVu dichVu) {
		Session session = getCurrentSession();
		String sql = "INSERT INTO DichVu(ten_dv, don_vi_tinh, don_gia)\n"
				+ "VALUES (:name,:unit, :price)";
		NativeQuery<DichVu> query = session.createNativeQuery(sql, DichVu.class);
		query.setParameter("name", dichVu.getTenDV());
		query.setParameter("unit", dichVu.getDonViTinh());
		query.setParameter("price", dichVu.getDonGia());
		query.executeUpdate();
	}
}
