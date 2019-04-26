/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao;

import com.bank.model.EntityFactory;
import com.bank.model.HibernateUtil;
import com.bank.model.UserRecord;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ASHIM
 */
public class MainDao {
    
   SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    static void sessionClose(Session session) {
        System.out.println("yes, I'm DaoDefault class");
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }

        } catch (HibernateException e) {
            System.out.println("session close : " + e.toString());
        }
    }
     public boolean checkLoginCredential(String username, String password) {
        Session session = sessionFactory.openSession();
        boolean login = false;
         System.out.println("checkLogin method");
        try {
            session.beginTransaction();
            Criteria loginCrit = session.createCriteria(UserRecord.class);
            loginCrit.add(Restrictions.eq("email", username));
            loginCrit.add(Restrictions.eq("password", password));
            session.getTransaction();

            List<UserRecord> user = loginCrit.list();
            System.out.println("hellow");
            System.out.println("size " + user.size());

            if (user.size() == 1) {
                login = true;
            }
        } catch (Exception  e) {
            e.printStackTrace();
            System.out.println("exception : ");
            login = false;
        } finally {
            sessionClose(session);
        }
        return login;
    }
     
     public UserRecord loadUserInfo(String username, String password) {
        UserRecord user = (UserRecord) EntityFactory.getEntityObj("UserRecord");
        Session session = sessionFactory.openSession();
         System.out.println("loaduserinfo method");
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(UserRecord.class);
            criteria.add(Restrictions.eq("email", username));
            criteria.add(Restrictions.eq("password", password));
            user = (UserRecord) criteria.uniqueResult();
        } catch (HibernateException e) {
        } finally {
           sessionClose(session);
        }
        return user;
    }
    
}
