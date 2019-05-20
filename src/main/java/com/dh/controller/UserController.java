package com.dh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String jumpIndex() {
		return "index";
	}


	/**
	 * json
	 * 
	 * @return
	 */
	@RequestMapping("/jsonIndex")
	@ResponseBody
	public String jsonIndex() {
		return "nihao";
	}
}
