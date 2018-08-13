/**
 * 
 */
package com.fireclay.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Franklin Chua
 *
 */
@Entity
public class SupplierType extends BaseEntity implements Comparable<SupplierType> {

	private String name;

	@Column(unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(SupplierType entity) {
		return name.compareTo(entity.name);
	}
		
}
