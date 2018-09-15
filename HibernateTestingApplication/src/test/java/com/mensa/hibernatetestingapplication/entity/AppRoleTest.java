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

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppRoleTest extends TestCase {
    
        EntityManagerFactory entityManagerFactory; 
        EntityManager entityManager; 
        private final String ROLECODE = "testing";
    
        // <editor-fold desc="Constructor">
        public AppRoleTest()
        {
            System.out.println("Start AppRole Test Constructor"); 
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
            System.out.println("Start AppRole Test finalize"); 
//            session.getTransaction().rollback();
//            session.close();
        }
    
	@Override
	protected void tearDown() throws Exception {
            System.out.println("Start AppRole Test tearDown"); 
            entityManagerFactory.close();
	}
        
        public AppRole createRole() {
            System.out.println("start createRole"); 
            AppRole role = new AppRole(ROLECODE);
            entityManager.persist(role);
            //session.save(user);
            return role; 
        }
        
        public AppRole getTestingRecord() {
            System.out.println("start getTestingRecord"); 
            List<AppRole> answer = entityManager.createQuery("select role from AppRole role where role.code = :code", AppRole.class)
                    .setParameter("code", ROLECODE)
                    .setMaxResults(1)
                    .getResultList(); 
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
        
	public void testCreateRole() {
            System.out.println("Start testCreateRole"); 
            setTransaction(); 
            createRole(); 
            //throw new java.lang.Error("*****************Testing Error*********************"); 
            AppRole role = getTestingRecord(); 
            setRollback(); 
            System.out.println("Finished testCreateRole"); 
            assertTrue(role != null); 
	}
        
        public void testDeleteRole() {
            System.out.println("Start testDeleteRole"); 
            setTransaction(); 
            createRole();
            AppRole role = getTestingRecord(); 
            boolean existedRecord = (role != null); 
            if (existedRecord) {
                System.out.println("testDeleteRole existed record"); 
                entityManager.remove(role);
                role = getTestingRecord(); 
                System.out.println("Finished testDeleteRole"); 
                assertTrue(role == null); 
            } else {
                assertTrue(existedRecord); 
            }
            setRollback(); 
        }
}
