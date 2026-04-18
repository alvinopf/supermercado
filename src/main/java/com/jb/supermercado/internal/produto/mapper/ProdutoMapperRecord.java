package com.jb.supermercado.internal.produto.mapper;

import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.entity.ProdutoEntity;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapperRecord {

    public static ProdutoEntity requestParaEntidade(ProdutoRequestRecord request) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setNome(request.nome());
        entity.setDescricao(request.descricao());
        entity.setPreco(request.preco());
        entity.setQuantidadeEstoque(request.quantidadeEstoque());
        entity.setStatus(request.status());
        return entity;
    }

    public static ProdutoResponseRecord entidadeParaResponse(ProdutoEntity entity) {
        return new ProdutoResponseRecord(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getPreco(),
                entity.getQuantidadeEstoque(),
                entity.getStatus()
        );
    }

    public static List<ProdutoResponseRecord> entidadeParaResponseRecordList(List<ProdutoEntity> lista) {
        List<ProdutoResponseRecord> responseList = new ArrayList<>();
        for (ProdutoEntity entity : lista) {
            responseList.add(entidadeParaResponse(entity));
        }
        return responseList;
    }
}