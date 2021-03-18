package com.uniyaz.uı.page.musteri;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.service.MusteriService;
import com.uniyaz.uı.component.ContentComponent;
import com.uniyaz.uı.component.HbEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class MusteriListePage extends VerticalLayout
{
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;

    public MusteriListePage()
    {
        setSizeFull();
        buildMusteriListLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable();
    }

    private void buildMusteriListLayout()
    {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        buildTable();
        mainLayout.addComponent(table);
    }

    private void buildTable()
    {
        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "AD", "");
    }

    private void buildContainer()
    {
        container = new IndexedContainer();
        container.addContainerProperty("id",Long.class,null);
        container.addContainerProperty("ad",String.class,null);
        container.addContainerProperty("guncelle", HbEditButton.class,null);
    }

    private void fillTable()
    {
        MusteriService musteriService = new MusteriService();
        List<Musteri> musteriList = musteriService.findAllHqlMusteri();
        for (Musteri musteri : musteriList)
        {
            Item item = container.addItem(musteri);
            item.getItemProperty("id").setValue(musteri.getId());
            item.getItemProperty("ad").setValue(musteri.getAd());

            HbEditButton guncelle = new HbEditButton();
            guncelle.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    HbUI hbUI = (HbUI) HbUI.getCurrent();
                    ContentComponent contentComponent = hbUI.getContentComponent();

                    MusteriPage musteriPage = new MusteriPage(musteri);
                    contentComponent.addComponent(musteriPage);
                }
            });
            item.getItemProperty("guncelle").setValue(guncelle);
        }
    }
}














