package com.generation.melihealth.service;

import com.generation.melihealth.model.Usuario;
import com.generation.melihealth.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Optional<Usuario> cadastrarUsuario(Usuario usuario){



    }

}
