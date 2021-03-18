package com.uniyaz.uı.page.soru;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.EnumSoruTuru;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.SoruService;
import com.uniyaz.uı.component.ContentComponent;
import com.uniyaz.uı.component.HbDeleteButton;
import com.uniyaz.uı.component.HbEditButton;
import com.uniyaz.uı.page.BasePage;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class SoruListPage extends BasePage
{
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;


    public SoruListPage() {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable();
    }

    @Override
    public void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        buildTable();
        mainLayout.addComponent(table);
    }

    private void buildTable() {

        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID","CEVAP", "SORU", "ANKET", "", "");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("ID", Long.class, null);
        container.addContainerProperty("CEVAP", EnumSoruTuru.class, null);
        container.addContainerProperty("SORU", String.class, null);
        container.addContainerProperty("ID_ANKET", Long.class, null);
        container.addContainerProperty("guncelle", HbEditButton.class, null);
        container.addContainerProperty("sil", HbDeleteButton.class, null);
    }

    private void fillTable()
    {
        SoruService soruService = new SoruService();
        List<Soru> soruList = soruService.findAllHql();
        container.removeAllItems();
        for (Soru soru : soruList)
        {
            Item item = container.addItem(soru);
            item.getItemProperty("ID").setValue(soru.getId());
            item.getItemProperty("CEVAP").setValue(soru.getEnumSecenek());
            item.getItemProperty("SORU").setValue(soru.getSoru());
            item.getItemProperty("ID_ANKET").setValue(soru.getAnket().getId());

            HbEditButton guncelle = buildUpdateButton(soru);
            item.getItemProperty("guncelle").setValue(guncelle);

            HbDeleteButton sil = buildDeleteButton(soru);
            item.getItemProperty("sil").setValue(sil);
      }
  }

    private HbEditButton buildUpdateButton(final Soru soru)
    {
        HbEditButton guncelle = new HbEditButton();
        guncelle.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {
                HbUI syUI = (HbUI) HbUI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                SoruPage soruPage = new SoruPage(soru);
                contentComponent.addComponent(soruPage);
            }
        });
        return guncelle;
    }


    private HbDeleteButton buildDeleteButton(final Soru soru)
    {
        HbDeleteButton sil = new HbDeleteButton();
        sil.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SoruService soruService = new SoruService();
                soruService.deleteSoru(soru);
                fillTable();
            }
        });
        return sil;
    }
}
