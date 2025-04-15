package br.com.devsouza.convexus.web.services.requests;

import java.time.LocalDate;

import br.com.devsouza.convexus.web.models.Customer;
import br.com.devsouza.convexus.web.models.CustomerType;

public class UpdateCustomerRequestBody {

	private CustomerType type;
	private String fullname;
	private String socialName;
	private LocalDate startDate; // data de criacao da empresa || Aniversario do cliente
	private String federalIdentificationNumber;
	
	public UpdateCustomerRequestBody(Customer customer) {
		this.type = customer.getType();
		this.fullname = customer.getFullname();
		this.socialName = customer.getSocialName();
		this.startDate = customer.getStartDate();
		this.federalIdentificationNumber = customer.getFederalIdentificationNumber();
	}
	public CustomerType getType() {
		return type;
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
