package com.uniyaz.uı.component;

import com.uniyaz.HbUI;
import com.uniyaz.uı.page.anket.AnketCoz;
import com.uniyaz.uı.page.anket.AnketListPage;
import com.uniyaz.uı.page.anket.AnketPage;
import com.uniyaz.uı.page.kullanici.KullaniciPage;
import com.uniyaz.uı.page.soru.SoruListPage;
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

        buildAnketIslemleri();
        buildSoruIslemleri();
        buildKullaniciIslemleri();
    }

    private void buildAnketIslemleri()
    {
        MenuItem anketIslemleriMenuItem =addItem("Anket İşlemleri", null);
        anketIslemleriMenuItem.addItem("Anket Ekle", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem)
            {
                AnketPage anketPage = new AnketPage();
                contentComponent.addComponent(anketPage);
            }
        });

        anketIslemleriMenuItem.addItem("Anket Listele", FontAwesome.LIST, new Command()
        {
            @Override
            public void menuSelected(MenuItem menuItem)
            {
                AnketListPage anketListPage = new AnketListPage();
                contentComponent.addComponent(anketListPage);
            }
        });
    }

    private void buildSoruIslemleri()
    {
        MenuItem soruIslemleriMenuItem =addItem("Soru İşlemleri", null);
        soruIslemleriMenuItem.addItem("Soruları Görüntüle", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem)
            {
                SoruListPage soruListPage = new SoruListPage();
                contentComponent.addComponent(soruListPage);
            }
        });
    }

    private void buildKullaniciIslemleri()
    {
        MenuItem kullaniciIslemleriMenuItem =addItem("Kullanıcı İşlemleri", null);
        kullaniciIslemleriMenuItem.addItem("Anketi Çözmeye Başla", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem)
            {
//                AnketCoz anketCoz = new AnketCoz();
//                contentComponent.addComponent(anketCoz);

                KullaniciPage kullaniciPage = new KullaniciPage();
                contentComponent.addComponent(kullaniciPage);
            }
        });
    }
}
