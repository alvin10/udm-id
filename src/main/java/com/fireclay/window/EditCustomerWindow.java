/**
 * 
 */
package com.fireclay.window;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.fireclay.common.FErrorMessage;
import com.fireclay.component.FTextArea;
import com.fireclay.component.FTextField;
import com.fireclay.domain.Customer;
import com.fireclay.service.CustomerService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class EditCustomerWindow extends EditWindow<Customer> {

	@Autowired
	private CustomerService customerService;
	
	private TextField businessName;
	private TextArea businessAddress;
	private TextField tin;
	private TextField secDtiRegNo;
	private TextField telephoneNo;
	private TextField faxNo;
	private TextField email;
	private TextField purchaser;
	private TextField purchaserNo;
	private TextField accounting;
	private TextField accountingNo;
	private TextField creditLimit;
	
	private BeanFieldGroup<Customer> binder;
	
	@PostConstruct
	public void init() {
		setCaption("Customer Information");
		
		businessName = new FTextField("Business Name");
		businessAddress = new FTextArea("Business Address");
		tin = new FTextField("Tax Identification No.");
		secDtiRegNo = new FTextField("SEC/DTI Registration No.");
		telephoneNo = new FTextField("Telephone No.");
		faxNo = new FTextField("Fax No.");
		email = new FTextField("Email");
		purchaser = new FTextField("Purchaser");
		purchaserNo = new FTextField("Purchaser No.");
		accounting = new FTextField("Accounting");
		accountingNo = new FTextField("Accounting No.");
		creditLimit = new FTextField("Credit Limit");
		
		businessName.setRequired(true);

		binder = new BeanFieldGroup<Customer>(Customer.class);
		binder.bindMemberFields(this);
		
		addComponents(businessName, businessAddress, tin, secDtiRegNo, telephoneNo, faxNo, email, purchaser, purchaserNo, accounting, accountingNo, creditLimit);
	}
	
	public void onLoad(Customer customer) {
		binder.setItemDataSource(customer);
		setErrorMessage(null);
	}
	
	public void onSave() {
		try {
			binder.commit();
			customerService.save(getEntity());
			close();
		} catch (CommitException e) {
			setErrorMessage(FErrorMessage.INVALID_REQUIRED_FIELDS.getMessage());
		} catch (DataIntegrityViolationException e) {
			setErrorMessage(FErrorMessage.DUPLICATE_BUSINESS_NAME.getMessage());
		}
	}
}
