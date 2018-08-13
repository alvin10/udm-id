/**
 * 
 */
package com.fireclay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Franklin Chua
 *
 */
@Entity
public class Billing extends BaseEntity {

	private Customer customer;
	private Date billingDate;
	private Date dueDate;
	private List<BillingItem> billingItems = new ArrayList<BillingItem>();
	private String status = "Pending";
	private double amountDue;
	private double amountPaid;

	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Temporal(TemporalType.DATE)
	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@OneToMany(mappedBy = "billing")
	public List<BillingItem> getBillingItems() {
		return billingItems;
	}

	public void setBillingItems(List<BillingItem> billingItems) {
		this.billingItems = billingItems;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

}
