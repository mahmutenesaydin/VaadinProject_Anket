package com.uniyaz.core.service;

import com.uniyaz.core.dao.CevapDao;
import com.uniyaz.core.dao.CevapDao;
import com.uniyaz.core.domain.Cevap;
import com.uniyaz.core.domain.Cevap;

import java.util.List;

public class CevapService
{
    CevapDao cevapDao = new CevapDao();

    public void saveCevap(Cevap cevap) {
        cevapDao.saveCevap(cevap);
    }

    public void deleteCevap(Cevap cevap) {
        cevapDao.deleteCevap(cevap);
    }

    public List<Cevap> findAllHql() {
        return cevapDao.findAllHql();
    }
}
