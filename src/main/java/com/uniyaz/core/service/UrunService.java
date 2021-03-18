package com.uniyaz.core.service;

import com.uniyaz.core.dao.UrunDao;
import com.uniyaz.core.domain.Urun;

import java.util.List;

public class UrunService
{

    UrunDao urunDao = new UrunDao();

    public void saveUrun(Urun urun)
    {
        validateSaveUrun(urun);
        urunDao.saveUrun(urun);
    }

    private void validateSaveUrun(Urun urun)
    {
        if (!urun.getKod().startsWith("U"))
            throw new RuntimeException("Ürün Kodu U ile Başlamak Zorunda!!!");
    }

    public List<Urun> findAllHqlURUN()
    {
        return urunDao.findAllHqlURUN();
    }
}
