package com.uniyaz.uı.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class SearchComponent extends HorizontalLayout
{
    private HorizontalLayout mailLayout;
    private TextField txtSearch;
    private Button btnSearch;

    public SearchComponent()
    {
        setSizeFull();

        buildLayout();
        addComponent(mailLayout);

        setComponentAlignment(mailLayout, Alignment.MIDDLE_CENTER);
    }

    private void buildLayout()
    {
        mailLayout = new HorizontalLayout();

        txtSearch = new TextField();
        txtSearch.setInputPrompt("Ürünleri arayabilirsiniz");
        mailLayout.addComponent(txtSearch);

        btnSearch = new Button();
        btnSearch.setIcon(FontAwesome.SEARCH);
        mailLayout.addComponent(btnSearch);
    }
}
