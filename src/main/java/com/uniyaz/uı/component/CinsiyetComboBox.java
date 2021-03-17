package com.uniyaz.uı.component;

import com.uniyaz.core.domain.EnumCinsiyet;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;

public class CinsiyetComboBox extends ComboBox
{
    public CinsiyetComboBox()
    {
        fillComboBox();
    }

    private void fillComboBox()
    {
        for (EnumCinsiyet cinsiyet : EnumCinsiyet.values())
        {
            Item item = addItem(cinsiyet);
        }
    }
}
