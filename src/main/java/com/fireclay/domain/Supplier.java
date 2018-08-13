/**
 * 
 */
package com.fireclay.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Franklin Chua
 *
 */
@Entity
public class Supplier extends Contact {

	private String salesman;
	private String salesmanNo;
	private String salesmanEmail;
	private String terms;
	private SupplierType supplierType;

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	public String getSalesmanNo() {
		return salesmanNo;
	}

	public void setSalesmanNo(String salesmanNo) {
		this.salesmanNo = salesmanNo;
	}

	public String getSalesmanEmail() {
		return salesmanEmail;
	}

	public void setSalesmanEmail(String salesmanEmail) {
		this.salesmanEmail = salesmanEmail;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	@ManyToOne
	public SupplierType getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(SupplierType supplierType) {
		this.supplierType = supplierType;
	}

}
