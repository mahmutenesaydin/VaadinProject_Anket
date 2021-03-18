package com.uniyaz.uı.page.soru;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.EnumSoruTuru;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.SoruService;
import com.uniyaz.uı.component.HbSaveButton;
import com.uniyaz.uı.component.SecenekComboBox;
import com.uniyaz.uı.page.secenek.SecenekEkle;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


public class SoruPage extends TabSheet {
    @PropertyId("ID")
    private TextField id;

    @PropertyId("soru")
    private TextField soru;

//  private SecenekComboBox secenek;
//    @PropertyId("enumSecenek")
//    private ComboBox secenek;

    private EnumSoruTuru enumSoruTuru;

    @PropertyId("enumSecenek")
    private SecenekComboBox soruTipiComboBox;

    private TextField secenek;

    private BeanItem<Soru> soruBeanItem;
    private FieldGroup binder;
    private HbSaveButton vpSaveButton;
    private Anket anket;
    private VerticalLayout secenekEkleLayout;
    private VerticalLayout soruEkleLayout;


    public SoruPage(Anket anket)
    {
        this.anket = anket;
        Soru soru = new Soru();
        soru.setAnket(anket);

        addStyleName(ValoTheme.TABSHEET_FRAMED);
        addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

        final FormLayout formLayout = new FormLayout();
        formLayout.setWidth(100.0f, Unit.PERCENTAGE);

        soruEkle();
        secenekEkle();

        buildView(soru);
    }

    public SoruPage(Soru soru)
    {
        buildView(soru);
    }

    private void buildView(Soru soru)
    {
        setSizeFull();
        buildMainLayout();
   //     addComponent(mainLayout);
       // setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        soruBeanItem = new BeanItem<Soru>(soru);
        binder = new FieldGroup(soruBeanItem);
        binder.bindMemberFields(this);
    }

    private void soruEkle()
    {
        soruEkleLayout =new VerticalLayout();
        soruEkleLayout.setMargin(true);
        addTab(soruEkleLayout, "Soru Ekle " );


        id = new TextField();
        id.setCaption("ID");
        id.setNullRepresentation("");
        soruEkleLayout.addComponent(id);

        soru = new TextField();
        soru.setCaption("Soruyaz");
        soru.setNullRepresentation("");
        soruEkleLayout.addComponent(soru);

        soruTipiComboBox = new SecenekComboBox();
        soruTipiComboBox.setCaption("Soru Tipi");
        soruEkleLayout.addComponent(soruTipiComboBox);

        vpSaveButton = new HbSaveButton();
        vpSaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Soru soru = soruBeanItem.getBean();
                    SoruService soruService = new SoruService();
                    soruService.saveSoru(soru);

                    Notification.show( soru.getSoru() + " Sorusunu Eklendiniz");
                } catch (FieldGroup.CommitException e) {
                    Notification.show("Alanlar nesne ile uyumlu değil", Notification.Type.ERROR_MESSAGE);
                } catch (Exception e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        soruEkleLayout.addComponent(vpSaveButton);

        Button secenekEkle = new Button();
        secenekEkle.setCaption("Secenek Ekle");
        secenekEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        soruEkleLayout.addComponent(secenekEkle);
    }

    private void secenekEkle()
    {
        secenekEkleLayout = new VerticalLayout();
        secenekEkleLayout.setMargin(true);
        addTab(secenekEkleLayout,"Seçenek Ekle");

        SecenekEkle secenekEkle1 = new SecenekEkle();
        secenekEkleLayout.addComponent(secenekEkle1);
    }

    public void buildMainLayout() {
//        mainLayout = new FormLayout();
//        mainLayout.setSizeUndefined();
//
//        secenekEkle = new VerticalLayout();
//        secenekEkle.setMargin(true);
//        addTab(secenekEkle,"Seçenek Ekle");
//
//        id = new TextField();
//        id.setCaption("ID");
//        id.setNullRepresentation("");
//        id.setEnabled(false);
//        mainLayout.addComponent(id);
//
//        soru = new TextField();
//        soru.setCaption("Soru");
//        soru.setNullRepresentation("");
//        mainLayout.addComponent(soru);
//
//        soruTipiComboBox = new SecenekComboBox();
//        soruTipiComboBox.setCaption("Soru Tipi");
//        mainLayout.addComponent(soruTipiComboBox);
//
//        vpSaveButton = new HbSaveButton();
//        vpSaveButton.addClickListener(new Button.ClickListener()
//        {
//            @Override
//            public void buttonClick(Button.ClickEvent clickEvent)
//            {
//                try
//                {
//                    binder.commit();
//
//                    Soru soru = soruBeanItem.getBean();
//                    SoruService soruService = new SoruService();
//                    soruService.saveSoru(soru);
//                }
//                catch (FieldGroup.CommitException e)
//                {
//                    Notification.show("Geçersiz, lütfen geçerli değerler giriniz", Notification.Type.ERROR_MESSAGE);
//                } catch (Exception e)
//                {
//                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
//                }
//            }
//        });
//        mainLayout.addComponent(vpSaveButton);
    }
}
