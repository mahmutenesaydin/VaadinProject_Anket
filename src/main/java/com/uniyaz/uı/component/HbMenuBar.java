package com.uniyaz.uı.component;

import com.uniyaz.HbUI;
import com.uniyaz.uı.page.musteri.MusteriListePage;
import com.uniyaz.uı.page.musteri.MusteriPage;
import com.uniyaz.uı.page.urun.UrunListePage;
import com.uniyaz.uı.page.urun.UrunPage;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

public class HbMenuBar extends MenuBar
{
    private ContentComponent contentComponent;

    public HbMenuBar()
    {
        setSizeFull();

        HbUI hbUI = (HbUI) UI.getCurrent();
        contentComponent = hbUI.getContentComponent();

        buildUrunMenuItem();
        buildMusteriMenuItem();
    }

    private void buildUrunMenuItem()
    {
        MenuItem urunMenuItem = addItem("Ürün", FontAwesome.PHONE,null);
        urunMenuItem.addItem("Ürün Ekle", FontAwesome.SAVE, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                UrunPage urunPage = new UrunPage();
                contentComponent.addComponent(urunPage);
            }
        });

        urunMenuItem.addItem("Ürün Listele", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                UrunListePage urunListePage = new UrunListePage();
                contentComponent.addComponent(urunListePage);
            }
        });
    }

    private void buildMusteriMenuItem()
    {
        MenuItem musteriMenuItem = addItem("Müşteri", FontAwesome.AMAZON, null);
        musteriMenuItem.addItem("Müşteri Ekle", FontAwesome.SAVE, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                MusteriPage musteriPage = new MusteriPage();
                contentComponent.addComponent(musteriPage);
            }
        });

        musteriMenuItem.addItem("Müşteri Listele", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                MusteriListePage musteriListPage = new MusteriListePage();
                contentComponent.addComponent(musteriListPage);
            }
        });
    }
}
