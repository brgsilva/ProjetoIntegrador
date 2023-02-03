package com.generation.melihealth.controller;

import com.generation.melihealth.model.Produto;
import com.generation.melihealth.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok().body(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto>getById(@PathVariable Long id){
        return produtoRepository.findById(id).map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @GetMapping("/especialidade/{especialidade}")
    public ResponseEntity<List<Produto>> getByEspecialidade(@PathVariable String especialidade){
        return ResponseEntity.ok(produtoRepository
                .findAllByEspecialidadeContainingIgnoreCase(especialidade));
    }

    @PostMapping
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoRepository.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto){
        getById(produto.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoRepository.save(produto));

    }


}
