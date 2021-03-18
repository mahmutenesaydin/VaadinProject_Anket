package com.uniyaz.uı.page.urun;

import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.service.UrunService;
import com.uniyaz.uı.component.HbSaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class UrunPage extends VerticalLayout {
    @PropertyId("id")
    private TextField id;

    @PropertyId("ad")
    private TextField ad;

    @PropertyId("kod")
    private TextField kod;

    @PropertyId("fiyat")
    private TextField fiyat;


    private FormLayout mainLayout;
    private HbSaveButton btnSave;

    private BeanItem<Urun>urunBeanItem;
    private FieldGroup binder;


    public UrunPage() {
        this(new Urun());
    }

    public UrunPage(Urun urun) {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        urunBeanItem = new BeanItem<Urun>(urun);
        binder = new FieldGroup(urunBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildMainLayout() {
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        id = new TextField();
        id.setInputPrompt("ID");
        id.setEnabled(false);
        mainLayout.addComponent(id);

        ad = new TextField();
        ad.setInputPrompt("Ürünün Adını Giriniz");
        mainLayout.addComponent(ad);

        kod = new TextField();
        kod.setInputPrompt("Ürünün Kodunu giriniz");
        mainLayout.addComponent(kod);

        fiyat = new TextField();
        fiyat.setInputPrompt("Ürünün Fiyatını Giriniz");
        mainLayout.addComponent(fiyat);

        btnSave = new HbSaveButton();
        btnSave.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                try {
                    try {
                        binder.commit();

                        Urun urun = urunBeanItem.getBean();
                        UrunService urunService = new UrunService();
                        urunService.saveUrun(urun);
                    } catch (FieldGroup.CommitException e) {
                        Notification.show("Alanlar Nesne İle Uyumlu Değil", Notification.Type.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        mainLayout.addComponent(btnSave);
    }
}
