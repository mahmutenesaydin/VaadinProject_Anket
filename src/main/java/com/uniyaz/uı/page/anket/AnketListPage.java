package com.uniyaz.uı.page.anket;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.AnketService;
import com.uniyaz.uı.component.ContentComponent;
import com.uniyaz.uı.component.HbDeleteButton;
import com.uniyaz.uı.component.HbEditButton;
import com.uniyaz.uı.component.HbSaveButton;
import com.uniyaz.uı.page.BasePage;
import com.uniyaz.uı.page.soru.SoruListPage;
import com.uniyaz.uı.page.soru.SoruPage;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.*;

import java.util.List;

public class AnketListPage extends BasePage
{
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    private Soru soru;

    public AnketListPage() {

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
        table.setColumnHeaders("ID", "ANKET", "", "", "");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("ID", Long.class, null);
        container.addContainerProperty("ANKET_ADI", String.class, null);
        container.addContainerProperty("guncelle", HbEditButton.class, null);
        container.addContainerProperty("sil", HbDeleteButton.class, null);
        container.addContainerProperty("yeniSoru", Button.class, null);
    }

    private void fillTable() {

        AnketService anketService = new AnketService();
        List<Anket> anketList = anketService.findAllHql();
        container.removeAllItems();
        for (Anket anket : anketList) {
            Item item = container.addItem(anket);
            item.getItemProperty("ID").setValue(anket.getId());
            item.getItemProperty("ANKET_ADI").setValue(anket.getAd());

            HbEditButton guncelle = buildUpdateButton(anket);
            item.getItemProperty("guncelle").setValue(guncelle);

            HbDeleteButton sil = buildDeleteButton(anket);
            item.getItemProperty("sil").setValue(sil);

            HbSaveButton yeniSoru = buildyeniSoruButton(anket);
            item.getItemProperty("yeniSoru").setValue(yeniSoru);
        }
    }

    private HbSaveButton buildyeniSoruButton(final Anket anket)
    {
        HbSaveButton yeniSoru = new HbSaveButton();
        yeniSoru.setCaption("Soru Ekle");
        yeniSoru.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

//               HbUI syUI = (HbUI) HbUI.getCurrent();
//                 ContentComponent contentComponent = syUI.getContentComponent();
//
//                SoruPage soruPage = new SoruPage(anket);
//                contentComponent.addComponent(soruPage);

                soru = new Soru();
                SoruPage soruPage = new SoruPage(anket);
                Window window = new Window();
                window.setCaption("Yeni Soru Ekle");
                window.setClosable(true);
                window.setWindowMode(WindowMode.NORMAL);
                window.setWidth(50, Unit.PERCENTAGE);
                window.setHeight(50, Unit.PERCENTAGE);
                window.setResizable(true);
                window.center();
                window.setContent(soruPage);

                HbUI hbUI = (HbUI) HbUI.getCurrent();
                hbUI.addWindow(window);

//                SoruPage soruPage = new SoruPage(anket);
//                contentComponent.addComponent(soruPage);
            }
        });
        return yeniSoru;
    }

    private HbEditButton buildUpdateButton(final Anket anket)
    {
        HbEditButton guncelle = new HbEditButton();
        guncelle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                HbUI syUI = (HbUI) HbUI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                AnketPage anketPage = new AnketPage(anket);
                contentComponent.addComponent(anketPage);
            }
        });
        return guncelle;
    }


    private HbDeleteButton buildDeleteButton(final Anket anket)
    {
        HbDeleteButton sil = new HbDeleteButton();
        sil.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AnketService anketService = new AnketService();
                anketService.deleteAnket(anket);
                fillTable();
            }
        });
        return sil;
    }
}
