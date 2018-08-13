/**
 * 
 */
package com.fireclay.component;

import com.vaadin.ui.PasswordField;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
public class FPasswordField extends PasswordField {

	public FPasswordField(String caption) {
		super(caption);
		setNullRepresentation("");
	}
}
