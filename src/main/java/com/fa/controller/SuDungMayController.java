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
import com.fa.persistence.KhachHang;
import com.fa.persistence.May;
import com.fa.persistence.SuDungMay;
import com.fa.persistence.SuDungMay.Id;
import com.fa.utils.DateUtils;

@Controller
public class SuDungMayController {

	@Autowired
	private EntityDao entityDao;

	@GetMapping(value = "/dkSuDungMay")
	public String getCreateSuDungMay(Model model,@RequestParam(name = "message", required = false) String message) {
		model.addAttribute("url", "dkSuDungMay");
		List<String> maKHs = entityDao.getAll(KhachHang.class).stream().map(KhachHang::getMaKH)
				.collect(Collectors.toList());
		List<String> maMays = entityDao.getAll(May.class).stream().map(May::getMaMay).collect(Collectors.toList());
		model.addAttribute("maMays", maMays);
		model.addAttribute("maKHs", maKHs);
		model.addAttribute("message", message);
		return "dkSuDungMay";
	}

	@PostMapping(value = "/dkSuDungMay")
	public String postCreateSuDungMay(Model model, @RequestParam(name = "maKH") String maKH,
			@RequestParam(name = "maMay") String maMay,
			@RequestParam(name = "ngayBatDauSuDung") String ngayBatDauSuDung,
			@RequestParam(name = "gioBatDauSuDung") String gioBatDauSuDung,
			@RequestParam(name = "thoiGianSuDung") Integer thoiGianSuDung) {
		model.addAttribute("url", "dkSuDungMay");
		LocalDate ngay = DateUtils.convertStringToDate(ngayBatDauSuDung, "yyyy-MM-dd");
		LocalTime thoiGian = DateUtils.convertStringToTime(gioBatDauSuDung, "HH:mm");

		May may = entityDao.getById(May.class, maMay);
		KhachHang khachHang = entityDao.getById(KhachHang.class, maKH);

		SuDungMay suDungMay = new SuDungMay(new Id(maKH, maMay, ngay, thoiGian), thoiGianSuDung, may, khachHang);
		try {
			entityDao.update(suDungMay);
			return "redirect:dkSuDungMay";
		} catch (Exception e) {
			return "redirect:dkSuDungMay?message=Them that bai";
		}
	}
}
