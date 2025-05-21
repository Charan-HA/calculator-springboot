package com.example.calci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.calci.service.CalcService;

@Controller
public class CalciController {
	
	@Autowired
	CalcService cs;
	
	@GetMapping("/calc")
	public String calc(@RequestParam int num1, @RequestParam int num2, @RequestParam String operation, Model m) {
		
		int res = 0;
		if (operation.equals("add")) {
			res = cs.add(num1, num2);
		} else if (operation.equals("sub")) {
			res = cs.sub(num1, num2);
		} else if (operation.equals("mul")) {
			res = cs.mul(num1, num2);
		} else {
			res = cs.div(num1, num2);
		}
		
		m.addAttribute("result", res);
		return "result";
	}
}
