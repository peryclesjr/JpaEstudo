package com.algaworks.ecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {
    @Id
    @EqualsAndHashCode.Include
    private Integer Id;

    private String nome;

}
