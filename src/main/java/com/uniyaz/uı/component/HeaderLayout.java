package com.uniyaz.uı.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

public class HeaderLayout extends HorizontalLayout
{
    private HorizontalLayout mailLayout;
    private Label label;
    private Button btnSearch;

    public HeaderLayout()
    {
        setSizeFull();

        buildLayout();
        addComponent(mailLayout);

        setComponentAlignment(mailLayout, Alignment.MIDDLE_CENTER);
    }

    private void buildLayout()
    {
        mailLayout = new HorizontalLayout();

        label = new Label();
        label.setCaption("ANKETİMİZE HOŞGELDİNİZ");
        mailLayout.addComponent(label);

    }
}
