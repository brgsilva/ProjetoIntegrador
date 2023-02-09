package com.generation.melihealth.security;

import com.generation.melihealth.model.Usuario;
import com.generation.melihealth.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.findByUsuario(username);

        if(usuario.isPresent()){
            return new UserDetailsImpl(usuario.get());
        }else{
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

    }
}
