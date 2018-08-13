/**
 * 
 */
package com.fireclay.window;

import com.fireclay.component.SaveButton;
import com.fireclay.component.SaveListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
public abstract class EditWindow<T> extends Window implements SaveListener {

	private VerticalLayout layoutRoot;
	private FormLayout layoutForm;
	private Label labelMessage;
	private Button buttonSave;
	private T entity;
	
	public EditWindow() {
		layoutRoot = new VerticalLayout();
		layoutForm = new FormLayout();
		labelMessage = new Label();
		buttonSave = new SaveButton(this);
		
		layoutForm.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		layoutRoot.setMargin(true);
		layoutRoot.setSpacing(true);
		layoutRoot.addComponent(layoutForm);
		layoutRoot.addComponent(labelMessage);
		layoutRoot.addComponent(buttonSave);
		
		labelMessage.addStyleName(ValoTheme.LABEL_FAILURE);
		labelMessage.setVisible(false);
		
		setContent(layoutRoot);
		setWidth("800px");
		setModal(true);
	}
	
	public void addComponent(Component c) {
		layoutForm.addComponent(c);
	}
	
	public void addComponents(Component... c) {
		layoutForm.addComponents(c);
	}
	
	public void setErrorMessage(String message) {
		labelMessage.setValue(message);
		labelMessage.setVisible(message != null);
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
		onLoad(entity);
	}
	
	public abstract void onLoad(T entity);

}
