/**
 * 
 */
package com.fireclay.component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class HeaderComponent extends HorizontalLayout implements Command {
	
	private static Logger logger = LoggerFactory.getLogger(HeaderComponent.class);
	
	private Button buttonAddTodo;
	private Button buttonBackup;
	private Button buttonDailyLogs;
	private MenuBar menuAccount;
	private MenuItem menuUser;
	private Label labelTitle;
	
	@PostConstruct
	public void init() {
		labelTitle = new Label("Title");
		buttonAddTodo = new Button("Add Todo");
		buttonBackup = new Button("Backup");
		buttonDailyLogs = new Button("Daily Logs");
		menuAccount = new MenuBar();
		menuUser = menuAccount.addItem("fchua@fireclaycorp.com", null);
		menuUser.addItem("Change Password", FontAwesome.LOCK, this);
		menuUser.addItem("Logout", FontAwesome.SIGN_OUT, this);
		
		setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		addComponents(labelTitle, buttonAddTodo, buttonBackup, buttonDailyLogs, menuAccount);
		setExpandRatio(labelTitle, 1);
		setWidth("100%");
		setSpacing(true);
		
		labelTitle.addStyleName(ValoTheme.LABEL_HUGE + " " + ValoTheme.LABEL_BOLD);
	}

	@Override
	public void menuSelected(MenuItem selectedItem) {
		logger.info("menuSelected: " + selectedItem.getText());
	}
	
	public void setTitle(String title) {
		labelTitle.setValue(title);
	}
}
