package com.fa.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khachhang")
public class KhachHang {

	@Id
	@Column(name = "ma_kh")
	private String maKH;

	@Column(name = "ten_kh")
	private String tenKH;

	@Column(name = "dia_chi")
	private String diaChi;

	@Column(name = "so_dien_thoai")
	private String soDienThoai;

	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
	private List<SuDungMay> suDungMays;
	
	@OneToMany(mappedBy = "dichVu", fetch = FetchType.LAZY)
	private List<SuDungDichVu> suDungDichVus; 

	public KhachHang() {
		super();
	}

	public KhachHang(String maKH, String tenKH, String diaChi, String soDienThoai, String email) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
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

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
