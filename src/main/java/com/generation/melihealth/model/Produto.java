package com.generation.melihealth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = ("tb_produto"))
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Size(max = 100)
    private String especialidade;


    @Size(max = 250)
    private String descricao;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataInicio;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataFim;

    //chave estrangeira - relação bidirecional
    @ManyToOne()
    @JsonIgnoreProperties("produto")
    private Categoria categoria;
    // Essa variavel será foreingkey

    //chave estrangeira - relação bidirecional
    @ManyToOne()
    @JsonIgnoreProperties("produto")
    private Usuario usuario;
    // Essa variavel será foreingkey


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
