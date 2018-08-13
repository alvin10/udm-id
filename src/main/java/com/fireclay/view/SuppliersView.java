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
import com.fireclay.domain.Supplier;
import com.fireclay.service.SupplierService;
import com.fireclay.window.EditSupplierWindow;
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
@SpringView(name = SuppliersView.VIEW_NAME)
public class SuppliersView extends FView<Supplier, EditSupplierWindow> {
	
	public static final String VIEW_NAME = "suppliers";
	public static final String VIEW_TITLE = "Suppliers";
	
	private static Logger logger = LoggerFactory.getLogger(SuppliersView.class);
	
	private HorizontalLayout layoutFilter;
	private TextField fieldSearch;
	private Button buttonSearch;
	private Button buttonNew;	
	private Table tableResults;
	private Label labelSummary;
	
	@Autowired
	private EditSupplierWindow editWindow;

	@Autowired
	private SupplierService supplierService;
	
	private BeanItemContainer<Supplier> beans;
	
	private static Object[] COLUMNS = {
		"supplierType", "businessName", "salesman", "salesmanNo", "salesmanEmail", "terms", "modifiedDate", "actions"
	};
	
	private static String[] HEADERS = {
		"Type", "Name", "Salesman", "Tel. No.", "Email", "Terms", "Last Modified", "Actions"
	};
	
	@PostConstruct
	public void init() {
		logger.info("init");
		
		setTitle(VIEW_TITLE);
		layoutFilter = new OptionsLayout();
		
		fieldSearch = new TextField("Name");
		buttonSearch = new SearchButton();
		buttonNew = new NewButton();
		
		layoutFilter.addComponents(fieldSearch, buttonSearch, buttonNew);
		
		beans = new BeanItemContainer<Supplier>(Supplier.class);
		tableResults = new FTable();
		tableResults.setContainerDataSource(beans);
		tableResults.addGeneratedColumn("actions", new SimpleColumnGenerator<Supplier>(this));
		tableResults.setVisibleColumns(COLUMNS);
		tableResults.setColumnHeaders(HEADERS);
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
		
		editWindow.addCloseListener(this);
	}
	
	public void onNew() {
		onEdit(new Supplier());
	}
	
	@Override
	public void onLoad() {
		beans.removeAllItems();
		beans.addAll(supplierService.find(fieldSearch.getValue()));
		tableResults.sort();
		labelSummary.setValue("No. of records: " + beans.size());
	}

}
