package com.uniyaz.uı.page.secenek;

import com.uniyaz.core.domain.Secenek;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.SecenekService;
import com.uniyaz.uı.component.HbSaveButton;
import com.uniyaz.uı.page.BasePage;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;


public class SecenekEkle extends BasePage {
    @PropertyId("id")
    private TextField id;

    @PropertyId("secenek")
    private TextField secenek;

    @PropertyId("soru")
    private Soru soru;


    private FormLayout mainLayout;

    private BeanItem<Secenek> secenekBeanItem;
    private FieldGroup binder;
    private HbSaveButton vpSaveButton;

    public SecenekEkle()
    {
        this(new Secenek());
    }

    public SecenekEkle(Secenek secenek) {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        secenekBeanItem = new BeanItem<Secenek>(secenek);
        binder = new FieldGroup(secenekBeanItem);
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

        secenek = new TextField();
        secenek.setCaption("Secenek");
        mainLayout.addComponent(secenek);

        vpSaveButton = new HbSaveButton();
        vpSaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Secenek secenek = secenekBeanItem.getBean();
                    SecenekService secenekService = new SecenekService();
                    secenekService.saveSecenek(secenek);
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
