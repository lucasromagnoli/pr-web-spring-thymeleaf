package br.com.lucasromagnoli.prwstj.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import br.com.lucasromagnoli.prwstj.domain.model.User;

public class UserSystem extends org.springframework.security.core.userdetails.User{
	private static final long serialVersionUID = -3335552457508152893L;
	private User user;
	
	public UserSystem(User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getEmail(), user.getPasswordHash(), authorities);
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
}
