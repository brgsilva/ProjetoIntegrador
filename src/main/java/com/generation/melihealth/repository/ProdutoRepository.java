package com.generation.melihealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.melihealth.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

}
