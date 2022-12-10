package com.simplilearn.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entity.SalesRecord;
import com.simplilearn.repository.SalesRepository;

@Service
public class SalesService {

	@Autowired
	SalesRepository salesRepository;
	
	public List<SalesRecord> getSales() {
		List<SalesRecord> sales= new ArrayList<SalesRecord>();
		salesRepository.findAll().forEach(salesRecord -> sales.add(salesRecord));
		
		// 1. Sales Record comparator
        Comparator<SalesRecord> catComparatorLEx = 
                (sale1, sale2) -> sale1.getCategory().compareTo(sale2.getCategory());
 
        // 2. customer City comparator
        Comparator<SalesRecord> dateComparatorLEx = 
                (sale1, sale2) -> sale1.getSaledate().compareTo(sale2.getSaledate());
		
		List<SalesRecord> sortedSalesList = sales
                .stream()
                .sorted(
                        catComparatorLEx // 1st compare date
                        .thenComparing(dateComparatorLEx)) // then 2nd compare Category
                .collect(Collectors.toList()); // collect sorted salesecords to new list
 
        // print new list to console using forEach()
        //sortedSalesList.stream().forEach(salesRecord -> System.out.println(cust));
    
		return sortedSalesList;
	} 
	
	public void saveSale(SalesRecord sale) {
		salesRepository.save(sale);
	}

	public ModelAndView tabulateSales() {
		ModelAndView mav = new ModelAndView("sales_records");
		mav.addObject("sales", getSales());
		return mav;
	}
}