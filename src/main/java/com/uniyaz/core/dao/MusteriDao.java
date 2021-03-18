package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MusteriDao
{
    public void saveMusteri(Musteri musteri)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            session.merge((musteri));
            transaction.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Musteri> findAllHqlMUSTERI()
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession())
        {
            String hqlMusteri =
                    "Select     musteriAlias " +
                    "From       Musteri musteriAlias ";
            Query query = session.createQuery(hqlMusteri);
            return query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
