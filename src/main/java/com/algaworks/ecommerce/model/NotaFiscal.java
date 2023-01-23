package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name= "seq", sequenceName = "nota_fiscal_sequence",initialValue = 4)
    private Integer id;

    @Column(name = "pedido_id")
    private Integer pedidoId;
    private String xml;
    private Date dataEmissao;

}
