/**
 * 
 */
package com.fireclay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fireclay.domain.Customer;

/**
 * @author Franklin Chua
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByBusinessNameContaining(String name);

}
