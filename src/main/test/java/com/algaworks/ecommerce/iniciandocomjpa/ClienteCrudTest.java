package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class ClienteCrudTest extends EntityManagerTest {

    @Test
    public void insertClient(){
        Cliente cliente = new Cliente(2, "Pérycles Júnior");
        Cliente cliente2 = new Cliente(3, "Pedro Pérycles");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.persist(cliente2);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteconsulta = entityManager.find(Cliente.class, 2);
        Cliente clienteconsulta2 = entityManager.find(Cliente.class, 3);

        Assert.assertNotNull(clienteconsulta);
        Assert.assertNotNull(clienteconsulta2);
    }
    @Test
    public void deleteClient(){
        Cliente cliente = new Cliente(2, "Pérycles Júnior");

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Cliente cliente1 = entityManager.find(Cliente.class, 2);

        Assert.assertNull(cliente1);

    }
    @Test
    public void updateClient(){
        Cliente cliente = entityManager.find(Cliente.class, 3);
        cliente.setNome("Karinne Muniz");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Cliente cliente1 = entityManager.find(Cliente.class, 3);

        Assert.assertEquals("", cliente1.getNome());

    }


    @Test
    public void consultaClient(){
        Cliente cliente = entityManager.find(Cliente.class, 2);


        Assert.assertEquals("Pérycles Júnior", cliente.getNome());

    }
}
