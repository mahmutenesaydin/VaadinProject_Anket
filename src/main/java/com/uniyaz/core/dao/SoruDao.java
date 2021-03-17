package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SoruDao
{

    public void saveSoru(Soru soru)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(soru);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSoru(Soru soru)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            session.delete(soru);
            transaction.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Soru> findAllHql()
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     soruAlias " +
                    "From       Soru soruAlias " +
                    "Left Join Fetch soruAlias.anket anket ";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Soru> findAllByanketId(Long anketId)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     soru " +
                    "From       Soru soru " +
                    "Left Join Fetch soru.anket anket " +
                    "where      soru.id = : anketId";
            Query query = session.createQuery(hql);
            query.setParameter("anketId", anketId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
