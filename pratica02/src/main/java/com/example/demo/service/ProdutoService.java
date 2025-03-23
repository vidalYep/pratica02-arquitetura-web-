package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;


@Service
public class ProdutoService{

    private List<Produto> produtos = new ArrayList<>();
    private Long nextId = 1L;
    

    // GET: Método para retornar TODOS os produtos
    public List<Produto> getAllProdutos(){
        return produtos;
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtos.stream()
            .filter(produto -> produto.getId().equals(id))
            .findFirst();
    }
    

    // POST: Método para adicionar um produto.
    public Produto addProduto(Produto produto){
        produto.setId(nextId++);
        produtos.add(produto);
        return produto;
    }

    // PUT: Método para editar um produto
    public Optional<Produto> updateProduto(Long id, Produto updateProduto) {
        Optional<Produto> produtoExistente = getProdutoById(id);

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setName(updateProduto.getName()); 
            return Optional.of(produto);
        }
        return Optional.empty();
    }
    // DELETE: Método para excluir um produto.
    public boolean deleteProduto(Long id) {
        Optional<Produto> produto = getProdutoById(id);
        if (produto.isPresent()) {
            produtos.remove(produto.get());
            return true;
        }
        return false;
    }
}