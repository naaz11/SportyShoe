package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entity.Shoe;
import com.simplilearn.repository.ShoeRepository;
import com.simplilearn.service.ShoeService;


@RestController
public class ShoeController {
	
	@Autowired
	ShoeService shoeService;
	ShoeRepository shoeRepository;
	
	@GetMapping("/shoes")
	public List<Shoe> getAllShoes(){
		return shoeService.getShoes();
	}
	
	@DeleteMapping("/shoes")
	public void deleteShoe(@RequestParam("id") int id) {
		shoeService.delete(id);
	}
	
	@PostMapping("/shoes")
	public int saveShoes(@RequestBody Shoe shoe) {
		shoeService.saveShoe(shoe);
		return shoe.getId();
	}
	
	@GetMapping({"/shoe_inventory"})
	public ModelAndView tabulateShoes() {
		ModelAndView mav1 = shoeService.tabulateShoes();
		return mav1;
	}
}

