/**
 * 
 */
package com.fireclay.component;

import javax.annotation.PostConstruct;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class FooterComponent extends HorizontalLayout {
	
	@PostConstruct
	public void init() {
		setWidth("100%");
		addComponent(new Label("Enterprise Resource Planning 4.0.0"));
	}
	
}
