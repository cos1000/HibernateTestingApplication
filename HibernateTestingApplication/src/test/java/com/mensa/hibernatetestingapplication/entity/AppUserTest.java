/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mensa.hibernatetestingapplication.entity;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mensa.hibernatetestingapplication.entity.AppUser;

/**
 * Unit test for simple App.
 */
public class AppUserTest extends TestCase {
        SessionFactory sessionFactory;
        Session session; 
    
        public AppUserTest()
        {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
        }
        
        @Override
        public void finalize()
        {
            session.getTransaction().rollback();
            session.close();
        }
    
	public void testCreateUser() {
            AppUser user = new AppUser("firstuser");
            session.save(user);
	}
        
/*
        @Test(expected = org.postgresql.util.PSQLException.class)
	public void testCreateInvalidUserCode() {
            AppUser user = new AppUser("firstuser12");
            session.save(user);
	}
*/
        
}