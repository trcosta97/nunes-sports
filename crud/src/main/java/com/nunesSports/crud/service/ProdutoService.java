package com.nunesSports.crud.service;

import com.nunesSports.crud.entity.Produto;
import com.nunesSports.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtosRepository;

    public Produto create (Produto produto) {
        return produtosRepository.save(produto);
    }

    public Produto getById(Long id) {
        return produtosRepository.findById(id).get();
    }

    public List<Produto> getAll() {
        return produtosRepository.findAll();
    }

    public Produto update(Long id, Produto produto) {
        Optional<Produto> produtoOptional = produtosRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produtoData = produtoOptional.get();
            if(produto.getNome() != null) {
                produtoData.setNome(produto.getNome());
            }
            if(produto.getDescricao() != null) {
                produtoData.setDescricao(produto.getDescricao());
            }
            if(produto.getPreco() != null) {
                produtoData.setPreco(produto.getPreco());
            }
            produtosRepository.save(produtoData);
            return produtoData;
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        produtosRepository.deleteById(id);
    }
}
