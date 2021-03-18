package com.uniyaz.uı.page.urun;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.service.UrunService;
import com.uniyaz.uı.component.ContentComponent;
import com.uniyaz.uı.component.HbEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.math.BigDecimal;
import java.util.List;

public class UrunListePage extends VerticalLayout {
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;

    public UrunListePage() {
        setSizeFull();
        buildUrunListLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
        fillTable();
    }

    private void buildUrunListLayout() {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        buildTable();
        mainLayout.addComponent(table);
    }

    private void buildTable() {
        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "AD", "KOD", "FIYAT", "");
    }

    private void buildContainer() {
        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("ad", String.class, null);
        container.addContainerProperty("kod", String.class, null);
        container.addContainerProperty("fiyat", BigDecimal.class,null);
        container.addContainerProperty("guncelle", HbEditButton.class, null);
    }

    private void fillTable()
    {
        UrunService urunService = new UrunService();
        List<Urun> urunList = urunService.findAllHqlURUN();
        for (Urun urun : urunList)
        {
            Item item = container.addItem(urun);
            item.getItemProperty("id").setValue(urun.getId());
            item.getItemProperty("ad").setValue(urun.getAd());
            item.getItemProperty("kod").setValue(urun.getKod());
            item.getItemProperty("fiyat").setValue(urun.getFiyat());

            HbEditButton guncelle = new HbEditButton();
            guncelle.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    HbUI hbUI =(HbUI) HbUI.getCurrent();
                    ContentComponent contentComponent = hbUI.getContentComponent();

                    UrunPage urunPage = new UrunPage(urun);
                    contentComponent.addComponent(urunPage);
                }
            });
            item.getItemProperty("guncelle").setValue(guncelle);
        }
    }

}
