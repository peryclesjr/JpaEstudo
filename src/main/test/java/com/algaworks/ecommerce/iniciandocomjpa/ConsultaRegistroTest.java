package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ConsultaRegistroTest extends EntityManagerTest {

    @Test
    public void buscarProId(){
        Produto produto = entityManager.find(Produto.class, 1);

        assertNotNull(produto);
        assertEquals(1L, produto.getId().longValue());
    }

    @Test
    public void buscaProIdInexistente(){
        Produto produto = entityManager.find(Produto.class, 2);

        assertNull(produto);
    }



}
