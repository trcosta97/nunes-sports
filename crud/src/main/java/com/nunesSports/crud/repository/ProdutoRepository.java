package com.nunesSports.crud.repository;

import com.nunesSports.crud.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
