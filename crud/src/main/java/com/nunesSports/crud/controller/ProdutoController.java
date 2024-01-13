package com.nunesSports.crud.controller;

import com.nunesSports.crud.dto.CreateProdutoDTO;
import com.nunesSports.crud.dto.GetOrUpdateProdutoDTO;
import com.nunesSports.crud.entity.Produto;
import com.nunesSports.crud.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtosService;

    @PostMapping()
    public ResponseEntity create(@RequestBody @Valid CreateProdutoDTO data, UriComponentsBuilder uriBuilder) {
        Produto produtoCriado = new Produto(data);
        Produto produtoSalvo = produtosService.create(produtoCriado);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produtoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(new GetOrUpdateProdutoDTO(produtoSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        GetOrUpdateProdutoDTO produtoDto = new GetOrUpdateProdutoDTO(produtosService.getById(id));
        return ResponseEntity.ok().body(produtosService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtosService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid GetOrUpdateProdutoDTO data) {
        Produto produtoAtualizado = new Produto(data);
        return ResponseEntity.ok().body(produtosService.update(id, produtoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        produtosService.delete(id);
        return ResponseEntity.noContent().build();
    }



}

