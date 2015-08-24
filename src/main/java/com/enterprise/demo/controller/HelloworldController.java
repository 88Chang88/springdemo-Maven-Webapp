package com.enterprise.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/helloworld")
public class HelloworldController {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		System.out.println("20150824");
		return "index";
	}

}
