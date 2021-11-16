package com.fa.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.dao.EntityDao;
import com.fa.persistence.DichVu;
import com.fa.persistence.KhachHang;
import com.fa.persistence.SuDungDichVu;
import com.fa.persistence.SuDungDichVu.Id;
import com.fa.utils.DateUtils;

@Controller
public class SuDungDVController {

	@Autowired
	private EntityDao entityDao;

	@GetMapping(value = "/dkSuDungDV")
	public String getCreateSuDungDV(Model model, @RequestParam(name = "message", required = false) String message) {
		model.addAttribute("url", "dkSuDungDV");
		List<String> maKHs = entityDao.getAll(KhachHang.class).stream().map(KhachHang::getMaKH)
				.collect(Collectors.toList());
		List<String> maDVs = entityDao.getAll(DichVu.class).stream().map(DichVu::getMaDV).collect(Collectors.toList());
		model.addAttribute("maDVs", maDVs);
		model.addAttribute("maKHs", maKHs);
		model.addAttribute("message", message);
		return "dkSuDungDV";
	}

	@PostMapping(value = "/dkSuDungDV")
	public String postCreateSuDungDV(Model model, 
			@RequestParam(name = "maKH") String maKH,
			@RequestParam(name = "maDV") String maDV, 
			@RequestParam(name = "ngaySuDung") String ngaySuDung,
			@RequestParam(name = "gioSuDung") String gioSuDung, 
			@RequestParam(name = "soLuong") Integer soLuong) {
		model.addAttribute("url", "dkSuDungDV");
		LocalDate ngay = DateUtils.convertStringToDate(ngaySuDung, "yyyy-MM-dd");
		LocalTime thoiGian = DateUtils.convertStringToTime(gioSuDung, "HH:mm");

		KhachHang khachHang = entityDao.getById(KhachHang.class, maKH);
		DichVu dichVu = entityDao.getById(DichVu.class, maDV);

		SuDungDichVu suDungDichVu = new SuDungDichVu(new Id(maKH, maDV, ngay, thoiGian), soLuong, khachHang, dichVu);
		try {
			entityDao.update(suDungDichVu);
			return "redirect:dkSuDungDV";
		} catch (Exception e) {
			return "redirect:dkSuDungDV?message=Them that bai";
		}
	}
}
