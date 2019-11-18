package br.com.lucasromagnoli.prwstj.domain.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:/br/com/lucasromagnoli/prwstj/prwstj-messages.properties", encoding = "UTF-8")
@PropertySource(value = "classpath:/br/com/lucasromagnoli/prwstj/prwstj-security-messages.properties", encoding = "UTF-8")
public class PrwstjPropertiesSupport {

	@Autowired
	private Environment env;
	
	public String getProperty(String key) {
		return env.getProperty(key);
	}
}
