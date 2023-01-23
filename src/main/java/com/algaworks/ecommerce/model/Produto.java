package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name= "seq", sequenceName = "produto_sequence",initialValue = 4)
    @EqualsAndHashCode.Include
    private  Integer id;
    @EqualsAndHashCode.Include
    private String nome;

    private String descricao;

    private BigDecimal preco;

  }
