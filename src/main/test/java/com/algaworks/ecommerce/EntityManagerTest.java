package com.algaworks.ecommerce;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {

    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @BeforeAll
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence
                 .createEntityManagerFactory("Ecommerce-PU");
        System.out.println("aqui");
    }
    @AfterAll
    public static void tearDownafterClass() {
        entityManagerFactory.close();
    }

    @BeforeEach
    public void setUP(){
        entityManager = entityManagerFactory.createEntityManager();
    }
    @AfterEach
    public void tearDown(){
        entityManager.close();;
    }
}
