package br.com.lucasromagnoli.prwstj.web.config.init;

import javax.servlet.Filter;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.lucasromagnoli.prwstj.domain.config.init.PrwstjDomainInitializer;
import br.com.lucasromagnoli.prwstj.web.config.PrwstjWebConfig;
import br.com.lucasromagnoli.prwstj.web.config.SecurityConfig;

public class PrwstjWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		Class<?>[] rootConfigClasses = PrwstjDomainInitializer.getRootConfigClasses();
		rootConfigClasses = ArrayUtils.add(rootConfigClasses, SecurityConfig.class);
		return rootConfigClasses;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { PrwstjWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return new Filter[] { characterEncodingFilter };
	}
	
}
