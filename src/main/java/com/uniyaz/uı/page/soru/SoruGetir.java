package com.uniyaz.uı.page.soru;

import com.uniyaz.HbUI;
import com.uniyaz.core.dao.SoruDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Kullanici;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.uı.component.AnketComboBox;
import com.uniyaz.uı.component.ContentComponent;
import com.uniyaz.uı.component.SoruComboBox;
import com.uniyaz.uı.page.cevap.CevapPage;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.UI;

import java.util.List;

public class SoruGetir extends FormLayout
{
    @PropertyId("soru")
    SoruComboBox soruComboBox;

    Button btnGiris;
    private Kullanici kullanici;

    private Soru soru;


    ContentComponent contentComponent = new ContentComponent();

    public SoruGetir(Anket anket)
    {
    }

    public SoruGetir()
    {
        HbUI hbUI = (HbUI) UI.getCurrent();
        this.contentComponent = hbUI.getContentComponent();

        buildLayout();
    }

    private void buildLayout() {
        soruComboBox = new SoruComboBox();
        soruComboBox.setCaption("Soru");
        addComponent(soruComboBox);
        soru = new Soru();

        soruCoz(soru);
    }

    private void soruCoz(final Soru soru)
    {
        btnGiris = new Button("Anketi Kaydet");
        btnGiris.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {
                HbUI syUI = (HbUI) HbUI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                CevapPage cevapPage = new CevapPage(soru);
                contentComponent.addComponent(cevapPage);
            }
        });
        addComponent(btnGiris);
    }

    private void fillPageByAnket(Anket anket) {
        SoruDao soruDao = new SoruDao();
        List<Soru> soruList = soruDao.findAllByanketId(anket.getId());
    }

}
