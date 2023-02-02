package realacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class RelacionamentoOneToManytests extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal( BigDecimal.TEN);
        pedido.setStatus(Status.AGUARDANDO);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteTest = entityManager.find(Cliente.class, cliente.getId());

        Assertions.assertNotNull(clienteTest);
        Assertions.assertFalse(clienteTest.getPedidoList().isEmpty());
    }

}
