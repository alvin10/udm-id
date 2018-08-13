/**
 * 
 */
package com.fireclay;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.fireclay.component.FooterComponent;
import com.fireclay.component.HeaderComponent;
import com.fireclay.component.NavComponent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Franklin Chua
 *
 */
@SuppressWarnings("serial")
@SpringViewDisplay
@UIScope
public class MainLayout extends HorizontalLayout implements ViewDisplay {

	@Autowired
	private NavComponent componentNav;
	
	@Autowired
	private HeaderComponent componentHeader;
	
	@Autowired
	private FooterComponent componentFooter;
	
	private Panel panelContent;	
	private VerticalLayout layoutContent;
	
	private Panel panelView;
	
	@PostConstruct
	public void init() {
		panelView = new Panel();
		panelView.setSizeFull();
		panelView.addStyleName(ValoTheme.PANEL_BORDERLESS);
		
		panelContent = new Panel();
		panelContent.setSizeFull();
		panelContent.addStyleName(ValoTheme.PANEL_BORDERLESS);

		layoutContent = new VerticalLayout();
		layoutContent.setSizeFull();
		layoutContent.setMargin(true);
		layoutContent.setSpacing(true);
		
		panelContent.setContent(layoutContent);		
		
		addComponent(componentNav);
		addComponent(panelContent);
		setExpandRatio(panelContent, 1);
		
		layoutContent.addComponent(componentHeader);
		layoutContent.addComponent(panelView);
		layoutContent.setExpandRatio(panelView, 1);
		layoutContent.addComponent(componentFooter);
		
		setSizeFull();
	}

	@Override
	public void showView(View view) {
		panelView.setContent((Component) view);
	}
}
