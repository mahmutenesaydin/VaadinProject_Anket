package com.uniyaz.core.service;

import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.dao.KullaniciDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Kullanici;

import java.util.List;

public class KullaniciService
{
    KullaniciDao kullaniciDao = new KullaniciDao();

    public void saveKullanici(Kullanici kullanici) {
        kullaniciDao.saveKullanici(kullanici);
    }

    public void deleteKullanici(Kullanici kullanici) {
        kullaniciDao.deleteKullanici(kullanici);
    }

    public List<Kullanici> findAllHql() {
        return kullaniciDao.findAllHql();
    }
}
