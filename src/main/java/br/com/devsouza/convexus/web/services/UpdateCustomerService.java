package br.com.devsouza.convexus.web.services;

import java.io.Serializable;
import java.util.UUID;

import br.com.devsouza.convexus.web.models.Customer;
import br.com.devsouza.convexus.web.repositories.CustomerRepository;
import br.com.devsouza.convexus.web.services.requests.UpdateCustomerRequestBody;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class UpdateCustomerService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject private CustomerRepository customerRepository;
	
	@Transactional
	public Customer perform(UUID customerId, UpdateCustomerRequestBody body) {
		// TODO: Validations
		
		Customer customer = customerRepository.findOneByCustomerId(customerId)
				.orElseThrow(() -> new IllegalArgumentException("Cliente não existe")); // TODO: Impl CustomException
		
		customer.setFederalIdentificationNumber(body.getFederalIdentificationNumber());
		customer.setFullname(body.getFullname());
		customer.setSocialName(body.getSocialName());
		customer.setStartDate(body.getStartDate());
		
		return customerRepository.update(customer);
	}
	
}