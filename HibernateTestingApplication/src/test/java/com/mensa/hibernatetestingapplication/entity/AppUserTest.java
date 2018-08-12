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
    
        // <editor-fold desc="Constructor">
        public AppUserTest()
        {
            System.out.println("Start AppUser Test Constructor"); 
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
        }
        // </editor-fold>
        
        @Override
        public void finalize()
        {
            session.getTransaction().rollback();
            session.close();
        }
    
	public void testCreateUser() {
            System.out.println("Start testCreateUser"); 
            AppUser user = new AppUser("firstuser");
            session.save(user);
            //throw new java.lang.Error("*****************Testing Error*********************"); 
            System.out.println("Finished testCreateUser"); 
	}
        
        public void testDeleteUser() {
            System.out.println("Start testDeleteUser"); 
            AppUser user = new AppUser("firstuser");
            session.save(user);
            session.delete(user);
            System.out.println("Finished testDeleteUser"); 
            
        }
        
/*
        @Test(expected = org.postgresql.util.PSQLException.class)
	public void testCreateInvalidUserCode() {
            AppUser user = new AppUser("firstuser12");
            session.save(user);
	}
*/
        
}