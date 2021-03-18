package com.uniyaz.uı.component;

import com.uniyaz.core.domain.EnumSoruTuru;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

import java.util.List;

public class SecenekComboBox extends ComboBox
{
    private EnumSoruTuru enumSoruTuru;
    private FormLayout mainLayout;

    public SecenekComboBox()
    {
        mainLayout = new FormLayout();

        fillCombobox();
    }

    private void fillCombobox()
    {
        for (EnumSoruTuru soruTuru : EnumSoruTuru.values())
        {
            Item item = addItem(soruTuru);
//
//            switch (soruTuru)
//            {
//                case YaziMetni:
//                    TextField yaziMetni = new TextField();
//                    mainLayout.addComponent(yaziMetni);
//                    break;
//                case CoktanSecmeli:
//                    ComboBox coktanSecmeli = new ComboBox();
//                    mainLayout.addComponent(coktanSecmeli);
//            }
        }
//
//        switch (enumSoruTuru)
//        {
//            case YaziMetni:
//                TextField yaziMetni = new TextField();
//                mainLayout.addComponent(yaziMetni);
//                break;
//            case CoktanSecmeli:
//                ComboBox coktanSecmeli = new ComboBox();
//                mainLayout.addComponent(coktanSecmeli);
//        }
    }
}
