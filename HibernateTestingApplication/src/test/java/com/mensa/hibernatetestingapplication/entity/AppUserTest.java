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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Unit test for simple App.
 */
public class AppUserTest extends TestCase {
//        SessionFactory sessionFactory;
//        Session session; 
        EntityManagerFactory entityManagerFactory; 
        EntityManager entityManager; 
        private final String USERCODE = "testing";
    
        // <editor-fold desc="Constructor">
        public AppUserTest()
        {
            System.out.println("Start AppUser Test Constructor"); 
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//            session = sessionFactory.openSession();
//            session.beginTransaction();
        }
        @Override
	protected void setUp() throws Exception {
            entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.testing.jpa" );
	}

        // </editor-fold>
        
        @Override
        public void finalize()
        {
            System.out.println("Start AppUser Test finalize"); 
//            session.getTransaction().rollback();
//            session.close();
        }
    
	@Override
	protected void tearDown() throws Exception {
            System.out.println("Start AppUser Test tearDown"); 
            entityManagerFactory.close();
	}
        
        public AppUser createUser() {
            System.out.println("start createUser"); 
            AppUser user = new AppUser(USERCODE);
            entityManager.persist(user);
            //session.save(user);
            return user; 
        }
        
        public AppUser getTestingRecord() {
            System.out.println("start getTestingRecord"); 
            List<AppUser> answer = entityManager.createQuery( "select user from AppUser user where user.code = :code", AppUser.class)
                    .setParameter("code", USERCODE)
                    .setMaxResults(1)
                    .getResultList(); 
//            AppUser answer = (AppUser) session
//                .createQuery("from app_users user where user.code = :code")
//                .setParameter("code", USERCODE)
//                .uniqueResult(); 
            System.out.println("finished getTestingRecord"); 
            if (answer.size() > 0) {
                return answer.get(0); 
            } else {
                return null; 
            }
        }
        
        public void setTransaction() {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
        }
        
        public void setRollback() {
            entityManager.getTransaction().rollback();
            entityManager.close(); 
        }
        
	public void testCreateUser() {
            System.out.println("Start testCreateUser"); 
            setTransaction(); 
            createUser(); 
            //throw new java.lang.Error("*****************Testing Error*********************"); 
            AppUser user = getTestingRecord(); 
            setRollback(); 
            System.out.println("Finished testCreateUser"); 
            assertTrue(user != null); 
	}
        
        public void testDeleteUser() {
            System.out.println("Start testDeleteUser"); 
            setTransaction(); 
            createUser();
            AppUser user = getTestingRecord(); 
            boolean existedRecord = (user != null); 
            if (existedRecord) {
                System.out.println("testDeleteUser existed record"); 
                entityManager.remove(user);
                user = getTestingRecord(); 
                System.out.println("Finished testDeleteUser"); 
                assertTrue(user == null); 
            } else {
                assertTrue(existedRecord); 
            }
            setRollback(); 
        }
        
/*
        @Test(expected = org.postgresql.util.PSQLException.class)
	public void testCreateInvalidUserCode() {
            AppUser user = new AppUser("firstuser12");
            session.save(user);
	}
*/
        
}