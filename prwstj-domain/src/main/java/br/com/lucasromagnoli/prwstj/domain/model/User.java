package br.com.lucasromagnoli.prwstj.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User extends GenericModel implements Serializable {
	private static final long serialVersionUID = -7353134010202807214L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password_hash")
	private String passwordHash;
	
	@Transient
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	@Transient
	private String forgetPasswordToken;
	
	@Transient
	private LocalDateTime forgetPasswordTokenCreatedAt;
			
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public String getForgetPasswordToken() {
		return forgetPasswordToken;
	}
	
	public void setForgetPasswordToken(String forgetPasswordToken) {
		this.forgetPasswordToken = forgetPasswordToken;
	}
	
	public LocalDateTime getForgetPasswordTokenCreatedAt() {
		return forgetPasswordTokenCreatedAt;
	}

	public void setForgetPasswordTokenCreatedAt(LocalDateTime forgetPasswordTokenCreatedAt) {
		this.forgetPasswordTokenCreatedAt = forgetPasswordTokenCreatedAt;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
