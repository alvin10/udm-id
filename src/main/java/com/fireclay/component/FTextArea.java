/**
 * 
 */
package com.fireclay.component;

import com.vaadin.ui.TextArea;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
public class FTextArea extends TextArea {

	public FTextArea(String caption) {
		super(caption);
		setNullRepresentation("");
	}
}
