package realacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutoRelacionamentoTest extends EntityManagerTest {
    @Test
    public void verificaRelacionamento(){

        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletronicos");

        Categoria categoriaFilha = new Categoria();
        categoriaFilha.setNome("Celulares");
        categoriaFilha.setCategoiraPai(categoriaPai);

        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoriaFilha);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaFilhaTest = entityManager.find(Categoria.class, categoriaFilha.getId());
        Categoria categoriaPaiTEst = entityManager.find(Categoria.class, categoriaPai.getId());


        Assertions.assertEquals(categoriaFilha.getCategoiraPai().getId(), categoriaFilhaTest.getCategoiraPai().getId());
        Assertions.assertNull(categoriaPai.getCategoiraPai());
    }
}
