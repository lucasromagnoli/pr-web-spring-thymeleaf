package br.com.lucasromagnoli.prwstj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("home/index")
	public ModelAndView home() {
		return new ModelAndView("/home/index");
	}
}
