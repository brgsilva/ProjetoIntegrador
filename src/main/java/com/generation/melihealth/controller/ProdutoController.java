package com.generation.melihealth.controller;

import com.generation.melihealth.model.Produto;
import com.generation.melihealth.repository.CategoriaRepository;
import com.generation.melihealth.repository.ProdutoRepository;
import com.generation.melihealth.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok().body(produtoRepository.findAll());
    }
//
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/especialidade/{especialidade}")
    public ResponseEntity<List<Produto>> getByEspecialidade(@PathVariable String especialidade) {
        return ResponseEntity.ok(produtoRepository.findAllByEspecialidadeContainingIgnoreCase(especialidade));
    }

    @PostMapping
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto){
        if(produtoRepository.existsById(produto.getId())){
             if(categoriaRepository.existsById(produto.getCategoria().getId())){
                    return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
             }
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }*/
}
