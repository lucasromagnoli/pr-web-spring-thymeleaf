package br.com.lucasromagnoli.prwstj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lucasromagnoli.prwstj.domain.model.User;
import br.com.lucasromagnoli.prwstj.domain.support.PrwstjPropertiesSupport;
import br.com.lucasromagnoli.prwstj.domain.validation.UserValidator;
import br.com.lucasromagnoli.prwstj.web.constants.ControllerMapping;

@Controller
@RequestMapping(ControllerMapping.WEB_PATH_USERS_ROOT)
public class UsersController {

	@Autowired
	UserValidator userValidator;
	
	@Autowired
	PrwstjPropertiesSupport propertiesSupport;
	
	Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@GetMapping(ControllerMapping.WEB_PATH_USERS_SIGNUP)
	public ModelAndView showSignUp(User user) {
		ModelAndView mv = new ModelAndView(ControllerMapping.VIEW_USERS_SIGNUP);
		
		return mv;
	}
	
	@PostMapping(ControllerMapping.WEB_PATH_USERS_SIGNUP)
	public ModelAndView doSignUp(User user, BindingResult result) {
		ModelAndView mv = new ModelAndView(ControllerMapping.VIEW_USERS_SIGNUP);
		logger.info(String.format("Tentava de cadastro, dados recebidos: %s", user.toString()));
		userValidator.validateSignUp(user, result);
		
		String x = propertiesSupport.getProperty("validator.input.generic.field.required");
		if(!result.hasErrors()) {
			logger.info("Não houve erros");
		}
		
		return mv;
	}
}
