/**
 * 
 */
package com.fireclay.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
public class SearchButton extends Button {

	public SearchButton() {
		super("Search", FontAwesome.SEARCH);
	}
}
