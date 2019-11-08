package br.com.lucasromagnoli.prwstj.domain.config.init;

import br.com.lucasromagnoli.prwstj.domain.config.PrwstjDomainJpaConfiguration;
import br.com.lucasromagnoli.prwstj.domain.config.PrwstjDomainServiceConfiguration;

public class PrwstjDomainInitializer {

	private PrwstjDomainInitializer() {}
	
	public static Class<?>[] getRootConfigClasses(){
		return new Class[] {
				PrwstjDomainServiceConfiguration.class,
				PrwstjDomainJpaConfiguration.class
				};
		}
}
