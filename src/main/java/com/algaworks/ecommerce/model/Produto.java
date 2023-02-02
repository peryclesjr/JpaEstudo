package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name= "produto_categoria",
    joinColumns = @JoinColumn(name= "produto_id"),
    inverseJoinColumns = @JoinColumn(name= "categoria_id"))
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itemPedido;

    @OneToOne(mappedBy = "produto")
    private Estoque estoque;
  }
