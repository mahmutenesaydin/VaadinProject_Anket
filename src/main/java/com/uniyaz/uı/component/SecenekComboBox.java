package com.uniyaz.uı.component;

import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.dao.SecenekDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Secenek;
import com.vaadin.ui.ComboBox;

import java.util.List;

public class SecenekComboBox extends ComboBox
{
    private SecenekDao secenekDao;

    public SecenekComboBox()
    {
        this.secenekDao = new SecenekDao();
        this.setDescription("Kategori Seçiniz");
        fillComboBox();
    }

    private void fillComboBox()
    {
        this.removeAllItems();
        List<Secenek> secenekList = secenekDao.findAllHql();
        for (Secenek secenek : secenekList)
        {
            this.addItem(secenek);
            setItemCaption(secenek,secenek.getSecenek());
        }
    }
}
