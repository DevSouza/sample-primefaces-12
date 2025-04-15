package br.com.devsouza.convexus.web.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.devsouza.convexus.web.models.Customer;
import br.com.devsouza.convexus.web.repositories.CustomerRepository;
import br.com.devsouza.convexus.web.services.RemoveCustomerService;
import br.com.devsouza.convexus.web.utils.FacesUtils;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class RetrivingCustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject private CustomerRepository customerRepository;
	@Inject private RemoveCustomerService removeCustomerService;
	
	private List<Customer> customers = new ArrayList<>();
	
	@PostConstruct
	public void initializer() {
		pesquisarClientes();
	}

	private void pesquisarClientes() {
		this.customers = customerRepository.findAll();
	}
	
	public void remove(UUID customerId) {
		try {
			removeCustomerService.perform(customerId);
			
			pesquisarClientes();
			
			FacesUtils.addInfoMessage("Cliente removido com sucesso.");
		} catch (Exception e) {
			FacesUtils.addErrorMessage("Não foi possível remover o cliente no momento.");
			e.printStackTrace();
		}
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
}
