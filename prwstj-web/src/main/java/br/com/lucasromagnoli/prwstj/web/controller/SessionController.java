package br.com.lucasromagnoli.prwstj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.lucasromagnoli.prwstj.domain.model.User;
import br.com.lucasromagnoli.prwstj.web.constants.ControllerMapping;

@Controller
@RequestMapping(ControllerMapping.WEB_PATH_SESSION_ROOT)
public class SessionController {

	@GetMapping(ControllerMapping.WEB_PATH_SESSION_SIGNIN)
	public ModelAndView showSignIn(User user) {
		ModelAndView mv = new ModelAndView(ControllerMapping.VIEW_SESSION_SIGIN);
		
		return mv;
	}
	
	@GetMapping(ControllerMapping.WEB_PATH_SESSION_SIGNIN_FAIL)
	public ModelAndView showFailureSignIn(RedirectAttributes redirectAttrs) {
		ModelAndView mv = new ModelAndView(ControllerMapping.WEB_REDIRECT_PATH_SESSION_SIGNIN);
//		redirectAttrs.addFlashAttribute("messagem", "Erro ao gerar login, favor verificar");
		
		return mv;
	}
	
}
