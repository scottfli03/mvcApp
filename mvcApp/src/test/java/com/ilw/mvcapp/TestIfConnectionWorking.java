/**
 * 
 */
package com.ilw.mvcapp;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Scott
 *
 */
public class testIfConnectionWorking {

    protected static EntityManagerFactory emf;

    protected EntityManager em;
    private static boolean isOpen=false;
    
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("list");
	}
	
    @Before
    public void beginTransaction() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        this.isOpen = em.isOpen();
    }
    
    
	
	@Test
	public void testIfConnectionIsWorking() {
		Assert.assertTrue(isOpen);
		
	}
	
    @After
    public void rollbackTransaction() {   
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }

        if (em.isOpen()) {
            em.close();
        }
    }

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emf.close();
	}
}
