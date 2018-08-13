/**
 * 
 */
package com.fireclay.view;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {

	public static final String VIEW_NAME = "";

	@PostConstruct
	public void init() {
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Page.getCurrent().setTitle("Default");
	}

}
