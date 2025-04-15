package br.com.devsouza.convexus.web.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.devsouza.convexus.web.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

public class CustomerRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	protected EntityManager em;

	public List<Customer> findAll() {
		return em.createQuery("SELECT c FROM Customer c", Customer.class)
				.getResultList();
	}

	public Optional<Customer> findOneByCustomerId(UUID customereId) {
		try {
			return Optional.of(em.createQuery("SELECT c FROM Customer c WHERE c.customerId = :customerId", Customer.class)
					.setParameter("customerId", customereId)
					.getSingleResult());		
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}
	
	public void persist(Customer customer) {
		em.persist(customer);
	}

	public void remove(Customer customer) {
		em.remove(customer);
	}

	public Customer update(Customer customer) {
		return em.merge(customer);
	}

}