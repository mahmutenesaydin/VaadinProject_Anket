package com.uniyaz.uı.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class HbDeleteButton extends Button
{
    public HbDeleteButton()
    {
        setIcon(FontAwesome.SAVE);
        addStyleName(ValoTheme.BUTTON_DANGER);
    }
}
