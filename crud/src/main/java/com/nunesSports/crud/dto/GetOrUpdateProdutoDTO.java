package com.nunesSports.crud.dto;

import com.nunesSports.crud.entity.Produto;

public record GetOrUpdateProdutoDTO(
        String nome,
        String descricao,
        String preco
) {
    public GetOrUpdateProdutoDTO(Produto data) {
        this(data.getNome(), data.getDescricao(), data.getPreco().toString());
    }
}
