package com.uniyaz.uı.page.musteri;

import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.service.MusteriService;
import com.uniyaz.uı.component.HbSaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class MusteriPage extends VerticalLayout
{
    @PropertyId("id")
    private TextField id;

    @PropertyId("ad")
    private TextField ad;

    private FormLayout mainLayout;

    private BeanItem<Musteri> musteriBeanItem;
    private FieldGroup binder;
    private HbSaveButton hbSaveButton;

    public MusteriPage()
    {
        this(new Musteri());
    }

    public MusteriPage(Musteri musteri)
    {
        setSizeFull();
        buildMusteriLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        musteriBeanItem = new BeanItem<Musteri>(musteri);
        binder = new FieldGroup(musteriBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildMusteriLayout()
    {
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        id = new TextField();
        id.setCaption("ID");
        id.setEnabled(false);
        mainLayout.addComponent(id);

        ad = new TextField();
        ad.setCaption("Adı");
        mainLayout.addComponent(ad);

        hbSaveButton = new HbSaveButton();
        hbSaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try
                {
                    try {
                        binder.commit();
                        Musteri musteri = musteriBeanItem.getBean();
                        MusteriService musteriService = new MusteriService();
                        musteriService.saveMusteri(musteri);
                    } catch (FieldGroup.CommitException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mainLayout.addComponent(hbSaveButton);
    }
}
