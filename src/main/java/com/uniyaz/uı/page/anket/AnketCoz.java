package com.uniyaz.uı.page.anket;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Kullanici;
import com.uniyaz.uı.component.AnketComboBox;
import com.uniyaz.uı.component.ContentComponent;
import com.uniyaz.uı.page.cevap.CevapPage;
import com.uniyaz.uı.page.soru.SoruGetir;
import com.uniyaz.uı.page.soru.SoruPage;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class AnketCoz extends FormLayout {

    @PropertyId("anket")
    AnketComboBox anketComboBox;

    Button btnGiris;
    private Kullanici kullanici;
    private Anket anket;

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


        anketCoz(anket);
    }

    private void anketCoz(final Anket anket)
    {
        btnGiris = new Button("Anketi Çözmeye Başla");
        btnGiris.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {
                HbUI syUI = (HbUI) HbUI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                SoruGetir soruGetir = new SoruGetir();
                contentComponent.addComponent(soruGetir);

//                CevapPage cevapPage = new CevapPage(kullanici);
//                contentComponent.addComponent(cevapPage);
            }
        });
        addComponent(btnGiris);
    }

}
