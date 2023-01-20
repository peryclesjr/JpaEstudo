package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ConsultaRegistroTest extends EntityManagerTest {

    @Test
    public void buscarProId(){
        Produto produto = entityManager.find(Produto.class, 1);

        Assert.assertNotNull(produto);
        Assert.assertEquals(1L, produto.getId().longValue());
    }

    @Test
    public void buscaProIdInexistente(){
        Produto produto = entityManager.find(Produto.class, 2);

        Assert.assertNull(produto);
    }



}
