package com.nunesSports.crud.entity;

import com.nunesSports.crud.dto.CreateProdutoDTO;
import com.nunesSports.crud.dto.GetOrUpdateProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "produto")
@Table(name = "tb_produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_produto")
    private Long id;
    @Column(name = "nm_produto", nullable = false, length = 150)
    private String nome;
    @Column(name = "dc_produto", nullable = false, length = 255)
    private String descricao;
    @Column(name = "pr_produto", nullable = false)
    private BigDecimal preco;

    public Produto(CreateProdutoDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.preco = data.preco();
    }

    public Produto(GetOrUpdateProdutoDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.preco = new BigDecimal(data.preco());
    }
}
