package br.com.devsouza.convexus.web.services;

import java.io.Serializable;

import br.com.devsouza.convexus.web.models.Customer;
import br.com.devsouza.convexus.web.repositories.CustomerRepository;
import br.com.devsouza.convexus.web.services.requests.CreateCustomerRequestBody;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class CreateCustomerService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject private CustomerRepository customerRepository;
	
	@Transactional
	public Customer perform(CreateCustomerRequestBody body) {
		// TODO: Validations
		
		Customer customer = toCustomer(body);
		
		customerRepository.persist(customer);
		
		return customer;
	}
	
	private Customer toCustomer(CreateCustomerRequestBody body) {
		Customer customer = new Customer();
		customer.setFederalIdentificationNumber(body.getFederalIdentificationNumber());
		customer.setFullname(body.getFullname());
		customer.setSocialName(body.getSocialName());
		customer.setType(body.getType());
		customer.setStartDate(body.getStartDate());
		
		return customer;
	}

}