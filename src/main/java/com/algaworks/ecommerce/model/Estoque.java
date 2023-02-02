package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estoque")
public class Estoque {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name= "seq", sequenceName = "estoque_sequence",initialValue = 4)
    @EqualsAndHashCode.Include
    private Integer Id;
    @OneToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private Integer quatidade;
}
