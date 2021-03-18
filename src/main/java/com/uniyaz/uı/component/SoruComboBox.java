package com.uniyaz.uı.component;

import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.dao.SoruDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.uı.page.soru.SoruGetir;
import com.vaadin.ui.ComboBox;

import java.util.List;

public class SoruComboBox extends ComboBox
{
    private SoruDao soruDao;
    private Soru soru;

    public SoruComboBox()
    {
        this.soruDao = new SoruDao();
        this.setDescription("Soruyu Seçiniz");
        fillComboBox();
    }

    private void fillComboBox()
    {
        this.removeAllItems();
 //      List<Soru> soruList = soruDao.findAllByanketId(soru.getId());
        List<Soru> soruList = soruDao.findAllHql();
        for (Soru soru : soruList)
        {
            this.addItem(soru);
            setItemCaption(soru,soru.getSoru());
        }
    }
}
