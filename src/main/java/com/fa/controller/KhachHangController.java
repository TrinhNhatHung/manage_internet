package com.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.dao.KhachHangDao;
import com.fa.dto.Info;
import com.fa.persistence.KhachHang;
import com.fa.utils.PagingUtils;

@Controller
public class KhachHangController {

	@Autowired
	private KhachHangDao khachhangDao;

	@GetMapping(value = "/createCustomer")
	public String getCreateCustomer(Model model) {
		model.addAttribute("url", "createCustomer");
		return "createCustomer";
	}

	@PostMapping(value = "/createCustomer")
	public String postCreateCustomer(@RequestParam(name = "name") String name,
			@RequestParam(name = "phone") String phone, @RequestParam(name = "email") String email,
			@RequestParam(name = "address") String address, Model model) {
		model.addAttribute("url", "createCustomer");
		KhachHang khachHang = new KhachHang();
		khachHang.setDiaChi(address);
		khachHang.setEmail(email);
		khachHang.setSoDienThoai(phone);
		khachHang.setTenKH(name);
		try {
			khachhangDao.insert(khachHang);
		} catch (Exception e) {
			model.addAttribute("khachhang", khachHang);
			model.addAttribute("message", "Thêm thất bại");
			return "createCustomer";
		}
		return "redirect:createCustomer";
	}

	@GetMapping(value = "/readCustomer")
	public String getReadCustomer(Model model, @RequestParam(name = "message", required = false) String message,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "searchName", required = false) String searchName) {
		model.addAttribute("url", "readCustomer");
		if (page == null) {
			page = 1;
		}

		if (searchName == null) {
			searchName = "";
		}

		model.addAttribute("searchName", searchName);

		long rowCount = khachhangDao.getRowCount(KhachHang.class);
		int totalPage = PagingUtils.getTotalPages(rowCount);
		model.addAttribute("totalPages", totalPage);
		model.addAttribute("currentPage", page);
		int previousPage = page == 1 ? 1 : page - 1;
		model.addAttribute("previousPage", previousPage);
		int nextPage = page == totalPage ? totalPage : page + 1;
		model.addAttribute("nextPage", nextPage);

		List<KhachHang> khachHangs = khachhangDao.getPagingData(KhachHang.class, page, "ten_kh", searchName);
		model.addAttribute("khachHangs", khachHangs);
		model.addAttribute("message", message);
		return "readCustomer";
	}

	@GetMapping(value = "/updateCustomer")
	public String getUpdateCustomer(Model model, @RequestParam(name = "maKH") String maKH) {
		model.addAttribute("url", "updateCustomer");
		KhachHang khachHang = khachhangDao.getById(KhachHang.class, maKH);
		model.addAttribute("khachhang", khachHang);
		return "updateCustomer";
	}

	@PostMapping(value = "/updateCustomer")
	public String postUpdateCustomer(@RequestParam(name = "maKH") String maKH,
								@RequestParam(name = "name") String name,
								@RequestParam(name = "phone") String phone, 
								@RequestParam(name = "email") String email,
								@RequestParam(name = "address") String address,
								Model model) {
		model.addAttribute("url", "updateCustomer");
		KhachHang khachHang = new KhachHang(maKH, name, address, phone, email);
		try {
			khachhangDao.update(khachHang);
			return "redirect:readCustomer";
		} catch (Exception e) {
			model.addAttribute("khachhang", khachHang);
			model.addAttribute("message", "Chỉnh sửa thất bại");
			return "updateCustomer";
		}
	}

	@RequestMapping(value = "/deleteCustomer")
	public String deleteCustomer(@RequestParam(name = "maKH") String maKH) {
		KhachHang khachHang = new KhachHang();
		khachHang.setMaKH(maKH);
		try {
			khachhangDao.delete(khachHang);
			return "redirect:readCustomer?message=Delete success";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:readCustomer?message=Delete failed";
		}
	}
	
	@RequestMapping(value = "/info")
	public String getAll (Model model,@RequestParam(name = "page", required = false) Integer page) {
		if (page == null) {
			page = 1;
		}
		model.addAttribute("url", "info");
		int rowCount = khachhangDao.getRowCountGeneralInformation();
		int totalPage = PagingUtils.getTotalPages(rowCount);
		model.addAttribute("totalPages", totalPage);
		model.addAttribute("currentPage", page);
		int previousPage = page == 1 ? 1 : page - 1;
		model.addAttribute("previousPage", previousPage);
		int nextPage = page == totalPage ? totalPage : page + 1;
		model.addAttribute("nextPage", nextPage);
		
		List<Info> infos = khachhangDao.getGeneralInformation(page);
		model.addAttribute("infos", infos);
		return "info";
	}
}
