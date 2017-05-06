package com.niit.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;


@Controller
public class HomeController {
	
	@Autowired HttpSession session;
	@Autowired Category category;
	@Autowired CategoryDAO categoryDAO;
	//Whenever the user open our web site, it should navigate to home page
	//http://localhost:8080/ShoppingCart/
	
	

	@RequestMapping("/")
	public ModelAndView  goToHome()
	
	{
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("messagesss", "Thank you for visiting Shopping Cart");
		return mv;
		
		/*List<Category> categoryList=categoryDAO.list();
		
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category",category);*/
}
	
	
	@RequestMapping("/LoginPage")
	public String loginPage(Model model)
	{
		model.addAttribute("isUserClickedLogin", "true");
	
		return "Home";
	}
	
	@RequestMapping("/RegistrationPage")
	public String registrationPage(Model model)
	{
		model.addAttribute("isUserClickedRegister", "true");
		
		return "Home";
	}
	

}
