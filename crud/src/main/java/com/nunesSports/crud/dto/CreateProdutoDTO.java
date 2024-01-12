package com.nunesSports.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProdutoDTO(
        @NotBlank(message = "O nome do produto não pode ser vazio.")
        String nome,
        @NotBlank(message = "A descrição do produto não pode ser vazia.")
        String descricao,
        @NotNull(message = "O preço do produto não pode ser vazio.")
        BigDecimal preco
) {
}
