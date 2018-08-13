/**
 * 
 */
package com.fireclay.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.fireclay.component.HeaderComponent;
import com.fireclay.window.EditWindow;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
public abstract class FView<T, E extends EditWindow<T>> extends VerticalLayout implements View, CloseListener, SimpleActionListener<T> {

	@Autowired
	private HeaderComponent componentHeader;

	private String title;
	
	@Autowired
	private E editWindow;
	
	@PostConstruct
	public void initView() {
		editWindow.addCloseListener(this); // this automatically sets up the close window listener
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		componentHeader.setTitle(getTitle());
		Page.getCurrent().setTitle(getTitle());
		onLoad();
	}

	@Override
	public void windowClose(CloseEvent e) {
		onLoad();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public abstract void onLoad();
	
	public void onEdit(T entity) {
		UI.getCurrent().addWindow(editWindow);
		editWindow.setEntity(entity);
		editWindow.center();
	}
	
	public void onDelete(T entity) {
		
	}

}
