package com.uniyaz.uı.page;

import com.vaadin.ui.VerticalLayout;

public abstract class BasePage extends VerticalLayout
{
    public BasePage()
    {
        setSizeFull();
        buildMainLayout();
    }

    public abstract void buildMainLayout();
}
