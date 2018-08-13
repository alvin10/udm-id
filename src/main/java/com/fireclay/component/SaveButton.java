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
public class SaveButton extends Button {

	public SaveButton(SaveListener listener) {
		super("Save", FontAwesome.SAVE);
		addStyleName(ValoTheme.BUTTON_PRIMARY);
		
		addClickListener(e -> {
			if (listener != null) {
				listener.onSave();
			}
		});
	}
}
