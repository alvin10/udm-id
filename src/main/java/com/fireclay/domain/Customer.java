/**
 * 
 */
package com.fireclay.domain;

import javax.persistence.Entity;

/**
 * @author Franklin Chua
 *
 */
@Entity
public class Customer extends Contact {

	private String purchaser;
	private String purchaserNo;
	private String accounting;
	private String accountingNo;
	private double creditLimit;

	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public String getPurchaserNo() {
		return purchaserNo;
	}

	public void setPurchaserNo(String purchaserNo) {
		this.purchaserNo = purchaserNo;
	}

	public String getAccounting() {
		return accounting;
	}

	public void setAccounting(String accounting) {
		this.accounting = accounting;
	}

	public String getAccountingNo() {
		return accountingNo;
	}

	public void setAccountingNo(String accountingNo) {
		this.accountingNo = accountingNo;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

}
