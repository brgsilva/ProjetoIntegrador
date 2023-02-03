package com.generation.melihealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.melihealth.model.Produto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    List<Produto> findAllByEspecialidadeContainingIgnoreCase(@Param("" +
            "especializacao") String especialidade);

}
