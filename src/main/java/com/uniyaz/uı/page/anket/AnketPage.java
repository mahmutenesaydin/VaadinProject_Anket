package com.uniyaz.uı.page.anket;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.service.AnketService;
import com.uniyaz.uı.component.HbSaveButton;
import com.uniyaz.uı.page.BasePage;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;


public class AnketPage extends BasePage {
    @PropertyId("id")
    private TextField id;

    @PropertyId("ad")
    private TextField anket;


    private FormLayout mainLayout;

    private BeanItem<Anket> anketBeanItem;
    private FieldGroup binder;
    private HbSaveButton vpSaveButton;

    public AnketPage()
    {
        this(new Anket());
    }

    public AnketPage(Anket anket) {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        anketBeanItem = new BeanItem<Anket>(anket);
        binder = new FieldGroup(anketBeanItem);
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

        anket = new TextField();
        anket.setCaption("Anket");
        mainLayout.addComponent(anket);

        vpSaveButton = new HbSaveButton();
        vpSaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Anket anket = anketBeanItem.getBean();
                    AnketService anketService = new AnketService();
                    anketService.saveAnket(anket);
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
