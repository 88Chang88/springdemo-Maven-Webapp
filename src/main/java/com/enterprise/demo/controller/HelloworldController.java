package com.enterprise.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enterprise.common.controller.BaseController;

@Controller
@RequestMapping("/helloworld")
public class HelloworldController extends BaseController{
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model){
		LOGGER.debug("This is the first log4j debug");
		model.addAttribute("user", null);
		return "helloworld";
	}

}
