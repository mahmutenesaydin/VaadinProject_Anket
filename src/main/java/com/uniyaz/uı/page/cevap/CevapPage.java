package com.uniyaz.uı.page.cevap;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Cevap;
import com.uniyaz.core.domain.Kullanici;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.CevapService;
import com.uniyaz.core.service.SoruService;
import com.uniyaz.uı.component.HbSaveButton;
import com.uniyaz.uı.page.BasePage;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;


public class CevapPage extends BasePage
{
    @PropertyId("ID")
    private TextField id;

    @PropertyId("cevap")
    private TextField cevap;

    private FormLayout mainLayout;

    private BeanItem<Cevap> cevapBeanItem;
    private FieldGroup binder;
    private HbSaveButton vpSaveButton;
    private Kullanici kullanici;
    private Soru soru;

    public CevapPage(Soru soru)
    {
        this.soru = soru;
        Cevap cevap = new Cevap();
        cevap.setSoru(soru);

        buildView(cevap);
    }

//    public CevapPage(Cevap cevap)
//    {
//        buildView(cevap);
//    }

    public void buildView(Cevap cevap)
    {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        cevapBeanItem = new BeanItem<Cevap>(cevap);
        binder = new FieldGroup(cevapBeanItem);
        binder.bindMemberFields(this);
    }

    public CevapPage(Kullanici kullanici)
    {
        this.kullanici = kullanici;

        Anket anket = new Anket();
        anket.setKullanici(kullanici);
    }

    @Override
    public void buildMainLayout() {
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        id = new TextField();
        id.setCaption("ID");
        id.setEnabled(false);
        mainLayout.addComponent(id);

        cevap = new TextField();
        cevap.setCaption("Cevap");
        mainLayout.addComponent(cevap);

        vpSaveButton = new HbSaveButton();
        vpSaveButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {
                try
                {
                    binder.commit();

                    Cevap cevap = cevapBeanItem.getBean();
                    CevapService cevapService = new CevapService();
                    cevapService.saveCevap(cevap);
                }
                catch (FieldGroup.CommitException e)
                {
                    Notification.show("Geçersiz, lütfen geçerli değerler giriniz", Notification.Type.ERROR_MESSAGE);
                } catch (Exception e)
                {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        mainLayout.addComponent(vpSaveButton);
    }
}
