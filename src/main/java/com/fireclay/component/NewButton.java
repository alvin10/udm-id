/**
 * 
 */
package com.fireclay.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
public class NewButton extends Button {

	public NewButton() {
		super("New", FontAwesome.PLUS);
		addStyleName(ValoTheme.BUTTON_PRIMARY);
	}
}
