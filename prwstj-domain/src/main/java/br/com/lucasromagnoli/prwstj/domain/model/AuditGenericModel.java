package br.com.lucasromagnoli.prwstj.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Transient;

public abstract class AuditGenericModel {

	@Transient
	private LocalDateTime createdAt;
	
	@Transient
	private LocalDateTime updatedAt;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
