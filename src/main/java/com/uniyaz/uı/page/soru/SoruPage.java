package com.uniyaz.uı.page.soru;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.SoruService;
import com.uniyaz.uı.component.HbSaveButton;
import com.uniyaz.uı.component.SecenekComboBox;
import com.uniyaz.uı.page.BasePage;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;


public class SoruPage extends BasePage {
    @PropertyId("ID")
    private TextField id;

    @PropertyId("soru")
    private TextField soru;

    @PropertyId("secenek")
    private SecenekComboBox secenek;

    private FormLayout mainLayout;

    private BeanItem<Soru> soruBeanItem;
    private FieldGroup binder;
    private HbSaveButton vpSaveButton;
    private Anket anket;


    public SoruPage(Anket anket)
    {
        this.anket = anket;
        Soru soru = new Soru();
        soru.setAnket(anket);

        buildView(soru);
    }

    public SoruPage(Soru soru)
    {
        buildView(soru);
    }

    private void buildView(Soru soru) {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        soruBeanItem = new BeanItem<Soru>(soru);
        binder = new FieldGroup(soruBeanItem);
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

        soru = new TextField();
        soru.setCaption("Soru");
        mainLayout.addComponent(soru);

        secenek = new SecenekComboBox();
        secenek.setCaption("Soru Biçimi");
        mainLayout.addComponent(secenek);


        vpSaveButton = new HbSaveButton();
        vpSaveButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {
                try
                {
                    binder.commit();

                    Soru soru = soruBeanItem.getBean();
                    SoruService soruService = new SoruService();
                    soruService.saveSoru(soru);
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
