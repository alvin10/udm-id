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
import com.fireclay.domain.Customer;
import com.fireclay.service.CustomerService;
import com.fireclay.window.EditCustomerWindow;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.Align;
import com.vaadin.ui.TextField;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@UIScope
@SpringView(name = CustomersView.VIEW_NAME)
public class CustomersView extends FView<Customer, EditCustomerWindow> {

	public static final String VIEW_NAME = "customers";
	public static final String VIEW_TITLE = "Customers";

	private static Logger logger = LoggerFactory.getLogger(CustomersView.class);

	private HorizontalLayout layoutFilter;
	private TextField fieldSearch;
	private Button buttonSearch;
	private Button buttonNew;
	private Table tableResults;
	private Label labelSummary;

	@Autowired
	private CustomerService customerService;

	private BeanItemContainer<Customer> beans;

	private static Object[] COLUMNS = { "businessName", "purchaser", "purchaserNo", "accounting", "accountingNo",
			"creditLimit", "modifiedDate", "actions" };

	private static String[] HEADERS = { "Business Name", "Purchaser", "Telephone No.", "Accounting", "Telephone No.",
			"Credit Limit", "Last Modified", "Actions" };

	@PostConstruct
	public void init() {
		logger.info("init");
		setTitle(VIEW_TITLE);

		layoutFilter = new OptionsLayout();
		fieldSearch = new TextField("Name");
		buttonSearch = new SearchButton();
		buttonNew = new NewButton();

		layoutFilter.addComponents(fieldSearch, buttonSearch, buttonNew);

		beans = new BeanItemContainer<Customer>(Customer.class);
		tableResults = new FTable();
		tableResults.setContainerDataSource(beans);
		tableResults.addGeneratedColumn("actions", new SimpleColumnGenerator<Customer>(this));
		tableResults.setVisibleColumns(COLUMNS);
		tableResults.setColumnHeaders(HEADERS);
		tableResults.setColumnAlignment("creditLimit", Align.RIGHT);
		tableResults.setSortContainerPropertyId(COLUMNS[0]);

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
		onEdit(new Customer());
	}

	@Override
	public void onLoad() {
		beans.removeAllItems();
		beans.addAll(customerService.find(fieldSearch.getValue()));
		tableResults.sort();
		labelSummary.setValue("No. of records: " + beans.size());
	}

}
