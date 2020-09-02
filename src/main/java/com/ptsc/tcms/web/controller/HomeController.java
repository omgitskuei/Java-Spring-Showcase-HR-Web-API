package com.ptsc.tcms.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	/**
	 * Log
	 */
	private final static Logger log = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Constructor
	 */
	@Autowired
	public HomeController() {
	
	}

	/**
	 * Turn to Home Page
	 * 
	 * @return view to home/index.html
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("helloworld");
		
		String string = "string passed from controller";
		model.addObject("s", string);
		
		int i = 1;
		model.addObject("integer", i);
		
		
		
		return model;
	}
	
}
