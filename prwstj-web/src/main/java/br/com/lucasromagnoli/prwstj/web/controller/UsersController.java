package br.com.lucasromagnoli.prwstj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lucasromagnoli.prwstj.domain.model.User;
import br.com.lucasromagnoli.prwstj.web.constants.ControllerMapping;

@Controller
@RequestMapping(ControllerMapping.WEB_PATH_USERS_ROOT)
public class UsersController {

	@GetMapping(ControllerMapping.WEB_PATH_USERS_SIGNUP)
	public ModelAndView cadastrar(User user) {
		ModelAndView mv = new ModelAndView(ControllerMapping.VIEW_USERS_SIGNUP);
		
		return mv;
	}
}
