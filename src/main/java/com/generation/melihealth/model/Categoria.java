package com.generation.melihealth.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

<<<<<<< HEAD

=======
>>>>>>> origin/main
@Entity
@Table(name = ("tb_categoria"))
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String tipo;

    public Long getId() {
<<<<<<< HEAD
        return this.id;
=======
        return id;
>>>>>>> origin/main
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
<<<<<<< HEAD
        return this.tipo;
=======
        return tipo;
>>>>>>> origin/main
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
<<<<<<< HEAD

=======
>>>>>>> origin/main
}
