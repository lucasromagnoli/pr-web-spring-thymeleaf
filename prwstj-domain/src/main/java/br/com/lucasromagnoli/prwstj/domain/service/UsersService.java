package br.com.lucasromagnoli.prwstj.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasromagnoli.prwstj.domain.model.User;
import br.com.lucasromagnoli.prwstj.domain.repository.jpa.UsersJpaRepository;

@Service
public class UsersService {

	@Autowired
	UsersJpaRepository usersJpaRepository;
	
	public void save(User user) {
		user.setPasswordHash(user.getPassword());
		usersJpaRepository.save(user);
	}
	
}
