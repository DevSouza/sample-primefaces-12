package br.com.devsouza.convexus.web.controllers;

import java.io.Serializable;

import br.com.devsouza.convexus.web.services.CreateCustomerService;
import br.com.devsouza.convexus.web.services.requests.CreateCustomerRequestBody;
import br.com.devsouza.convexus.web.utils.FacesUtils;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CreateCustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject private CreateCustomerService createCustomer;
	
	private CreateCustomerRequestBody newCustomer;
	
	@PostConstruct
	public void initializer() {
		this.newCustomer = new CreateCustomerRequestBody();
	}
	
	public void create() {
		try {
			createCustomer.perform(newCustomer);
			FacesUtils.addInfoMessage("Cliente criado com sucesso!");
			
			this.newCustomer = new CreateCustomerRequestBody();
			FacesUtils.addInfoMessage("Cliente criado com sucesso!");
		} catch (Exception e) {
			FacesUtils.addErrorMessage("Não foi possível salvar o cliente no momento.");
			e.printStackTrace();
		}
	}
	
	public CreateCustomerRequestBody getNewCustomer() {
		return newCustomer;
	}
	
	
}
