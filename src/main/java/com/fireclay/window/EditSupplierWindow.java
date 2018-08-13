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
import com.fireclay.domain.Supplier;
import com.fireclay.domain.SupplierType;
import com.fireclay.service.SupplierService;
import com.fireclay.service.SupplierTypeService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class EditSupplierWindow extends EditWindow<Supplier> {

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private SupplierTypeService supplierTypeService;
	
	private ComboBox supplierType;
	private TextField businessName;
	private TextArea businessAddress;
	private TextField tin;
	private TextField secDtiRegNo;
	private TextField telephoneNo;
	private TextField faxNo;
	private TextField email;
	private TextField salesman;
	private TextField salesmanNo;
	private TextField salesmanEmail;
	private TextField terms;
	
	private BeanFieldGroup<Supplier> binder;
	
	@PostConstruct
	public void init() {
		setCaption("Supplier Information");
		
		supplierType = new ComboBox("Type");
		businessName = new FTextField("Business Name");
		businessAddress = new FTextArea("Business Address");
		tin = new FTextField("Tax Identification No.");
		secDtiRegNo = new FTextField("SEC/DTI Registration No.");
		telephoneNo = new FTextField("Telephone No.");
		faxNo = new FTextField("Fax No.");
		email = new FTextField("Email");
		salesman = new FTextField("Salesman");
		salesmanNo = new FTextField("Salesman No.");
		salesmanEmail = new FTextField("Salesman Email");
		terms = new FTextField("Terms");
		
		businessName.setRequired(true);

		binder = new BeanFieldGroup<Supplier>(Supplier.class);
		binder.bindMemberFields(this);
		
		addComponents(supplierType, businessName, businessAddress, tin, secDtiRegNo, telephoneNo, faxNo, email, salesman, salesmanNo, salesmanEmail, terms);
	}
	
	public void onLoad(Supplier supplier) {
		BeanItemContainer<SupplierType> beans = new BeanItemContainer<SupplierType>(SupplierType.class, supplierTypeService.findAll());
		beans.sort(new Object[] { "name" }, new boolean[] { true });
		supplierType.setContainerDataSource(beans);
		binder.setItemDataSource(supplier);
		setErrorMessage(null);
	}
	
	public void onSave() {
		try {
			binder.commit();
			supplierService.save(getEntity());
			close();
		} catch (CommitException e) {
			setErrorMessage(FErrorMessage.INVALID_REQUIRED_FIELDS.getMessage());
		} catch (DataIntegrityViolationException e) {
			setErrorMessage(FErrorMessage.DUPLICATE_BUSINESS_NAME.getMessage());
		}
	}
}
