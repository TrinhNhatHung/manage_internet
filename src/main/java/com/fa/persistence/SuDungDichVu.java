package com.fa.persistence;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "SuDungDichVu")
public class SuDungDichVu {

	@EmbeddedId
	private Id id;

	@Column(name = "so_luong")
	private Integer soLuong;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maKH")
	@JoinColumn(name = "ma_kh", referencedColumnName = "ma_kh")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maDV")
	@JoinColumn(name = "ma_dv", referencedColumnName = "ma_dv")
	private DichVu dichVu;

	public SuDungDichVu(Id id, Integer soLuong, KhachHang khachHang, DichVu dichVu) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.khachHang = khachHang;
		this.dichVu = dichVu;
	}

	public SuDungDichVu(Id id, Integer soLuong) {
		super();
		this.id = id;
		this.soLuong = soLuong;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	@Embeddable
	public static class Id implements Serializable {

		private static final long serialVersionUID = 4867517437792552438L;

		@Column(name = "ma_kh")
		private String maKH;

		@Column(name = "ma_dv")
		private String maDV;

		@Column(name = "ngay_su_dung")
		private LocalDate ngaySuDung;

		@Column(name = "gio_du_dung")
		private LocalTime gioSuDung;

		public Id() {

		}

		public Id(String maKH, String maDV, LocalDate ngaySuDung, LocalTime gioSuDung) {
			super();
			this.maKH = maKH;
			this.maDV = maDV;
			this.ngaySuDung = ngaySuDung;
			this.gioSuDung = gioSuDung;
		}

		public String getMaKH() {
			return maKH;
		}

		public void setMaKH(String maKH) {
			this.maKH = maKH;
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

	}
}
