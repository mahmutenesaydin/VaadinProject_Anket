package com.uniyaz;

import com.uniyaz.uı.component.ContentComponent;
import com.uniyaz.uı.component.HbMenuBar;
import com.uniyaz.uı.component.SearchComponent;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class HbUI extends UI {

    private VerticalLayout mainLayout;
    private ContentComponent contentComponent;

    @Override
    protected void init(VaadinRequest vaadinRequest)
    {
        buildMainLayout();
        setContent(mainLayout);
    }

    private void buildMainLayout()
    {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        contentComponent = new ContentComponent();

        SearchComponent searchComponent = new SearchComponent();
        mainLayout.addComponent(searchComponent);

       HbMenuBar hbMenuBar = new HbMenuBar();

        mainLayout.addComponent(hbMenuBar);
        mainLayout.addComponent(contentComponent);

        mainLayout.setExpandRatio(searchComponent, 0.8f);
        mainLayout.setExpandRatio(hbMenuBar, 0.6f);
        mainLayout.setExpandRatio(contentComponent, 8.6f);
    }

    public ContentComponent getContentComponent() {
        return contentComponent;
    }

    public void setContentComponent(ContentComponent contentComponent) {
        this.contentComponent = contentComponent;
    }
}
