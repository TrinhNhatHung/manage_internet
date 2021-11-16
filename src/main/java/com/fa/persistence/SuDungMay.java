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
@Table(name = "SuDungMay")
public class SuDungMay {

	@EmbeddedId
	private Id id;

	@Column(name = "thoi_gian_su_dung")
	private Integer thoiGianSuDung;

	public SuDungMay(Id id, Integer thoiGianSuDung, May may, KhachHang khachHang) {
		super();
		this.id = id;
		this.thoiGianSuDung = thoiGianSuDung;
		this.may = may;
		this.khachHang = khachHang;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maKH")
	@JoinColumn(name = "ma_kh", referencedColumnName = "ma_kh")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maMay")
	@JoinColumn(name = "ma_may", referencedColumnName = "ma_may")
	private May may;

	@Embeddable
	public static class Id implements Serializable {

		private static final long serialVersionUID = 4867517437792552438L;

		@Column(name = "ma_kh")
		private String maKH;

		@Column(name = "ma_may")
		private String maMay;

		@Column(name = "ngay_bat_dau_su_dung")
		private LocalDate ngayBatDauSuDung;

		@Column(name = "gio_bat_dau_su_dung")
		private LocalTime gioBatDauSuDung;

		public Id() {
			super();
		}

		public Id(String maKH, String maMay, LocalDate ngayBatDauSuDung, LocalTime gioBatDauSuDung) {
			super();
			this.maKH = maKH;
			this.maMay = maMay;
			this.ngayBatDauSuDung = ngayBatDauSuDung;
			this.gioBatDauSuDung = gioBatDauSuDung;
		}

		public String getMaKH() {
			return maKH;
		}

		public void setMaKH(String maKH) {
			this.maKH = maKH;
		}

		public String getMaMay() {
			return maMay;
		}

		public void setMaMay(String maMay) {
			this.maMay = maMay;
		}

		public LocalDate getNgayBatDauSuDung() {
			return ngayBatDauSuDung;
		}

		public void setNgayBatDauSuDung(LocalDate ngayBatDauSuDung) {
			this.ngayBatDauSuDung = ngayBatDauSuDung;
		}

		public LocalTime getGioBatDauSuDung() {
			return gioBatDauSuDung;
		}

		public void setGioBatDauSuDung(LocalTime gioBatDauSuDung) {
			this.gioBatDauSuDung = gioBatDauSuDung;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	}
}
