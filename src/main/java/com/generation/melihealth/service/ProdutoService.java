package com.generation.melihealth.service;

import com.generation.melihealth.model.Produto;
import com.generation.melihealth.repository.ProdutoRepository;
import com.generation.melihealth.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Produto não encontrado: Id " + id ));
    }
}
