package com.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.dao.DichVuDao;
import com.fa.persistence.DichVu;
import com.fa.utils.PagingUtils;

@Controller
public class DichVuController {

	@Autowired
	private DichVuDao dichvuDao;

	@GetMapping(value = "/createService")
	public String getCreateService(Model model) {
		model.addAttribute("url", "createService");
		return "createService";
	}

	@PostMapping(value = "/createService")
	public String postCreateService(@RequestParam(name = "name") String name, @RequestParam(name = "unit") String unit,
			@RequestParam(name = "price") Integer price, Model model) {
		model.addAttribute("url", "createService");
		DichVu dichVu = new DichVu();
		dichVu.setDonGia(price);
		dichVu.setDonViTinh(unit);
		dichVu.setTenDV(name);
		try {
			dichvuDao.insert(dichVu);
		} catch (Exception e) {
			model.addAttribute("dichvu", dichVu);
			model.addAttribute("message", "Thêm thất bại");
			e.printStackTrace();
			return "createService";
		}
		return "redirect:createService";
	}

	@GetMapping(value = "/readService")
	public String getReadService(Model model, @RequestParam(name = "message", required = false) String message,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "searchName", required = false) String searchName) {
		model.addAttribute("url", "readService");
		if (page == null) {
			page = 1;
		}

		if (searchName == null) {
			searchName = "";
		}

		model.addAttribute("searchName", searchName);

		long rowCount = dichvuDao.getRowCount(DichVu.class);
		int totalPage = PagingUtils.getTotalPages(rowCount);
		model.addAttribute("totalPages", totalPage);
		model.addAttribute("currentPage", page);
		int previousPage = page == 1 ? 1 : page - 1;
		model.addAttribute("previousPage", previousPage);
		int nextPage = page == totalPage ? totalPage : page + 1;
		model.addAttribute("nextPage", nextPage);

		List<DichVu> dichVus = dichvuDao.getPagingData(DichVu.class, page, "ten_dv", searchName);

		model.addAttribute("dichVus", dichVus);
		model.addAttribute("message", message);
		return "readService";
	}
	
	@GetMapping(value = "/updateService")
	public String getUpdateService(Model model, @RequestParam(name = "maDV") String maDV) {
		model.addAttribute("url", "updateService");
		DichVu dichVu = dichvuDao.getById(DichVu.class, maDV);
		model.addAttribute("dichvu", dichVu);
		return "updateService";
	}

	@PostMapping(value = "/updateService")
	public String postUpdateService(@RequestParam(name = "maDV") String maDV,
			@RequestParam(name = "name") String name, 
			@RequestParam(name = "unit") String unit,
			@RequestParam(name = "price") Integer price, 
			Model model) {
		model.addAttribute("url", "updateService");
		DichVu dichVu = new DichVu(maDV, name, unit, price);
		try {
			dichvuDao.update(dichVu);
			return "redirect:readService";
		} catch (Exception e) {
			model.addAttribute("dichvu", dichVu);
			model.addAttribute("message", "Chỉnh sửa thất bại");
			return "updateService";
		}
	}

	@RequestMapping(value = "/deleteService")
	public String deleteCustomer(Model model,@RequestParam(name = "maDV") String maDV) {
		model.addAttribute("url", "deleteService");
		DichVu dichVu = new DichVu();
		dichVu.setMaDV(maDV);
		try {
			dichvuDao.delete(dichVu);
			return "redirect:readService?message=Delete success";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:readService?message=Delete failed";
		}
	}
}
