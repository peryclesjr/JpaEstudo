package realacionamentos;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.hibernate.type.LocalDateTimeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTests extends EntityManagerTest {

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

        Pedido pedidoTest = entityManager.find(Pedido.class, pedido.getId());

        Assertions.assertNotNull(pedidoTest);
        Assertions.assertEquals(pedido.getCliente().getId(), pedidoTest.getCliente().getId());

    }

    @Test
    public void verificaRelacionamentoItemPedido(){
        Cliente cliente = entityManager.find(Cliente.class , 1);
        Produto produto = entityManager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal( BigDecimal.TEN);
        pedido.setStatus(Status.AGUARDANDO);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(BigDecimal.TEN);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        ItemPedido itemPedidoTest = entityManager.find(ItemPedido.class, itemPedido.getId());

        Assertions.assertNotNull(itemPedidoTest);
        Assertions.assertEquals(itemPedido.getId(), itemPedidoTest.getId());
        Assertions.assertEquals(itemPedido.getPedido().getId(), itemPedidoTest.getPedido().getId());


    }


}
