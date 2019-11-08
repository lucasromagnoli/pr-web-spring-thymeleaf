package br.com.lucasromagnoli.prwstj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucasromagnoli.prwstj.domain.model.User;

@Repository
public interface Users extends JpaRepository<User, Long>{

}
