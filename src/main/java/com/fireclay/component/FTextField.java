/**
 * 
 */
package com.fireclay.component;

import com.vaadin.ui.TextField;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
public class FTextField extends TextField {

	public FTextField(String caption) {
		super(caption);
		setNullRepresentation("");
	}
}
