package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name= "seq", sequenceName = "categoria_sequence",initialValue = 4)
    private Integer id;

    private String nome;

    @Column(name= "catwegoria_pai_id")
    private  Integer categiraPaiId;

}
