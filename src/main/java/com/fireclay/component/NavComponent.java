/**
 * 
 */
package com.fireclay.component;

import java.io.File;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.vaadin.server.FileResource;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class NavComponent extends CssLayout {
	
	private static Logger logger = LoggerFactory.getLogger(NavComponent.class);

	private CssLayout layoutMenuContent;
	
	private CssLayout layoutMenuItems;
	
	@Autowired
	private Environment environment;
	
	@PostConstruct
	public void init() {
		setPrimaryStyleName(ValoTheme.MENU_ROOT);
		
		layoutMenuContent = new CssLayout();
		layoutMenuContent.addStyleName(ValoTheme.MENU_PART);
		
		layoutMenuItems = new CssLayout();
		layoutMenuItems.addStyleName("valo-menuitems");
		
		FileResource resource = new FileResource(new File(environment.getProperty("logo.path")));
		Image image = new Image(null, resource);
		image.setWidth("100%");
		
		Label labelTitle = new Label("Fireclay Corporation");
		labelTitle.addStyleName(ValoTheme.MENU_TITLE);
		
		CssLayout layoutLogo = new CssLayout();
		layoutLogo.addStyleName(ValoTheme.MENU_PART);
		
		addComponent(layoutMenuContent);
		
		layoutMenuContent.addComponent(image);
		layoutMenuContent.addComponent(layoutMenuItems);
		
		addMenuItem("Home", null);
		addMenuGroup("Database");
		addMenuItem("Customers", "customers");
		addMenuItem("Suppliers", "suppliers");
		addMenuItem("Product Details - MC", null);
		addMenuItem("Product Details - PPE", null);
		addMenuItem("Product Details - Services", null);
		addMenuItem("PPE", null);
		addMenuItem("TPC Agent", null);
		addMenuItem("Board of Directors", null);
		addMenuItem("Company Quota", null);
		
		addMenuGroup("Contracts");
		
		addMenuGroup("Supply");
		addMenuItem("Price List", null);
		addMenuItem("Supply Estimates", null);
		addMenuItem("Prepare Invoice", null);
		addMenuItem("Sales History", null);
		
		addMenuItem("Warehouse", null);
		addMenuItem("Employees", null);
		addMenuItem("Purchasing", null);
		addMenuItem("Finance", null);
		addMenuItem("Reports", null);
		
		addMenuGroup("System");
		addMenuItem("Users", "users");
	}
	
	private void addMenuGroup(String caption) {
		Button buttonMenu = new Button(caption);
		buttonMenu.setPrimaryStyleName(ValoTheme.MENU_SUBTITLE);
		layoutMenuItems.addComponent(buttonMenu);
	}
	
	private void addMenuItem(String caption, String view) {
		Button buttonMenu = new Button(caption);
		buttonMenu.setPrimaryStyleName(ValoTheme.MENU_ITEM);
		layoutMenuItems.addComponent(buttonMenu);
		buttonMenu.addClickListener(e -> {
			logger.info("Menu item clicked");
			if (view != null) {
				UI.getCurrent().getNavigator().navigateTo(view);
			}
		});
	}
}
