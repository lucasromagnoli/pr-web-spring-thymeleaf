package br.com.lucasromagnoli.prwstj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lucasromagnoli.prwstj.domain.repository.Users;
import br.com.lucasromagnoli.prwstj.domain.support.PrwstjPropertiesSupport;
import br.com.lucasromagnoli.prwstj.web.constants.ControllerMapping;

@Controller
@RequestMapping({ControllerMapping.WEB_PATH_HOME_ROOT, ControllerMapping.WEB_PATH_ROOT})
public class HomeController {

	@Autowired
	PrwstjPropertiesSupport propertiesSupport;
	
	@Autowired
	Users users;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping
	public ModelAndView index() {
		users.findAll();
		return new ModelAndView(ControllerMapping.VIEW_HOME_INDEX);
	}
}
