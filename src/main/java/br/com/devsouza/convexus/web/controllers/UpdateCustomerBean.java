package br.com.devsouza.convexus.web.controllers;

import java.io.Serializable;
import java.util.UUID;

import br.com.devsouza.convexus.web.models.Customer;
import br.com.devsouza.convexus.web.repositories.CustomerRepository;
import br.com.devsouza.convexus.web.services.UpdateCustomerService;
import br.com.devsouza.convexus.web.services.requests.UpdateCustomerRequestBody;
import br.com.devsouza.convexus.web.utils.FacesUtils;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class UpdateCustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject private CustomerRepository customerRepository;
	@Inject private UpdateCustomerService updateCustomer;
	
	private Customer customer;
	private UpdateCustomerRequestBody editCustomer;
	
	@PostConstruct
	public void init() {
		UUID customerId = UUID.fromString(FacesUtils.getParameter("customerId"));
		open(customerId);
	}
	
	public void open(UUID customerId) {
		this.customer = customerRepository.findOneByCustomerId(customerId)
				.orElse(null);
		
		if(customer != null) {
			this.editCustomer = new UpdateCustomerRequestBody(customer);
		}
		
	}
	
	public void update() {
		try {
			updateCustomer.perform(customer.getCustomerId(), editCustomer);
			FacesUtils.addInfoMessage("Cliente atualizado com sucesso!");
			
			open(customer.getCustomerId());
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage("Não foi possível salvar o cliente no momento.");
			e.printStackTrace();
		}
	}
	
	public UpdateCustomerRequestBody getEditCustomer() {
		return editCustomer;
	}
	
}
