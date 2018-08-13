/**
 * 
 */
package com.fireclay.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fireclay.domain.Customer;
import com.fireclay.repository.CustomerRepository;

/**
 * @author Franklin Chua
 *
 */
@Service
public class CustomerService extends BaseService<Customer, CustomerRepository> {

	public List<Customer> find(String name) {
		return getRepository().findByBusinessNameContaining(name);
	}

}
