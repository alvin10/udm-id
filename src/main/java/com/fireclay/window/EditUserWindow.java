/**
 * 
 */
package com.fireclay.window;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.fireclay.common.FErrorMessage;
import com.fireclay.component.FPasswordField;
import com.fireclay.component.FTextField;
import com.fireclay.domain.UserAccount;
import com.fireclay.service.UserAccountService;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class EditUserWindow extends EditWindow<UserAccount> {

	@Autowired
	private UserAccountService userService;
	
	private TextField username;
	private TextField name;
	private PasswordField password;
	private CheckBox active;
	private CheckBox locked;
	
	private BeanFieldGroup<UserAccount> binder;
	
	@PostConstruct
	public void init() {
		setCaption("User Information");
		
		username = new FTextField("Username");
		password = new FPasswordField("Password");
		name = new FTextField("Name");
		active = new CheckBox("Active");
		locked = new CheckBox("Locked");
		
		username.setRequired(true);
		name.setRequired(true);
		
		binder = new BeanFieldGroup<UserAccount>(UserAccount.class);
		binder.bindMemberFields(this);
		
		addComponents(username, password, name, active, locked);
	}
	
	public void onLoad(UserAccount userAccount) {
		binder.setItemDataSource(userAccount);
		setErrorMessage(null);
		password.setRequired(userAccount.getId() == 0); // make password field required for new records
		password.setValue(null);
	}
	
	public void onSave() {
		try {
			binder.commit();
			password.validate();
			userService.save(getEntity(), password.getValue());
			close();
		} catch (CommitException e) {
			setErrorMessage(FErrorMessage.INVALID_REQUIRED_FIELDS.getMessage());
		} catch (InvalidValueException e) {
			setErrorMessage(FErrorMessage.INVALID_PASSWORD.getMessage());
		} catch (DataIntegrityViolationException e) {
			setErrorMessage(FErrorMessage.DUPLICATE_USERNAME.getMessage());
		}
	}
}
