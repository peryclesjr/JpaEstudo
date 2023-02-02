package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name= "seq", sequenceName = "cliente_sequence",initialValue = 4)
    private Integer id;

    private String nome;
    @Enumerated(EnumType.STRING)
    private SexoCliente sexoCliente;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidoList;

}
