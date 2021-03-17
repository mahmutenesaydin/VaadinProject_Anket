package com.uniyaz.core.service;

import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.dao.SecenekDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Secenek;

import java.util.List;

public class SecenekService
{
    SecenekDao secenekDao = new SecenekDao();

    public void saveSecenek(Secenek secenek) {
        secenekDao.saveSecenek(secenek);
    }

    public void deleteSecenek(Secenek secenek) {
        secenekDao.deleteSecenek(secenek);
    }

    public List<Secenek> findAllHql() {
        return secenekDao.findAllHql();
    }
}
