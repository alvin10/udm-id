/**
 * 
 */
package com.fireclay.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fireclay.domain.Supplier;
import com.fireclay.repository.SupplierRepository;

/**
 * @author Franklin Chua
 *
 */
@Service
public class SupplierService extends BaseService<Supplier, SupplierRepository> {

	public List<Supplier> find(String name) {
		return getRepository().findByBusinessNameContaining(name);
	}

}
