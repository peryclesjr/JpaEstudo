package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name= "categoria_pai_id")
    private  Categoria categoiraPai;

    @OneToMany(mappedBy = "categoiraPai")
    private List<Categoria> categorias;
    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;

}
