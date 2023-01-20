package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto {
    @Id
    @EqualsAndHashCode.Include
    private  Integer id;
    @EqualsAndHashCode.Include
    private String nome;

    private String descricao;

    private BigDecimal preco;

  }
