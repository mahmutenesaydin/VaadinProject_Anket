package com.uniyaz.core.service;

import com.uniyaz.core.dao.MusteriDao;
import com.uniyaz.core.domain.Musteri;

import java.util.List;


public class MusteriService
{
    MusteriDao musteriDao = new MusteriDao();

    public void saveMusteri(Musteri musteri)
    {
        musteriDao.saveMusteri(musteri);
    }

    public List<Musteri> findAllHqlMusteri()
    {
        return musteriDao.findAllHqlMUSTERI();
    }
}
