package br.com.lucasromagnoli.prwstj.web.config.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.lucasromagnoli.prwstj.domain.config.init.PrwstjDomainInitializer;
import br.com.lucasromagnoli.prwstj.web.config.WebConfig;

public class PrwstjWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		Class<?>[] rootConfigClasses = PrwstjDomainInitializer.getRootConfigClasses();
		return rootConfigClasses;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
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
