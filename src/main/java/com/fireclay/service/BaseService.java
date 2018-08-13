/**
 * 
 */
package com.fireclay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Franklin Chua
 *
 */
public class BaseService<T, R extends JpaRepository<T, Long>> {

	@Autowired
	private R repo;
	
	public List<T> findAll() {
		return repo.findAll();
	}
	
	public T save(T entity) {
		return repo.save(entity);
	}
	
	public R getRepository() {
		return repo;
	}
}
