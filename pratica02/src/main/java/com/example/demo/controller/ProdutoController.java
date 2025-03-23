package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;



@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // GET: retorna TODOS os produtos.
    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    // GET POR ID: retorna um produto específico pelo seu ID.
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.getProdutoById(id);
        return produto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // POST: adiciona um produto.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto addProduto(@RequestBody Produto produto) {
        return produtoService.addProduto(produto);
    }

    // PUT: edita um produto.
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto updateProduto) {
        Optional<Produto> produto = produtoService.updateProduto(id, updateProduto);
        return produto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // DELETE: excluri um produto.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        boolean deletado = produtoService.deleteProduto(id);
        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
