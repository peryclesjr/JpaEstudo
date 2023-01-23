package com.algaworks.ecommerce.model;

import lombok.Data;

import javax.persistence.Embeddable;


@Data
@Embeddable
public class EnderecoEntregaPedido {
    private String logradouro;

    private String complemento;

    private String numero;

    private String cep;

    private String bairro;

    private String Estado;

    private String cidade;

}
