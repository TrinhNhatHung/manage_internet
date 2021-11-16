package com.fa.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dichvu")
public class DichVu {

	@Id
	@Column(name = "ma_dv")
	private String maDV;

	@Column(name = "ten_dv")
	private String tenDV;

	@Column(name = "don_vi_tinh")
	private String donViTinh;

	@Column(name = "don_gia")
	private Integer donGia;

	public DichVu() {
		super();
	}

	public DichVu(String maDV, String tenDV, String donViTinh, Integer donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public Integer getDonGia() {
		return donGia;
	}

	public void setDonGia(Integer donGia) {
		this.donGia = donGia;
	}

}
