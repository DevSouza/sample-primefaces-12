package br.com.devsouza.convexus.web.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CUSTOMER")
public class Customer {

	@Id
	@UuidGenerator
	private UUID customerId;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "type_customer", nullable = false)
	private CustomerType type;
	
	@NotBlank @Column(nullable = false)
	private String fullname;

	@Column(nullable = true)
	private String socialName;
	
	@NotNull @Column(nullable = false)
	private LocalDate startDate; // data de criacao da empresa || Aniversario do cliente
	
	@NotBlank @Column(nullable = false)
	private String federalIdentificationNumber;
	
	@NotNull @Column(nullable = false)
	private LocalDateTime createdAt;
	
	@NotNull @Column(nullable = false)
	private LocalDateTime updatedAt;
	
	public Customer() {
		this.type = CustomerType.NATURAL_PERSON;
	}
	
	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	@PreUpdate
	public void preUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
	public UUID getCustomerId() {
		return customerId;
	}
	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}
	public CustomerType getType() {
		return type;
	}
	public void setType(CustomerType type) {
		this.type = type;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getSocialName() {
		return socialName;
	}
	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public String getFederalIdentificationNumber() {
		return federalIdentificationNumber;
	}
	public void setFederalIdentificationNumber(String federalIdentificationNumber) {
		this.federalIdentificationNumber = federalIdentificationNumber;
	}
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
