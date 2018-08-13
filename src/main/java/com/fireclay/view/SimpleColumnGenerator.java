/**
 * 
 */
package com.fireclay.view;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
public class SimpleColumnGenerator<T> implements ColumnGenerator {

	private SimpleActionListener<T> listener;

	public SimpleColumnGenerator(SimpleActionListener<T> listener) {
		this.listener = listener;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object generateCell(Table source, Object itemId, Object columnId) {
		CssLayout layoutActions = new CssLayout();
		Button buttonEdit = new Button("Edit", FontAwesome.EDIT);
		Button buttonDelete = new Button("Delete", FontAwesome.TRASH);
		layoutActions.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		layoutActions.addComponents(buttonEdit, buttonDelete);
		buttonEdit.addStyleName(ValoTheme.BUTTON_SMALL);
		buttonDelete.addStyleName(ValoTheme.BUTTON_SMALL + " " + ValoTheme.BUTTON_DANGER);

		buttonEdit.addClickListener(e -> {
			listener.onEdit((T) itemId);
		});

		buttonDelete.addClickListener(e -> {
			listener.onDelete((T) itemId);
		});

		return layoutActions;
	}

}
