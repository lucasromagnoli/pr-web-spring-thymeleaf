package br.com.lucasromagnoli.prwstj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lucasromagnoli.prwstj.web.constants.ControllerMapping;

@Controller
@RequestMapping(ControllerMapping.PATH_HOME_ROOT)
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@GetMapping
	public ModelAndView index() {
		return new ModelAndView(ControllerMapping.VIEW_HOME_INDEX);
	}
}
