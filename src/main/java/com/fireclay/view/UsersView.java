/**
 * 
 */
package com.fireclay.view;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fireclay.component.FTable;
import com.fireclay.component.NewButton;
import com.fireclay.component.OptionsLayout;
import com.fireclay.component.SearchButton;
import com.fireclay.domain.UserAccount;
import com.fireclay.service.UserAccountService;
import com.fireclay.window.EditWindow;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@UIScope
@SpringView(name = UsersView.VIEW_NAME)
public class UsersView extends FView<UserAccount, EditWindow<UserAccount>> {
	
	public static final String VIEW_NAME = "users";
	public static final String VIEW_TITLE = "Users";
	
	private static Logger logger = LoggerFactory.getLogger(UsersView.class);
	
	private HorizontalLayout layoutFilter;
	private TextField fieldSearch;
	private Button buttonSearch;
	private Button buttonNew;	
	private Table tableResults;
	private Label labelSummary;
	
	@Autowired
	private UserAccountService userService;
	
	private BeanItemContainer<UserAccount> beans;
	
	@PostConstruct
	public void init() {
		logger.info("init");
		setTitle(VIEW_TITLE);
		layoutFilter = new OptionsLayout();
		
		fieldSearch = new TextField("Name");
		buttonSearch = new SearchButton();
		buttonNew = new NewButton();
		
		layoutFilter.addComponents(fieldSearch, buttonSearch, buttonNew);
		
		beans = new BeanItemContainer<UserAccount>(UserAccount.class);
		tableResults = new FTable();
		tableResults.setContainerDataSource(beans);
		tableResults.addGeneratedColumn("actions", new SimpleColumnGenerator<UserAccount>(this));
		tableResults.setVisibleColumns("name", "username", "active", "locked", "actions");
		tableResults.setColumnHeaders("Name", "Username", "Active", "Locked", "Actions");
		tableResults.setSortContainerPropertyId("name");
		
		labelSummary = new Label();
		
		setSizeFull();
		setSpacing(true);
		addComponent(layoutFilter);
		addComponent(tableResults);
		addComponent(labelSummary);
		setExpandRatio(tableResults, 1);
		
		buttonNew.addClickListener(e -> {
			onNew();
		});
		
		buttonSearch.addClickListener(e -> {
			onLoad();
		});
	}
	
	public void onNew() {
		onEdit(new UserAccount());
	}
	
	@Override
	public void onLoad() {
		beans.removeAllItems();
		beans.addAll(userService.find(fieldSearch.getValue()));
		tableResults.sort();
		labelSummary.setValue("No. of records: " + beans.size());
	}

}
