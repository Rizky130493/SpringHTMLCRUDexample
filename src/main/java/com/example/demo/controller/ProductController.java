package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product>listProducts = service.listAll();
		model.addAttribute("listProducts",listProducts);
		System.out.println("listProducts");
		return "/homepage/index";//sesuai alamat file html
	}
	
	@RequestMapping("/new")
	public String showNewProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return"/homepage/new_product";//sesuai alamat file html
	}
	@RequestMapping (value="/save", method=RequestMethod.POST)
	public String saveProduct (@ModelAttribute("product")Product product){
		service.save(product);
		return "redirect:/";//balik ke halaman awal
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProduct(@PathVariable(name = "id")Long id) {
		ModelAndView mav= new ModelAndView("homepage/edit_product");//sesuai alamat file html
		Product product = service.get(id);
		mav.addObject("product", product);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id")Long id) {
		service.delete(id);
		return "redirect:/";//balik ke halaman awal
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
