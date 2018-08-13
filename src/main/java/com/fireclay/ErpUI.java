/**
 * 
 */
package com.fireclay;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@Theme("default")
@SpringUI
public class ErpUI extends UI {

	@Autowired
	private MainLayout layoutMain;
	
	@Override
	protected void init(VaadinRequest request) {
		setContent(layoutMain);
	}

}
