package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entity.SalesRecord;
import com.simplilearn.service.SalesService;

@RestController
public class SalesController {
	
	@Autowired
	SalesService salesService;
	
	@GetMapping("/sales")
	public List<SalesRecord> getAllSales(){
		return salesService.getSales();
	}

	@PostMapping("/sales")
	public int saveSale(@RequestBody SalesRecord sale) {
		salesService.saveSale(sale);
		return sale.getId();
	}
	
	@GetMapping({"/sales_records"})
	public ModelAndView tabulateSales() {
		ModelAndView mav1 = salesService.tabulateSales();
		return mav1;
	}
}
