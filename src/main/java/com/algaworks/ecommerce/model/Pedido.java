package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private LocalDateTime dataPedido;
    private LocalDateTime dataconclusao;
    @Column(name = "notafiscal_id")
    private Integer notaFiscalId;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;

    private BigDecimal total;

}
