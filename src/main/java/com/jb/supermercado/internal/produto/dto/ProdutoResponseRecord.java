package com.jb.supermercado.internal.produto.dto;

import java.math.BigDecimal;

public record ProdutoResponseRecord(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidadeEstoque,
        String status
) {
}