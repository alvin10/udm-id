/**
 * 
 */
package com.fireclay.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Franklin Chua
 *
 */
@MappedSuperclass
public class Contact extends BaseEntity {

	private String businessName;
	private String businessAddress;
	private String tin;
	private String secDtiRegNo;
	private String telephoneNo;
	private String faxNo;
	private String email;

	@Column(unique = true, nullable = false)
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(length = 1024)
	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getSecDtiRegNo() {
		return secDtiRegNo;
	}

	public void setSecDtiRegNo(String secDtiRegNo) {
		this.secDtiRegNo = secDtiRegNo;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
