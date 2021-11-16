package com.fa.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Info {

	public static final String MA_KH = "maKH";
	public static final String TEN_KH = "tenKH";
	public static final String MA_MAY = "maMay";
	public static final String VI_TRI = "viTri";
	public static final String TRANG_THAI = "trangThai";
	public static final String M_NGAY_BAT_DAU_SU_DUNG = "m_ngayBatDauSuDung";
	public static final String M_GIO_BAT_DAU_SU_DUNG = "m_gioBatDauSuDung";
	public static final String THOI_GIAN_SU_DUNG = "thoiGianSuDung";
	public static final String MA_DV = "maDV";
	public static final String NGAY_SU_DUNG = "ngaySuDung";
	public static final String GIO_SU_DUNG = "gioSuDung";
	public static final String SO_LUONG = "soLuong";
	public static final String TONG_TIEN = "tongTien";

	private String maKH;
	private String tenKH;
	private String maMay;
	private String viTri;
	private String trangThai;
	private LocalDate m_ngayBatDauSuDung;
	private LocalTime m_gioBatDauSuDung;
	private Integer thoiGianSuDung;
	private String maDV;
	private LocalDate ngaySuDung;
	private LocalTime gioSuDung;
	private Integer soLuong;
	private Integer tongTien;

	public Info() {
		super();
	}

	public Info(String maKH, String tenKH, String maMay, String viTri, String trangThai, LocalDate m_ngayBatDauSuDung,
			LocalTime m_gioBatDauSuDung, Integer thoiGianSuDung, String maDV, LocalDate ngaySuDung, LocalTime gioSuDung,
			Integer soLuong, Integer tongTien) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
		this.m_ngayBatDauSuDung = m_ngayBatDauSuDung;
		this.m_gioBatDauSuDung = m_gioBatDauSuDung;
		this.thoiGianSuDung = thoiGianSuDung;
		this.maDV = maDV;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public LocalDate getM_ngayBatDauSuDung() {
		return m_ngayBatDauSuDung;
	}

	public void setM_ngayBatDauSuDung(LocalDate m_ngayBatDauSuDung) {
		this.m_ngayBatDauSuDung = m_ngayBatDauSuDung;
	}

	public LocalTime getM_gioBatDauSuDung() {
		return m_gioBatDauSuDung;
	}

	public void setM_gioBatDauSuDung(LocalTime m_gioBatDauSuDung) {
		this.m_gioBatDauSuDung = m_gioBatDauSuDung;
	}

	public Integer getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(Integer thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public LocalDate getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(LocalDate ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public LocalTime getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(LocalTime gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Integer getTongTien() {
		return tongTien;
	}

	public void setTongTien(Integer tongTien) {
		this.tongTien = tongTien;
	}

}
