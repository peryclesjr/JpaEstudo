package mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.SexoCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testEnum(){
        Cliente cliente = new Cliente(5, "Pedro Percycles", SexoCliente.MASCULINO);
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        //clear memory for search in DB
        entityManager.clear();

        Cliente consulaCliente = entityManager.find(Cliente.class, 5);

        Assertions.assertEquals(cliente.getSexoCliente(), consulaCliente.getSexoCliente());

    }
}
