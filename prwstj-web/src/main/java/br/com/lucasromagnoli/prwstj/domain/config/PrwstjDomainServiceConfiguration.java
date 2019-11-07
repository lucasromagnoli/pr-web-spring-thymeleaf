package br.com.lucasromagnoli.prwstj.domain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =  {PrwstjDomainConfigurationParameters.PACKAGE_SERVICE, PrwstjDomainConfigurationParameters.PACKAGE_SUPPORT, PrwstjDomainConfigurationParameters.PACKAGE_VALIDATION})
public class PrwstjDomainServiceConfiguration {

}
