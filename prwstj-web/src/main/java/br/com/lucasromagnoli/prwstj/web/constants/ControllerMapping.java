package br.com.lucasromagnoli.prwstj.web.constants;

public class ControllerMapping {

	/*
	 * Controlador privado. Evitando instancias deste objeto.
	 * O mesmo só possui o intuito de armazenar as constantes em variáveis estáticas.
	 */
	private ControllerMapping() {}

	// Web Root Paths
	public static final String WEB_PATH_ROOT											= "/";
	public static final String WEB_PATH_HOME_ROOT										= "/home";
	public static final String WEB_PATH_ERRORS_ROOT										= "/errors";
	public static final String WEB_PATH_USERS_ROOT										= "/users";
	
	// Web Page Paths
	public static final String WEB_PATH_ERRORS_404										= "/404";
	public static final String WEB_PATH_ERRORS_500										= "/500";
	public static final String WEB_PATH_ERRORS_GENERIC_MODULAR							= "/generic";
	public static final String WEB_PATH_USERS_SIGNUP									= "/signup";
	
	// Web Views
	public static final String VIEW_HOME_INDEX											= "/pages/home/index";
	public static final String VIEW_ERRORS_404											= "/pages/errors/404";
	public static final String VIEW_ERRORS_500											= "/pages/errors/500";
public static final String VIEW_ERRORS_GENERIC_MODULAR									= "/pages/errors/generic";
	public static final String VIEW_USERS_SIGNUP										= "/pages/users/signup";

	
}
