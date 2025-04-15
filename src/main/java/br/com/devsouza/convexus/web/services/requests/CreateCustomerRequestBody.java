package br.com.devsouza.convexus.web.services.requests;

import java.time.LocalDate;

import br.com.devsouza.convexus.web.models.CustomerType;

public class CreateCustomerRequestBody {

	
	private CustomerType type;
	private String fullname;
	private String socialName;
	private LocalDate startDate; // data de criacao da empresa || Aniversario do cliente
	private String federalIdentificationNumber;
	
	public CreateCustomerRequestBody() {
		this.type = CustomerType.NATURAL_PERSON;
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
}
