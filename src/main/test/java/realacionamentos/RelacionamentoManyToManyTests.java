package realacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RelacionamentoManyToManyTests extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){

        Produto produto = entityManager.find(Produto.class, 1);
        Categoria categoria = entityManager.find(Categoria.class, 1);

        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(categoria);

        produto.setCategorias(categoriaList);

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoTest = entityManager.find(Produto.class, produto.getId());
        Categoria categoriaTest = entityManager.find(Categoria.class, categoria.getId());

        Assertions.assertNotNull(produtoTest);
        Assertions.assertFalse(categoriaTest.getProdutos().isEmpty());


    }




}
