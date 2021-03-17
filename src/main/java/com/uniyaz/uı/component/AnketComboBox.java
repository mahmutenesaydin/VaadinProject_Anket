package com.uniyaz.uı.component;

import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.domain.Anket;
import com.vaadin.ui.ComboBox;

import java.util.List;

public class AnketComboBox extends ComboBox
{
    private AnketDao anketDao;

    public AnketComboBox()
    {
        this.anketDao = new AnketDao();
        this.setDescription("Kategori Seçiniz");
        fillComboBox();
    }

    private void fillComboBox()
    {
        this.removeAllItems();
        List<Anket> anketList = anketDao.findAllHql();
        for (Anket anket : anketList)
        {
            this.addItem(anket);
            setItemCaption(anket,anket.getAd());
        }
    }
}
