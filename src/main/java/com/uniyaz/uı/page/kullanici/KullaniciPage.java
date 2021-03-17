package com.uniyaz.uı.page.kullanici;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Kullanici;
import com.uniyaz.core.service.AnketService;
import com.uniyaz.core.service.KullaniciService;
import com.uniyaz.uı.component.ContentComponent;
import com.uniyaz.uı.component.HbSaveButton;
import com.uniyaz.uı.page.BasePage;
import com.uniyaz.uı.page.anket.AnketCoz;
import com.uniyaz.uı.page.anket.AnketPage;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;


public class KullaniciPage extends BasePage
{
    @PropertyId("id")
    private TextField id;

    @PropertyId("mail")
    private TextField mail;


    private FormLayout mainLayout;

    private BeanItem<Kullanici> kullaniciBeanItem;
    private FieldGroup binder;
    private HbSaveButton vpSaveButton;


    public KullaniciPage()
    {
        this(new Kullanici());
    }

    public KullaniciPage(Kullanici kullanici) {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        kullaniciBeanItem = new BeanItem<Kullanici>(kullanici);
        binder = new FieldGroup(kullaniciBeanItem);
        binder.bindMemberFields(this);
    }

    @Override
    public void buildMainLayout() {
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        id = new TextField();
        id.setCaption("ID");
        id.setEnabled(false);
        mainLayout.addComponent(id);

        mail = new TextField();
        mail.setCaption("Mail Adresinizi Girerek Giriş Yapabilirsiniz");
        mainLayout.addComponent(mail);

        vpSaveButton = new HbSaveButton();
        vpSaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Kullanici kullanici = kullaniciBeanItem.getBean();
                    KullaniciService kullaniciService = new KullaniciService();
                    kullaniciService.saveKullanici(kullanici);

                    ContentComponent contentComponent;
                    HbUI hbUI = (HbUI) UI.getCurrent();
                    contentComponent = hbUI.getContentComponent();

                    AnketCoz anketCoz = new AnketCoz();
                    contentComponent.addComponent(anketCoz);

                } catch (FieldGroup.CommitException e) {
                    Notification.show("Geçersiz, lütfen geçerli değerler giriniz", Notification.Type.ERROR_MESSAGE);
                } catch (Exception e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        mainLayout.addComponent(vpSaveButton);
    }
}
