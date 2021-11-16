package com.fa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LocalDateType;
import org.hibernate.type.LocalTimeType;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.dto.Info;
import com.fa.persistence.KhachHang;
import com.fa.utils.PagingUtils;

@Repository
@Transactional
public class KhachHangDao extends EntityDao {

	public void insert(KhachHang khachHang) {
		Session session = getCurrentSession();
		String sql = "INSERT INTO KhachHang(ten_kh, dia_chi, so_dien_thoai, email)\n"
				+ "VALUES (:name,:address, :phone, :email)";
		NativeQuery<KhachHang> query = session.createNativeQuery(sql, KhachHang.class);
		query.setParameter("name", khachHang.getTenKH());
		query.setParameter("address", khachHang.getDiaChi());
		query.setParameter("phone", khachHang.getSoDienThoai());
		query.setParameter("email", khachHang.getEmail());
		query.executeUpdate();
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Info> getGeneralInformation(int page) {
		Session session = openSession();
		String sql = "SELECT kh.ma_kh AS "+ Info.MA_KH +",\n" + 
				"	   kh.ten_kh AS "+ Info.TEN_KH +",\n" +  
				"	   sdm.ma_may AS "+ Info.MA_MAY +",\n" +
				"	   m.vi_tri AS "+ Info.VI_TRI +",\n" +
				"	   m.trang_thai AS "+ Info.TRANG_THAI +",\n" +
				"	   sdm.ngay_bat_dau_su_dung AS "+ Info.M_NGAY_BAT_DAU_SU_DUNG +",\n" +
				"	   sdm.gio_bat_dau_su_dung AS "+ Info.M_GIO_BAT_DAU_SU_DUNG +",\n" +
				"	   sdm.thoi_gian_su_dung AS "+ Info.THOI_GIAN_SU_DUNG +",\n" +
				"	   sddv.ma_dv AS "+ Info.MA_DV +",\n" +
				"	   sddv.ngay_su_dung AS "+ Info.NGAY_SU_DUNG +",\n" +
				"	   sddv.gio_du_dung AS "+ Info.GIO_SU_DUNG +",\n" +
				"	   sddv.so_luong AS "+ Info.SO_LUONG +",\n" +
				"	   Tonghop.TongTien AS "+ Info.TONG_TIEN +"\n" +
				"FROM KhachHang kh\n" + 
				"LEFT JOIN SuDungMay sdm ON sdm.ma_kh = kh.ma_kh\n" + 
				"LEFT JOIN SuDungDichVu sddv ON sddv.ma_kh = kh.ma_kh\n" + 
				"LEFT JOIN May m ON m.ma_may = sdm.ma_may\n" + 
				"LEFT JOIN DichVu dv ON dv.ma_dv = sddv.ma_dv \n" + 
				"LEFT JOIN (\n" + 
				"	SELECT sddv1.ma_kh, SUM(sddv1.so_luong * dv1.don_gia) AS TongTien\n" + 
				"	FROM SuDungDichVu sddv1\n" + 
				"	JOIN DichVu dv1 ON sddv1.ma_dv = dv1.ma_dv\n" + 
				"	GROUP BY sddv1.ma_kh\n" + 
				") AS Tonghop ON kh.ma_kh = Tonghop.ma_kh";
		
		NativeQuery<?> query = session.createNativeQuery(sql);
		query.setMaxResults(PagingUtils.rowPerPage);
		query.setFirstResult((page -1) * PagingUtils.rowPerPage);
		query.addScalar(Info.MA_KH, StandardBasicTypes.NSTRING);
		query.addScalar(Info.TEN_KH, StandardBasicTypes.NSTRING);
		query.addScalar(Info.MA_MAY, StandardBasicTypes.NSTRING);
		query.addScalar(Info.VI_TRI, StandardBasicTypes.NSTRING);
		query.addScalar(Info.TRANG_THAI, StandardBasicTypes.NSTRING);
		query.addScalar(Info.M_NGAY_BAT_DAU_SU_DUNG, LocalDateType.INSTANCE);
		query.addScalar(Info.M_GIO_BAT_DAU_SU_DUNG, LocalTimeType.INSTANCE);
		query.addScalar(Info.THOI_GIAN_SU_DUNG, StandardBasicTypes.INTEGER);
		query.addScalar(Info.MA_DV, StandardBasicTypes.NSTRING);
		query.addScalar(Info.NGAY_SU_DUNG, LocalDateType.INSTANCE);
		query.addScalar(Info.GIO_SU_DUNG, LocalTimeType.INSTANCE);
		query.addScalar(Info.SO_LUONG, StandardBasicTypes.INTEGER);
		query.addScalar(Info.TONG_TIEN, StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(Info.class));
		return (List<Info>)query.list();
	}
	
	public Integer getRowCountGeneralInformation() {
		Session session = openSession();
		String sql = "SELECT count(*)\n" + 
				"FROM KhachHang kh\n" + 
				"LEFT JOIN SuDungMay sdm ON sdm.ma_kh = kh.ma_kh\n" + 
				"LEFT JOIN SuDungDichVu sddv ON sddv.ma_kh = kh.ma_kh";
		@SuppressWarnings("rawtypes")
		NativeQuery query = session.createNativeQuery(sql);
		return (Integer)query.uniqueResult();
	}
}
