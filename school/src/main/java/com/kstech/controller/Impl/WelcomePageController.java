package com.kstech.controller.Impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WelcomePageController {

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("view/index");
	}
	
	@RequestMapping("/bootstrap")
	public ModelAndView testBootStrap() {
		return new ModelAndView("view/firstbootstrap");
	}
}
