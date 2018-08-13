/**
 * 
 */
package com.fireclay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fireclay.domain.Supplier;

/**
 * @author Franklin Chua
 *
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	List<Supplier> findByBusinessNameContaining(String name);

}
