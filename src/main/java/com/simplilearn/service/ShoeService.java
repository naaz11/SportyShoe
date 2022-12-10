package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entity.Shoe;
import com.simplilearn.repository.ShoeRepository;


@Service
public class ShoeService {

	@Autowired
	ShoeRepository shoeRepository;
	
	public List<Shoe> getShoes() {
		List<Shoe> shoes= new ArrayList<Shoe>();
		shoeRepository.findAll().forEach(shoe -> shoes.add(shoe));
		return shoes;
	} 
	
	public void saveShoe(Shoe shoe) {
		shoeRepository.save(shoe);
	}
		
	public void delete(int id) {
		shoeRepository.deleteById(id);
	}
	
	public ModelAndView tabulateShoes() {
		ModelAndView mav = new ModelAndView("shoe_inventory");
		mav.addObject("shoes", shoeRepository.findAll());
		return mav;
	}

}