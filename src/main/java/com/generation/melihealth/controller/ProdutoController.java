package com.generation.melihealth.controller;

import com.generation.melihealth.model.Produto;
import com.generation.melihealth.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok().body(produtoRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/especialidade/{especialidade}")
    public ResponseEntity<List<Produto>> getByEspecialidade(@PathVariable String especialidade) {
        return ResponseEntity.ok(produtoRepository.findAllByEspecialidadeContainingIgnoreCase(especialidade));

    }

    @PostMapping
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto) {
        getById(produto.getId());
        return produtoRepository.findById(produto.getId()).map(resposta -> ResponseEntity.status(HttpStatus.OK)
                .body(produtoRepository.save(produto))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
