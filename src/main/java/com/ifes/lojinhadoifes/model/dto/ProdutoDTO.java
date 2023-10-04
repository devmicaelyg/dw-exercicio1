package com.ifes.lojinhadoifes.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProdutoDTO {
    @Column
    private String nome;
    @Column
    private double preco;
}
