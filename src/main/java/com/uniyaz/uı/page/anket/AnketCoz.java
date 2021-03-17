package com.uniyaz.uı.page.anket;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.uı.component.AnketComboBox;
import com.uniyaz.uı.component.ContentComponent;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class AnketCoz extends FormLayout {

    @PropertyId("ID_ANKET")
    AnketComboBox anketComboBox;

    Button btnGiris;


    ContentComponent contentComponent = new ContentComponent();

    public AnketCoz(Anket anket) {


    }

    public AnketCoz()
    {
        HbUI hbUI = (HbUI) UI.getCurrent();
        this.contentComponent = hbUI.getContentComponent();

        buildLayout();
    }

    private void buildLayout() {
        anketComboBox = new AnketComboBox();
        anketComboBox.setCaption("Lütfen Bir Anket Seçiniz");
        addComponent(anketComboBox);

        btnGiris = new Button("Anketi Çözmeye Başla");
        btnGiris.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {

            }
        });
        addComponent(btnGiris);
    }
}
