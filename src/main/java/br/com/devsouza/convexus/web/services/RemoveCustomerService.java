package br.com.devsouza.convexus.web.services;

import java.io.Serializable;
import java.util.UUID;

import br.com.devsouza.convexus.web.models.Customer;
import br.com.devsouza.convexus.web.repositories.CustomerRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class RemoveCustomerService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject private CustomerRepository customerRepository;
	
	@Transactional
	public Customer perform(UUID customerId) {
		Customer customer = customerRepository.findOneByCustomerId(customerId)
				.orElseThrow(() -> new IllegalArgumentException("Não foi possivel encontrar o cliente.")); // TODO: Impl CustomException
		
		customerRepository.remove(customer);
		
		return customer;
	}

}