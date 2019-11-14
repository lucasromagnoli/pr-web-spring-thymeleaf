package br.com.lucasromagnoli.prwstj.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.lucasromagnoli.prwstj.web.constants.ControllerMapping;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("$2y$08$2Q41qS0ZylZToUP2WRMLO.WLRw1nOWKlnyNohn.qyWFz0mmnSDvsO").roles("ADMISNTRADOR_GERAL");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/session/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage(ControllerMapping.WEB_ROOT_PATH_SIGNIN)
				.defaultSuccessUrl(ControllerMapping.WEB_PATH_ROOT)
				.failureUrl(ControllerMapping.WEB_ROOT_PATH_SIGNIN_FAIL)
				.usernameParameter("email")
				.permitAll()
				.and()
			.csrf().disable();
			
			
	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
