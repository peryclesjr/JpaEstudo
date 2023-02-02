package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name= "seq", sequenceName = "pedido_sequence",initialValue = 4)
    private Integer id;
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;
    private LocalDateTime dataconclusao;

    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notaFiscal;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;
    @OneToMany(mappedBy = "pedido" )
    @Column(name = "item_pedido")
    private List<ItemPedido> itemPedidoList;

    private BigDecimal total;
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamento;

}
