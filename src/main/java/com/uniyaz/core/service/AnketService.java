package com.uniyaz.core.service;

import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.domain.Anket;

import java.util.List;

public class AnketService
{
    AnketDao anketDao = new AnketDao();

    public void saveAnket(Anket anket) {
        anketDao.saveAnket(anket);
    }

    public void deleteAnket(Anket anket) {
        anketDao.deleteAnket(anket);
    }

    public List<Anket> findAllHql() {
        return anketDao.findAllHql();
    }
}
