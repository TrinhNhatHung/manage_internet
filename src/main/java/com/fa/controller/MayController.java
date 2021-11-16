package com.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.dao.MayDao;
import com.fa.persistence.May;
import com.fa.utils.PagingUtils;

@Controller
public class MayController {

	@Autowired
	private MayDao mayDao;

	@GetMapping(value = "/createMachine")
	public String getCreateMachine(Model model) {
		model.addAttribute("url", "createMachine");
		return "createMachine";
	}

	@PostMapping(value = "/createMachine")
	public String postCreateService(@RequestParam(name = "position") String position,
			@RequestParam(name = "status") String status, Model model) {
		model.addAttribute("url", "createMachine");
		May may = new May();
		may.setTrangThai(status);
		may.setViTri(position);
		try {
			mayDao.insert(may);
		} catch (Exception e) {
			model.addAttribute("may", may);
			model.addAttribute("message", "Thêm thất bại");
			return "createMachine";
		}
		return "redirect:createMachine";
	}

	@GetMapping(value = "/readMachine")
	public String getReadmachine(Model model, @RequestParam(name = "message", required = false) String message,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "searchMaMay", required = false) String searchMaMay) {
		model.addAttribute("url", "readMachine");
		if (page == null) {
			page = 1;
		}

		if (searchMaMay == null) {
			searchMaMay = "";
		}
		
		model.addAttribute("searchMaMay", searchMaMay);
		
		long rowCount = mayDao.getRowCount(May.class);
		int totalPage = PagingUtils.getTotalPages(rowCount);
		model.addAttribute("totalPages", totalPage);
		model.addAttribute("currentPage", page);
		int previousPage = page ==  1 ? 1 : page -1;
		model.addAttribute("previousPage", previousPage);
		int nextPage = page == totalPage ? totalPage : page +1;
		model.addAttribute("nextPage", nextPage);

		List<May> mays = mayDao.getPagingData(May.class, page, "ma_may", searchMaMay);
		model.addAttribute("mays", mays);
		model.addAttribute("message", message);
		return "readMachine";
	}
	
	@GetMapping(value = "/updateMachine")
	public String getUpdateCustomer(Model model, @RequestParam(name = "maMay") String maMay) {
		model.addAttribute("url", "updateMachine");
		May may = mayDao.getById(May.class, maMay);
		model.addAttribute("may", may);
		return "updateMachine";
	}
	
	@PostMapping(value = "/updateMachine")
	public String postUpdateCustomer(Model model, 
			@RequestParam(name = "maMay") String maMay,
			@RequestParam(name = "position") String position,
			@RequestParam(name = "status") String status) {
		model.addAttribute("url", "updateMachine");
		May may = new May(maMay, position, status);
		try {
			mayDao.update(may);
			return "redirect:readMachine";
		} catch (Exception e) {
			model.addAttribute("may", may);
			model.addAttribute("message", "Chỉnh sửa thất bại");
			return "updateMachine";
		}
	}

	@RequestMapping(value = "/deleteMachine")
	public String deleteCustomer(@RequestParam(name = "maMay") String maMay) {
		May may = new May();
		may.setMaMay(maMay);
		;
		try {
			mayDao.delete(may);
			return "redirect:readMachine?message=Delete success";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:readMachine?message=Delete failed";
		}
	}

}
