package com.jb.supermercado.internal.produto.service;

import com.jb.supermercado.config.exception.BusinessException;
import com.jb.supermercado.config.exception.RecursoNaoEncontradoException;
import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.entity.ProdutoEntity;
import com.jb.supermercado.internal.produto.mapper.ProdutoMapperRecord;
import com.jb.supermercado.internal.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoResponseRecord> listarProdutos() {
        List<ProdutoEntity> produtos = this.produtoRepository.findAll();
        return ProdutoMapperRecord.entidadeParaResponseRecordList(produtos);
    }

    public void cadastrarProduto(ProdutoRequestRecord request) {
        if (this.produtoRepository.existsByNome(request.nome())) {
            throw new BusinessException("Já existe um produto cadastrado com este nome");
        }
        ProdutoEntity entity = ProdutoMapperRecord.requestParaEntidade(request);
        this.produtoRepository.save(entity);
    }

    public ProdutoResponseRecord buscarPorId(Long id) {
        ProdutoEntity entity = this.produtoRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Produto não encontrado"));
        return ProdutoMapperRecord.entidadeParaResponse(entity);
    }

    public void atualizarProduto(Long id, ProdutoRequestRecord request) {
        ProdutoEntity entity = this.produtoRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Produto não encontrado"));

        entity.setNome(request.nome());
        entity.setDescricao(request.descricao());
        entity.setPreco(request.preco());
        entity.setQuantidadeEstoque(request.quantidadeEstoque());
        entity.setStatus(request.status());

        this.produtoRepository.save(entity);
    }

    public void removerProduto(Long id) {
        if (!this.produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto não encontrado");
        }
        this.produtoRepository.deleteById(id);
    }
}