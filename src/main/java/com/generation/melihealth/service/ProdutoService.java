package com.generation.melihealth.service;

import com.generation.melihealth.model.Produto;
import com.generation.melihealth.repository.ProdutoRepository;
import com.generation.melihealth.service.exceptions.DataIntegrityException;
import com.generation.melihealth.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Produto não encontrado: Id " + id ));
    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir um serviço que possui atendimentos pendentes");
        }
    }
}
