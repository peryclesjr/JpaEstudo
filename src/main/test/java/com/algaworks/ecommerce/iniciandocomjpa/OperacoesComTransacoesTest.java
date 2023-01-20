package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.regex.Matcher;

public class OperacoesComTransacoesTest extends EntityManagerTest {

    @Test
    public void atualizaProduto(){
        Produto produto = entityManager.getReference(Produto.class, 1);
        produto.setNome("Tablet");

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        Produto produtoSalvo = entityManager.find(Produto.class, 1);

        Assert.assertNotNull(produto);
        Assert.assertEquals("Tablet", produtoSalvo.getNome());
    }

    @Test
    public void insertProduto(){
        Produto produto = new Produto( 2, "Tablet",
                "Sanmung tablet S8", new BigDecimal(5900.00));
        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();


        entityManager.clear();

        Produto produtoSalvo = entityManager.find(Produto.class, 2);

        Assert.assertNotNull(produtoSalvo);
        Assert.assertNotEquals("Kindle",produtoSalvo.getNome());
        Assert.assertEquals("Tablet",produtoSalvo.getNome());
        System.out.println(produtoSalvo.getPreco());
        System.out.println(produtoSalvo.getPreco().equals(new BigDecimal(5900.00)));
        Assert.assertTrue(new BigDecimal(5900.00).compareTo(produtoSalvo.getPreco())==0);


    }

    @Test
    public void deleteProduto(){
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();


        Produto produtoSalvo = entityManager.find(Produto.class, 3);

        Assert.assertNull(produtoSalvo);
    }

    @Test
    public void insertProdutoComMerge(){
        Produto produto = new Produto( 4, "Tablet",
                "Sanmung tablet S8 Ultra", new BigDecimal(9900.00));
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();


        entityManager.clear();

        Produto produtoSalvo = entityManager.find(Produto.class, 4);

        Assert.assertNotNull(produtoSalvo);
        Assert.assertNotEquals("Kindle",produtoSalvo.getNome());
        Assert.assertEquals("Tablet",produtoSalvo.getNome());
        System.out.println(produtoSalvo.getPreco());
        Assert.assertTrue(new BigDecimal(9900.00).compareTo(produtoSalvo.getPreco())==0);


    }

    @Test
    public void mostrarDiferencaProdutoComMergePersist(){
        Produto produto = new Produto( 4, "Tablet",
                "Sanmung tablet S8 Ultra", new BigDecimal(9900.00));
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoSalvo = entityManager.find(Produto.class, 4);

        Assert.assertNotNull(produtoSalvo);
        Assert.assertNotEquals("Kindle",produtoSalvo.getNome());
        Assert.assertEquals("Tablet",produtoSalvo.getNome());
        System.out.println(produtoSalvo.getPreco());
        Assert.assertTrue(new BigDecimal(9900.00).compareTo(produtoSalvo.getPreco())==0);


    }

}
