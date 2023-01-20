package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ClienteCrudTest extends EntityManagerTest {

    @Order(1)
    @Test
    public void insertClient(){
        Cliente cliente = new Cliente(3, "Pérycles Júnior");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteconsulta = entityManager.find(Cliente.class, 3);

        assertNotNull(clienteconsulta);

    }

    @Order(2)
    @Test
    public void deleteClient(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Cliente cliente1 = entityManager.find(Cliente.class, 2);

        assertNull(cliente1);

    }


    @Test
    public void updateClient(){
        Cliente cliente = entityManager.find(Cliente.class, 1);
        cliente.setNome("Karinne Muniz");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Cliente cliente1 = entityManager.find(Cliente.class, 1);

        assertEquals("Karinne Muniz", cliente1.getNome());

    }


    @Test
    public void consultaClient(){
        Cliente cliente = entityManager.find(Cliente.class, 1);
        assertEquals("Karinne Muniz", cliente.getNome());

    }
}
