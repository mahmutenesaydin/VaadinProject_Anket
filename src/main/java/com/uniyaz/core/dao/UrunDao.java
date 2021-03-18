package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class UrunDao
{
    public void saveUrun(Urun urun)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            session.merge(urun);
            transaction.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Urun> findAllHqlURUN()
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession())
        {
            String hql =
                    "Select     urunAlias " +
                    "From       Urun urunAlias ";
            Query query = session.createQuery(hql);
            return query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<Urun> findByIdCriteria(Long id)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession())
        {
            Criteria criteria = session.createCriteria(Urun.class);
            criteria.add(Restrictions.eq("id", id));
            criteria.add(Restrictions.like("kodu", "U", MatchMode.START));
            return criteria.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
