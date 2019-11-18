package br.com.lucasromagnoli.prwstj.security.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lucasromagnoli.prwstj.domain.model.User;
import br.com.lucasromagnoli.prwstj.domain.repository.jpa.UsersJpaRepository;
import br.com.lucasromagnoli.prwstj.domain.support.PrwstjPropertiesSupport;
import br.com.lucasromagnoli.prwstj.security.model.UserSystem;

@Service
public class PrwstjUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersJpaRepository usersJpaRepository;
	
	@Autowired
	private PrwstjPropertiesSupport prwstjPropertiesSupport;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> userOptional = usersJpaRepository.findByEmailIgnoreCase(email);
		User user = userOptional.orElseThrow(() -> new UsernameNotFoundException(prwstjPropertiesSupport.getProperty("security.messages.signin.user.notfound")));
		return new UserSystem(user, new HashSet<>());
	}

}
