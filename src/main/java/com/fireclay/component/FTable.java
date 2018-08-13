/**
 * 
 */
package com.fireclay.component;

import com.vaadin.data.Property;
import com.vaadin.ui.Table;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
public class FTable extends Table {

	public FTable() {
		setSizeFull();
	}

	@Override
	protected String formatPropertyValue(Object rowId, Object colId, Property<?> property) {
		if (property.getValue() != null) {
			if (property.getType() == Boolean.class) {
				boolean value = (Boolean) property.getValue();
				return value ? "Yes" : "No";
			}
		}
		return super.formatPropertyValue(rowId, colId, property);
	}
}
