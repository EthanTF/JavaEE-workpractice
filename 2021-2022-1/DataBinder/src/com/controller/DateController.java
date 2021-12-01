package com.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {

	@RequestMapping(value="/date")
	public String testDate(Date d,Model m)
	{
		m.addAttribute("date",d);
		System.out.println("Ê±¼äÎª"+ d);
		return "success";
	}
}
