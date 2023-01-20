package com.algaworks.ecommerce;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {

    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence
                 .createEntityManagerFactory("Ecommerce-PU");
    }
    @AfterClass
    public static void tearDownafterClass() {
        entityManagerFactory.close();
    }

    @Before
    public void setUP(){
        entityManager = entityManagerFactory.createEntityManager();
    }
    @After
    public void tearDown(){
        entityManager.close();;
    }
}
