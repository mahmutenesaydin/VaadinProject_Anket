package com.uniyaz.core.service;

import com.uniyaz.core.dao.SoruDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Soru;

import java.util.List;

public class SoruService
{
    SoruDao soruDao = new SoruDao();

    public void saveSoru(Soru soru) {
        soruDao.saveSoru(soru);
    }

    public void deleteSoru(Soru soru) {
        soruDao.deleteSoru(soru);
    }

    public List<Soru> findAllHql() {
        return soruDao.findAllHql();
    }

    public List<Soru> findAllByMusteriId(Long anketId) {
        return soruDao.findAllByanketId(anketId);
    }
}
