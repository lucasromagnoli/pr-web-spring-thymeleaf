package br.com.lucasromagnoli.prwstj.domain.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucasromagnoli.prwstj.domain.model.User;

@Repository
public interface UsersJpaRepository extends JpaRepository<User, Long>{
	public boolean existsUserByEmail(String email);
}
