package br.com.lucasromagnoli.prwstj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lucasromagnoli.prwstj.web.constants.ControllerMapping;

@Controller
@RequestMapping(ControllerMapping.PATH_ERRORS_ROOT)
public class ErrorsController {

	@GetMapping(ControllerMapping.PATH_ERRORS_404)
	public ModelAndView pathNotFound() {
		return new ModelAndView(ControllerMapping.VIEW_ERRORS_404);
	}
	
	@GetMapping(ControllerMapping.PATH_ERRORS_500)
	public ModelAndView internalServerError() {
		return new ModelAndView(ControllerMapping.VIEW_ERRORS_500);
	}
	
	@GetMapping(ControllerMapping.PATH_ERRORS_GENERIC_MODULAR)
	public ModelAndView genericError() {
		return new ModelAndView(ControllerMapping.VIEW_ERRORS_GENERIC_MODULAR);
	}
}
